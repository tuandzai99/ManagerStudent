package com.tuanother.services.impls;


import com.tuanother.models.Admin;
import com.tuanother.repositorys.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
@Service
public class AdminDetailServiceImpl implements UserDetailsService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException  {
        Admin admin=adminRepository.findByUsername(s);
        if(admin == null) {
            throw new UsernameNotFoundException("Not Foud");
        }
        return new AdminServiceImplSecurity(admin);
    }
}
