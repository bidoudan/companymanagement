package ma.nt.data.mongo.crud.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class CommandByMonth {

	@Id
	private int id;
	private int month;
	private int nbrCommands;
}
