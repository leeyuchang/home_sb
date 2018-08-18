package home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.model.Link;

public interface LinkRepository extends JpaRepository<Link, Integer> {
}
