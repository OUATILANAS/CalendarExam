package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import com.fasterxml.jackson.annotation.JsonFormat;



import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	 protected boolean credentialsNonExpired;
	 protected boolean enabled;
	    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
	    @Temporal(TemporalType.TIMESTAMP)
	    protected Date createdAt;
	    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
	    @Temporal(TemporalType.TIMESTAMP)
	    protected Date updatedAt;
	    protected String email;
	    protected boolean accountNonExpired;
	    protected boolean accountNonLocked;
	    protected String username;
	    protected String password;
	    protected String prenom;
	    protected String nom;
	    protected String tel;
	    protected boolean passwordChanged;
	
	
	
	
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    protected Collection<Role> roles = new ArrayList<>();



	    @Transient
	    protected Collection<Role> authorities;

	        public Personne() {
	            super();
	        }
	        public Personne(String username) {
	        this.username = username;
	        this.password=username;
	        this.prenom=username;
	        this.nom=username;
	        this.email=username;
	        }

	
	public boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean getPasswordChanged() {
        return passwordChanged;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }



    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    /*public Collection<Role> getAuthorities() {
        if(this.authorities == null)
        this.authorities =  this.roles;

        return authorities;
     }*/

    public void setAuthorities(Collection<Role> authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.authorities == null)
            this.authorities =  this.roles;

            return (Collection<? extends GrantedAuthority>) authorities;
	}

}



	
	
	
	
	


