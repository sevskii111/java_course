package com.labs.Lab8;

import java.util.ArrayList;
import java.util.List;

public class UserBase {
    private UserBase() {}

    public static UserBase getInstance() {
        if (instance == null) {
            instance = new UserBase();
            userList = new ArrayList<>();
        }
        return instance;
    }

    public boolean is_login_busy(String login) {
        for (User user: userList)
        {
            if (user.getLogin().equals(login))
            {
                return true;
            }
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }

    private static UserBase instance;
    private static List<User> userList;
}