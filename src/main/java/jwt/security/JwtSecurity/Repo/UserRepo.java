package jwt.security.JwtSecurity.Repo;

import jwt.security.JwtSecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
