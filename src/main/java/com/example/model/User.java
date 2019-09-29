package com.example.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	String ROLE_PREFIX = "ROLE_";
	Collection<? extends GrantedAuthority> authorities;

	public User() {

	}

	public User(String username, String password, Collection<String> roles) {
		this.username = username;
		this.password = password;
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
		}
		this.authorities = authorities;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
