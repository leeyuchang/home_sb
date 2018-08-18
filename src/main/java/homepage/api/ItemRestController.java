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

import homepage.model.Item;
import homepage.service.ItemService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/items")
public class ItemRestController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	List<Item> getItems() {
		return itemService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Item getItem(@PathVariable Integer id) {
		return itemService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	Item postItem(@RequestBody Item item) {
		return itemService.create(item);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	Item putItem(@PathVariable Integer id, @RequestBody Item item) {
		return itemService.update(item);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable Integer id) {
		itemService.delete(id);
	}

}
