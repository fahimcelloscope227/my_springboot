package  com.example.ecom_app.basic_ecom.domain.ports.output;

import java.util.Optional;

import com.example.ecom_app.basic_ecom.domain.dto.User;


public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(String email);   
    Boolean existsByEmail(String email);
}
