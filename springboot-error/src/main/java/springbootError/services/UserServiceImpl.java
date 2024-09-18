package springbootError.services;


import org.springframework.stereotype.Service;
import springbootError.models.domain.Role;
import springbootError.models.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;
    public UserServiceImpl() {
        this.users= new ArrayList<>();
        users.add(new User(1L,"Juan", "Perez", new Role("admin")));
        users.add(new User(2L,"Pedro", "Garcia", new Role("admin")));
        users.add(new User(3L,"Mario", "Hernandez", new Role("user")));
        users.add(new User(4L,"Ignacio", "Gutierrez", new Role("user")));
        users.add(new User(5L,"Maria", "Perez", new Role("admin")));

    }

    @Override
    public List<User> findAll() {
        return users;
    }
    @Override
    public User findById(Long id) {
        if (users == null || users.isEmpty()) {
            throw new IllegalStateException("La lista de usuarios está vacía o no ha sido inicializada");
        }

        for (User u : users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }

        throw new NoSuchElementException("Usuario con id " + id + " no encontrado");
    }


}
