package dao;

import entity.User;

public interface UserDao {
	User queryOneByAccount(String account) throws Exception;

	User queryOneByPhone(String phone) throws Exception;

	User login(String account, String pwd) throws Exception;

	User register(User user) throws Exception;
}
