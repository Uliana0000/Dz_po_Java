package com.example.demo;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@interface GetMapping {
}
@interface PostMapping {
}
@interface PutMapping {
}
@interface DeleteMapping {
}
@Repository
class UserRepository  {
    public Optional<Course> findById(Long id) {
        return Optional.empty();
    }
    public void save(Course user) {
    }
    public void delete(Course user) {
    }
}
public class APIController {

    UserRepository userRepository= new UserRepository();
    @GetMapping
    public Object getUserById(Long id) {
        Optional<Course> user = userRepository.findById(id);
        return user.getClass();
    }

    @PostMapping
    public String createUser(Course user) {
        userRepository.save(user);
        return user.getName();
    }

    @PutMapping
    public String updateUser(Long id, Course user) {
        Optional<Course> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            Course updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setHours(user.getHours());
            userRepository.save(updatedUser);
            return user.getName();
        } else {
            return user.notFound();
        }
    }

    @DeleteMapping
    public void deleteUser(Long id) {
        Optional<Course> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            System.out.println("Пользователь удалён");
        } else {
            user.notify();
        }
    }
}
