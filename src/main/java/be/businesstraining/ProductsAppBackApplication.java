package be.businesstraining;

import be.businesstraining.domain.security.Authority;
import be.businesstraining.domain.security.AuthorityName;
import be.businesstraining.domain.security.User;
import be.businesstraining.security.repository.AuthorityRepository;
import be.businesstraining.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ProductsAppBackApplication {

    @Autowired
    private UserRepository repoUser;

    @Autowired
    private AuthorityRepository repoAuthority;


    public static void main(String[] args) {
        SpringApplication.run(ProductsAppBackApplication.class, args);
    }



//    @Bean
//    PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }

//	@Bean
//    CommandLineRunner runIt() {
//
//		return args -> {
//
//            System.out.println("============================================================");
//            User user = new User();
//            user.setUsername("user");
//            user.setPassword(encoder().encode("password"));
//            user.setAuthorities(new ArrayList<Authority>());
//            user.setEmail("user@user.com");
//            user.setEnabled(true);
//            user.setFirstname("User Firstname");
//            user.setLastname("User Lastname");
//            user.setLastPasswordResetDate(new Date());
//
//
//            User admin = new User();
//            admin.setUsername("admin");
//            admin.setPassword(encoder().encode("admin"));
//            admin.setAuthorities(new ArrayList<>());
//            admin.setEmail("admin@admin.com");
//            admin.setEnabled(true);
//            admin.setFirstname("Admin Firstname");
//            admin.setLastname("Admin Lastname");
//            admin.setLastPasswordResetDate(new Date());
//
//
//            Authority authorityUser = new Authority();
//            authorityUser.setName(AuthorityName.ROLE_USER);
//            authorityUser.setUsers(new ArrayList<User>());
//
//            Authority authorityAdmin = new Authority();
//            authorityAdmin.setName(AuthorityName.ROLE_ADMIN);
//            authorityAdmin.setUsers(new ArrayList<User>());
//
//            user.getAuthorities().add(authorityUser);
//            authorityUser.getUsers().add(user);
//
//            admin.getAuthorities().add(authorityAdmin);
//            authorityAdmin.getUsers().add(admin);
//
//            repoAuthority.save(authorityUser);
//            repoUser.save(user);
//
//            repoAuthority.save(authorityAdmin);
//            repoUser.save(admin);
//        };
//
// }

}
