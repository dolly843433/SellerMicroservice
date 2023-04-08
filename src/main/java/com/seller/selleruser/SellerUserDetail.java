package com.seller.selleruser;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.seller.entity.Model;


@Component
public class SellerUserDetail  implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6767571603537685478L;
	
	Model model;
	
	

	public SellerUserDetail(Model model) {
		super();
		this.model = model;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("user"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return model.getPassword() ;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return model.getEmail_id();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}


