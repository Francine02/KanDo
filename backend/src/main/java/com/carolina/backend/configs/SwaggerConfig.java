package com.carolina.backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
        @Bean
        public OpenAPI customAPI() {
                return new OpenAPI()
                                .addServersItem(new Server().url("http://localhost:8080")
                                                .description("Servidor de Desenvolvimento"))
                                .addServersItem(new Server().url("https://kando-gf9l.onrender.com")
                                                .description("Servidor de Produção"))
                                .info(new Info()
                                                .title("KanDo")
                                                .version("1.0.0")
                                                .description("KanDo is a task management system based on the Kanban methodology, designed to help teams and individuals organize their activities in a simple and collaborative way.")
                                                .license(new License().name("Apache-2.0 license").url(
                                                                "https://github.com/Francine02/KanDo/blob/main/LICENSE")));
        }
}