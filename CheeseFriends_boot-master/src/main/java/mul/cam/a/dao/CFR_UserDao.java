package mul.cam.a.dao;

import java.util.List;

import mul.cam.a.dto.CFR_User;

public interface CFR_UserDao {
    CFR_User getUserById(String id);
    List<CFR_User> getAllUsers();
    void addUser(CFR_User user);
    void updateUser(CFR_User user);
    void deleteUser(String id);
}

