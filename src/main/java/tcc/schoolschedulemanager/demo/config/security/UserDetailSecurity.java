package tcc.schoolschedulemanager.demo.config.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;



@Service
@Transactional
public class UserDetailSecurity implements UserDetailsService{

    private final UserRepository userRepository;

    public UserDetailSecurity(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String registrationNumbe) throws UsernameNotFoundException {

        UserModel user = userRepository.findByRegistrationNumber(registrationNumbe)
        .orElseThrow(() -> new UsernameNotFoundException("User not found" + registrationNumbe));

            return new User(user.getRegistrationNumber(), user.getPassword(),user.getAuthorities());

    }
    
}
