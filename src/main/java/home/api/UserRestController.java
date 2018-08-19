package home.api;

import java.util.List;

import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home.model.User;
import home.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<User> getUsers() {
		return userService.findAll();
	}

	@GetMapping(path = "{id}")
	@ResponseStatus(HttpStatus.OK)
	User getUser(@PathVariable String id) {
		return userService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	User postUser(@RequestBody User user) {
		return userService.create(user);
	}

	@PutMapping(path = "{id}")
	@ResponseStatus(HttpStatus.OK)
	User putUser(@PathVariable String id, @RequestBody User user) {
		user.setId(id);
		return userService.update(user);
	}

	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	User delete(@PathVariable String id) {
		return userService.delete(id);
	}
}