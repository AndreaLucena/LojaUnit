package lojaunit.andrea.accessingdatapostgres.repository;

import org.springframework.data.repository.CrudRepository;

import lojaunit.andrea.accessingdatapostgres.model.Categoria;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, R@Entity // This tells Hibernate to make a table out of this classead, Update, Delete

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
	
	}
