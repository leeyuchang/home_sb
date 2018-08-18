package homepage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import homepage.model.User;
import homepage.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	List<User> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	User getUser(@PathVariable String id) {
		return userService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	User postUser(@RequestBody User user) {
		return userService.create(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	User putUser(@PathVariable String id, @RequestBody User user) {
		user.setId(id);
		return userService.update(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable String id) {
		userService.delete(id);
	}
}