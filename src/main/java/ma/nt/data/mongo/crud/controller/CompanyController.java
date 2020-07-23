package ma.nt.data.mongo.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.nt.data.mongo.crud.entities.Company;
import ma.nt.data.mongo.crud.repository.CompanyRepository;

@RestController
@CrossOrigin("*")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/companies")
	public List<Company> getAllCompanies(){
		return companyRepository.findAll();
	}
	
	@PostMapping("/companies")
	public Company postCompany(@RequestBody Company company) {
		return companyRepository.save(company);
	}
	
	@PutMapping("/companies/{id}")
	public Company putCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		company.setId(id);
		return companyRepository.save(company);
	}
	
	@GetMapping("/companies/{id}")
	public ResponseEntity<?> getCompany(@PathVariable("id") Long id) {
		Optional<Company> companyOpt = companyRepository.findById(id);
		if(companyOpt.isPresent()) {
			Company company = companyOpt.get();
			return ResponseEntity.ok(company);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/companies/{id}")
	public ResponseEntity<Company> deleteCompay(@PathVariable("id") Long id) {
		Optional<Company> companyOpt = companyRepository.findById(id);
		if(companyOpt.isPresent()) {
			companyRepository.delete(companyOpt.get());
			return ResponseEntity.ok(companyOpt.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	
}
