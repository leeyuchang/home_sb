package homepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import homepage.model.Item;
import homepage.repository.ItemRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository repository;

	@Override
	public List<Item> findAll() {
		return repository.findAll();
	}

	@Override
	public Item findOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public Item create(Item item) {
		return repository.save(item);
	}

	@Override
	public Item update(Item item) {
		return repository.save(item);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
