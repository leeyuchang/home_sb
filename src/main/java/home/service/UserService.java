package home.service;

import java.util.List;

import home.model.User;

public interface UserService {

	public List<User> findAll();
	public User findOne(String id);
	public User create(User user);
	public User update(User user);
	public void delete(String id);

}
