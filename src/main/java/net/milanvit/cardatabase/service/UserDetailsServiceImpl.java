package net.milanvit.cardatabase.service;

import net.milanvit.cardatabase.domain.User;
import net.milanvit.cardatabase.domain.UserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = repository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(),
            true, true, true, true,
            AuthorityUtils.createAuthorityList(currentUser.getRole()));
    }
}
