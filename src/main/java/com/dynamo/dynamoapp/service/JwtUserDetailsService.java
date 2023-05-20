package com.dynamo.dynamoapp.service;

import com.dynamo.dynamoapp.dto.UserInfoUserDetails;
import com.dynamo.dynamoapp.entity.UserInfo;
import com.dynamo.dynamoapp.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserInfoRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userRepository.findByName(userName);
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new RuntimeException("user not found " + userName));
    }
}
