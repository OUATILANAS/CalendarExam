package com.example.demo.common;
import java.util.stream.Stream;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.CalendarApplication;
import com.example.demo.entities.Personne;
import com.example.demo.iservice.IUserService;
import com.example.demo.services.PersonneService;


@Service
public class SecurityUtil {
	 public static Personne getCurrentUser() {
		 
		
	        PersonneService userService= CalendarApplication.getCtx().getBean(PersonneService.class);

	        SecurityContext securityContext = SecurityContextHolder.getContext();
	        Object user = securityContext.getAuthentication().getPrincipal();
	        System.out.println(user);
	        if (user instanceof String) {
	            return userService.findByUsername((String) user);
	        } else if (user instanceof Personne) {
	            return (Personne) user;
	        } else {
	            return null;
	        }
	    }


	    public static boolean isAuthenticated() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        return authentication != null &&
	        getAuthorities(authentication).noneMatch(AuthoritiesConstants.ANONYMOUS::equals);
	    }


	    public static boolean isCurrentUserInRole(String authority) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        return authentication != null &&
	        getAuthorities(authentication).anyMatch(authority::equals);
	    }

	    private static Stream<String> getAuthorities(Authentication authentication) {
	        return authentication.getAuthorities().stream()
	        .map(GrantedAuthority::getAuthority);
	        }


}
