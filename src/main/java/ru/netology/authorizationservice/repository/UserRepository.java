package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.enumAuthorities.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        Map<String, String> users = new ConcurrentHashMap<>();
        users.put("Admin", "111");
        users.put("Client", "222");
        if (users.containsKey(user) && users.get(user).equals(password)) {
            if (user.equals("Admin")) {
                list.add(Authorities.WRITE);
                list.add(Authorities.READ);
                list.add(Authorities.DELETE);
            } else {
                list.add(Authorities.WRITE);
            }
        }
        return list;
    }
}

