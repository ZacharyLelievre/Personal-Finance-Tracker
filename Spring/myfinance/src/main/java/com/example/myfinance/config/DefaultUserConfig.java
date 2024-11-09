import com.example.myfinance.Model.MyAppUser;
import com.example.myfinance.Model.MyAppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DefaultUserConfig {

    @Bean
    CommandLineRunner createDefaultAdmin(MyAppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                MyAppUser admin = new MyAppUser();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Admin user created with username 'admin' and password 'admin123'");
            } else {
                System.out.println("Admin user already exists.");
            }
        };
    }
}