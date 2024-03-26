package it.simone.tecnologie.arch_script;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties
@Getter
@Setter
public class ApplicationProperties {
    private List<String> Commands = new ArrayList<>();
    private String a;
}
