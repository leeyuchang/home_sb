package home.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "")
public class BaseRestController {

	@RequestMapping(method = RequestMethod.GET)
	public String curl() {
		return "ok";
	}
}
