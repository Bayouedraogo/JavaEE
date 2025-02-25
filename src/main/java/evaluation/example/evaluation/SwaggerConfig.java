package evaluation.example.evaluation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Système d'évaluation API", version = "1.0", description = "Documentation de l'API"))
public class SwaggerConfig {
}

