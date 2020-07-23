package ma.nt.data.mongo.crud.configuration;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ma.nt.data.mongo.crud.entities.Company;
import ma.nt.data.mongo.crud.repository.CompanyRepository;

@Configuration
public class CustomCompanyConfig {
	
	
	private CompanyRepository companyRepository;
	
	private List<Company> companies;
	
	public CustomCompanyConfig(CompanyRepository companyRepository)
	{
		this.companyRepository=companyRepository;
	}
	
	@PostConstruct
	public void init()
	{
		companies=Arrays.asList(new Company(null,"NT Data","sarl",25),
				new Company(null,"Google","sa",25),
				new Company(null,"AliBaba","sa",10),
				new Company(null,"Facebook","sa",30),
				new Company(null,"Facebook","sa",10));
	}
	
	@Bean
	public CommandLineRunner customRunner()
	{
		return args->{
			 
			this.companyRepository.saveAll(companies);
		};
	}
}