package sg.edu.ntu.m3project.m3project.authentication;

import com.sun.security.auth.UserPrincipal;

import sg.edu.ntu.m3project.m3project.entity.User;
import sg.edu.ntu.m3project.m3project.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    private static final String DEFAULT_ROLE = "USER";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException("User not Found");
        }

        System.out.println(user);
        UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(email);
        builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));

        builder.roles(DEFAULT_ROLE);
        UserDetails test = builder.build();
        System.out.println(test.getPassword());
        return test;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

}