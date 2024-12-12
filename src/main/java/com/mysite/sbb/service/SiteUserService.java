package com.mysite.sbb.service;

import com.mysite.sbb.exceptions.DataNotFoundException;
import com.mysite.sbb.entity.SiteUser;
import com.mysite.sbb.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author shjung
 * @since 24. 12. 11.
 */
@RequiredArgsConstructor
@Service
public class SiteUserService {

    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password){
        SiteUser siteUser = new SiteUser();
        siteUser.setUsername(username);
        siteUser.setEmail(email);
        siteUser.setPassword(passwordEncoder.encode(password));
        return siteUserRepository.save(siteUser);
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.siteUserRepository.findByUsername(username);
        if(siteUser.isPresent()){
            return siteUser.get();
        }else{
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
