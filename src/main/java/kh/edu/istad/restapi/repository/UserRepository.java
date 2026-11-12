package kh.edu.istad.restapi.repository;

import kh.edu.istad.restapi.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public class UserRepository {

    private static List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        // Fixed: Removed trailing commas
        User usrAdmin = new User(UUID.randomUUID(), "Administrator", "admin", "qwer", true);
        User usrEditor = new User(UUID.randomUUID(), "Editor", "editor", "qwer", false);
        User usrCustomer = new User(UUID.randomUUID(), "chan dara", "chan dara", "qwar", true);

        users.add(usrAdmin);
        users.add(usrEditor);
        users.add(usrCustomer);
    }

    public List<User> getAll() {
        return users;
    }

    public Optional<User> selectById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }


    public void insert(User user) {
        users.add(user);
    }
    public static boolean deleteById(UUID id) {
        return users.removeIf(
                user -> user.getId().equals(id)
        );
    }



}