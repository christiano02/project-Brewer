package com.brewer.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.brewer.controller.BeerController;

@Configuration
@ComponentScan(basePackageClasses= {BeerController.class})
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		   ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		   resolver.setTemplateEngine(templateEngine());
		   resolver.setCharacterEncoding("UTF-8");
		   return  resolver;
		    }
	
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine ();
				engine.setEnableSpringELCompiler(true);
				engine.setTemplateResolver(templateResolver());
				return engine; 
	}
	 
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver ();
				resolver.setApplicationContext(applicationContext);
				resolver.setPrefix("classPath:/templates/");
				resolver.setTemplateMode(TemplateMode.HTML);
				resolver.setSuffix(".html");
				return resolver; 
	}

}
