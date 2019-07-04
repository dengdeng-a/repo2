package com.imooc.mvcmodeo.object;

import java.util.List;

public class UserListForm {
    private List<User> users;

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
