package jwt.security.JwtSecurity.service;

import jwt.security.JwtSecurity.domain.Role;
import jwt.security.JwtSecurity.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
