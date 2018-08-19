package home.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import home.model.Link;
import home.service.LinkService;

/*
 * TODO : 戻り値がある場合、ない場合の使い分けを整理する。　	デザイン観点で考慮する。
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/link")
public class LinkRestController {

	@Autowired
	private LinkService linkService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<Link> getLinks() {
		return linkService.findAll();
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	Link getLink(@PathVariable Integer id) {
		return linkService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Link postLink(@RequestBody Link link) {
		return linkService.create(link);
	}

	@PostMapping(path = "{id}")
	@ResponseStatus(HttpStatus.OK)
	Link putLink(@PathVariable Integer id, @RequestBody Link link) {
		return linkService.update(link);
	}

	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	Link delete(@PathVariable Integer id) {
		return linkService.delete(id);
	}
}
