package com.example.demo.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.jwt.JwtUtils;
import com.example.demo.models.ERole;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.SignupRequest;
import com.example.demo.response.JwtResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.services.ChangePasswordRequest;
import com.example.demo.services.UserDetailsImpl;
import com.example.demo.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  private UserService userService;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
  //===========================================
  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }
  
  @GetMapping("/users")
  //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<List<User>> findAllUsers() {
      List<User> users = userRepository.findAll();
      return ResponseEntity.ok(users);
  }

  @PostMapping("/create")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
      if (userRepository.existsByUsername(signUpRequest.getUsername())) {
          return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
      }

      if (userRepository.existsByEmail(signUpRequest.getEmail())) {
          return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
      }

      // Create new user's account
      User user = new User(signUpRequest.getUsername(), 
          signUpRequest.getEmail(),
          encoder.encode(signUpRequest.getPassword()));

      Set<String> strRoles = signUpRequest.getRole();
      Set<Role> roles = new HashSet<>();

      if (strRoles == null) {
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
      } else {
          strRoles.forEach(role -> {
              switch (role) {
                  case "admin":
                      Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                      roles.add(adminRole);
                      break;
                  case "prof":
                      Role profRole = roleRepository.findByName(ERole.ROLE_PROF)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                      roles.add(profRole);
                      break;
                  case "etudiant":
                      Role etudiantRole = roleRepository.findByName(ERole.ROLE_ETUDIANT)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                      roles.add(etudiantRole);
                      break;
                  default:
                      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                      roles.add(userRole);
              }
          });
      }

      user.setRoles(roles);
      user.setMatricule(signUpRequest.getMatricule());
      user.setNom(signUpRequest.getNom());
      user.setPrenom(signUpRequest.getPrenom());
      user.setTelephone(signUpRequest.getTelephone());
      userRepository.save(user);

      return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  
  
  
  @PutMapping("/users/{userId}/password")
  public ResponseEntity<?> updatePassword(
      @PathVariable Long userId,
      @Valid @RequestBody ChangePasswordRequest updatePasswordRequest) {

      User user = userRepository.getReferenceById(userId);
         
      if (!passwordEncoder.matches(updatePasswordRequest.getOldPassword(), user.getPassword())) {
          throw new BadCredentialsException("Invalid old password");
      }

      user.setPassword(passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
      userRepository.save(user);

      return ResponseEntity.ok(new MessageResponse("Password updated successfully"));
  }
  
}
