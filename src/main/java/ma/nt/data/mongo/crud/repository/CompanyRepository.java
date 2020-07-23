package ma.nt.data.mongo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.nt.data.mongo.crud.entities.Company;

//@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
