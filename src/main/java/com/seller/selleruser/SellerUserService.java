package com.seller.selleruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seller.entity.Model;
import com.seller.repository.Repository;

@Service
public class SellerUserService implements UserDetailsService {
	
	@Autowired
	public Repository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Model model=(Model) repo.findById(username).get();
		
		return new SellerUserDetail(model);
	}


}
