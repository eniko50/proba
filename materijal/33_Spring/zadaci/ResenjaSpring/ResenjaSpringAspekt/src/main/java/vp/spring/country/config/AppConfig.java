package vp.spring.country.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("vp.spring.country")
@EnableAspectJAutoProxy
public class AppConfig {
}
