package springbootError.services;

import springbootError.models.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
