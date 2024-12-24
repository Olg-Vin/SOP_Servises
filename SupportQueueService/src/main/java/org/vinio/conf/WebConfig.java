package org.vinio.conf;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/**") // Разрешить все пути
                        .allowedOrigins("http://localhost", "http://localhost:8000") // Разрешить localhost
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешить методы
                        .allowedHeaders("*") // Разрешить любые заголовки
                        .allowCredentials(true); // Разрешить отправку credentials (если нужно)
            }
        };
    }
}
