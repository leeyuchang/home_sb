package homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import homepage.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
