package homepage.service;

import java.util.List;

import homepage.model.User;

public interface UserService {

	public List<User> findAll();
	public User findOne(String id);
	public User create(User user);
	public User update(User user);
	public void delete(String id);

}
