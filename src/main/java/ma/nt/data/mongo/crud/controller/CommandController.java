package ma.nt.data.mongo.crud.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ma.nt.data.mongo.crud.entities.Command;
import ma.nt.data.mongo.crud.repository.CommandRepository;
import net.minidev.json.JSONObject;

@RestController
@CrossOrigin("*")
public class CommandController {

	@Autowired
	private CommandRepository commandRepository;
	
	@PostMapping("/commands")
	public Command postCommand(@RequestBody Command command) {
		return commandRepository.save(command);
	}
	@GetMapping("/commands")
	public List<Command> getCommands(){
		return commandRepository.findAll();
	}
	@GetMapping("/commands/{year}")
	public List<JSONObject> getNbCommandByYear(@PathVariable int year){
		System.out.println(commandRepository.getNbCommandByYear(year));
		return commandRepository.getNbCommandByYear(year);
	}
	
	@GetMapping("commands/trimester/{year}")
	public List<JSONObject> getNbrCommandsByTri(@PathVariable int year){
		return commandRepository.getNbrCommandsByTrimester(year);
	}
}
