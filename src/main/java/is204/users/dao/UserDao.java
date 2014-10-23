package is204.users.dao;

import is204.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}