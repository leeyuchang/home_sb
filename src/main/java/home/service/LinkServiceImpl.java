package home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import home.model.Link;
import home.repository.LinkRepository;

@Service
@Transactional
public class LinkServiceImpl implements LinkService {

	@Autowired
	LinkRepository repository;

	@Override
	public List<Link> findAll() {
		return repository.findAll();
	}

	@Override
	public Link findOne(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public Link create(Link link) {
		return repository.save(link);
	}

	@Override
	public Link update(Link link) {
		return repository.save(link);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
