package eventos.api;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class StaticResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String projectDirectory = System.getProperty("user.dir"); // Obtém o diretório atual do projeto
        String uploadsDirectory = "uploads";
        String destinationDirectory = Paths.get(projectDirectory, uploadsDirectory).toString();
        String myExternalFilePath = "file:///" + destinationDirectory;
        registry.addResourceHandler("/**").addResourceLocations(myExternalFilePath);
    }
}