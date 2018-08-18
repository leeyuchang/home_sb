package home.api;

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

import home.model.Link;
import home.service.LinkService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/link")
public class ItemRestController {

	@Autowired
	private LinkService linkService;

	@RequestMapping(method = RequestMethod.GET)
	List<Link> getItems() {
		return linkService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Link getItem(@PathVariable Integer id) {
		return linkService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	Link postItem(@RequestBody Link link) {
		return linkService.create(link);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	Link putItem(@PathVariable Integer id, @RequestBody Link link) {
		return linkService.update(link);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable Integer id) {
		linkService.delete(id);
	}

}
