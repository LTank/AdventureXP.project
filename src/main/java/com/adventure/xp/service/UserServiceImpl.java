package com.adventure.xp.service;

import com.adventure.xp.dao.repositories.UserRepo;
import com.adventure.xp.models.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.adventure.xp.models.User user = userRepository.readByUsername(s);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

        CustomUserDetails userDetails = new CustomUserDetails(buildUserForAuthentication(user, authorities),user.getId(), authorities);

        return userDetails;
    }

    private User buildUserForAuthentication(com.adventure.xp.models.User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), (user.getEnabled()==1), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(String role) {
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        System.out.println(authority.getAuthority().toString());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(authority);
        return grantedAuthorities;
    }


}
