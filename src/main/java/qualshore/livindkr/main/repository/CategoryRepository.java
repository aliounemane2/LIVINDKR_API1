package qualshore.livindkr.main.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import qualshore.livindkr.main.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public List<Category> findAll();
	public List<Category> findByIdCategory(Category id);
	
}
