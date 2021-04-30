package com.example.demo.auth;

import com.example.demo.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter( applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(ApplicationUserRole.STUDENT.getGrantedAuthorities(), passwordEncoder.encode("12121212"), "annas", true, true, true, true),
                new ApplicationUser(ApplicationUserRole.ADMIN.getGrantedAuthorities(), passwordEncoder.encode("pass1111"), "arsen", true, true, true, true),
        new ApplicationUser(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(), passwordEncoder.encode("11112222"), "tomy", true, true, true, true)
        );
   return applicationUsers; }
}
