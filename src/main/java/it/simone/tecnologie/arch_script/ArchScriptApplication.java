package it.simone.tecnologie.arch_script;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ArchScriptApplication {

	private ApplicationProperties applicationProperties;
	private CommandExcecutor commandExcecutor;

	public static void main(String[] args) {
		SpringApplication.run(ArchScriptApplication.class, args);
	}

	@PostConstruct
	public void init(){
		if(applicationProperties.getCommands() == null || applicationProperties.getCommands().isEmpty()){
			System.out.println("Sei gay");
			return;
		}

		applicationProperties.getCommands().forEach(command -> {
			commandExcecutor.ExecuteCommand(command);
		});
	}

}