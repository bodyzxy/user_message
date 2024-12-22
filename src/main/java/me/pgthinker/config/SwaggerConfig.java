package me.pgthinker.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project: me.pgthinker.config
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/22 16:32
 * @Description:
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerOpenApi() {
        return new OpenAPI()
                .info(new Info().title("期末大作业")
                        .description("期末大作业设计 用户管理模块")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("设计文档(示例地址)")
                        .url("https://example.com"));
    }

}
