package homepage.service;

import java.util.List;

import homepage.model.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findOne(Integer id);
	public Item create(Item item);
	public Item update(Item item);
	public void delete(Integer id);
	
}
