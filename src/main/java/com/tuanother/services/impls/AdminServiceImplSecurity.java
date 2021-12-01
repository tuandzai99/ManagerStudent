package com.tuanother.services.impls;

import com.tuanother.models.Admin;
import com.tuanother.models.AdminRole;
import com.tuanother.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AdminServiceImplSecurity implements UserDetails {

    private Admin admin;

    public AdminServiceImplSecurity(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Set<Role> roles= admin.getRoles();
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
