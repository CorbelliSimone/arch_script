package it.simone.tecnologie.arch_script;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommandExcecutor {

    public void ExecuteCommand(String command){
        try {
            // Esegui il comando
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            Process process = processBuilder.start();

            // Dichiarare exitCode prima del blocco try
            int exitCode;

            // Crea un BufferedReader per leggere l'output del process
            try (var inputStream = new InputStreamReader(process.getInputStream());
                 var bufferReader = new BufferedReader(inputStream)){
                String linea;
                // Leggi e stampa l'output del process linea per linea
                while ((linea = bufferReader.readLine()) != null) {
                    System.out.println(linea);
                }
                // Attendi la fine del process
                exitCode = process.waitFor();
            }

            // Stampa il codice di uscita del process
            System.out.println("Codice di uscita: " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


}
