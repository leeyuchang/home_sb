package home.service;

import java.util.List;

import home.model.Link;

public interface LinkService {
	
	public List<Link> findAll();
	public Link findOne(Integer id);
	public Link create(Link link);
	public Link update(Link link);
	public Link delete(Integer id);
	
}
