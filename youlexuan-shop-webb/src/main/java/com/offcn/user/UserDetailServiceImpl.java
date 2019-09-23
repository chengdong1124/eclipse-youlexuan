package com.offcn.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.offcn.pojo.TbSeller;
import com.offcn.service.SellerService;

public class UserDetailServiceImpl implements UserDetailsService {

	
	private SellerService sellerService;
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> list = new ArrayList();
		
		list.add(new SimpleGrantedAuthority("ROLE_SHOP"));
		
		TbSeller seller = sellerService.findOne(username);
		
		if (seller != null) {
			if (seller.getStatus().equals("1")) {
				return new User(username, seller.getPassword(), list);
			} else {
				return null;
			}
		}
		return null;
	}

}

































