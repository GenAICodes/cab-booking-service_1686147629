
package com.online.cab.dao;

import com.online.cab.entity.User;

public interface UserDao {
    User save(User user);
    User update(User user);
    User findById(Long id);
}
