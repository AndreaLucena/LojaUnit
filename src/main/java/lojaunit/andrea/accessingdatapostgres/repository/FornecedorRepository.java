package lojaunit.andrea.accessingdatapostgres.repository;

import org.springframework.data.repository.CrudRepository;

import lojaunit.andrea.accessingdatapostgres.model.Fornecedor;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer>{

}
