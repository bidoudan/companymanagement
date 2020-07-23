package ma.nt.data.mongo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.nt.data.mongo.crud.entities.Command;
import net.minidev.json.JSONObject;

public interface CommandRepository extends JpaRepository<Command, Long>{

	@Query("SELECT MONTHNAME(date) as month, COUNT(*) as nbrCommands "
			+ "FROM Command c "
			+ "WHERE YEAR(date)=:year "
			+ "GROUP BY MONTHNAME(date) "
			+ "ORDER BY MONTH(date)")
	public List<JSONObject> getNbCommandByYear(@Param("year") int year);
	
	@Query("SELECT QUARTER(date) as quarter, COUNT(*) as nbrCommands "
			+ "FROM Command " 
	        + "WHERE YEAR(date)=:year "
			+" GROUP BY  QUARTER(date)")
	public List<JSONObject> getNbrCommandsByTrimester(@Param("year") int year);
}
