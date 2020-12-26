package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;
import java.util.ArrayList;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

    private String name;
    private String environment;
    private boolean enabled;
    private List<String> servers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String isEnabled() {
        return enabled ? "true" : "false";
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getServers() {
        return "[" + String.join(", ", servers) + "]";
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

}

