package com.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.brewer.controller.CervejasController;

@Configuration
@ComponentScan(basePackageClasses= {CervejasController.class})
public class WebConfig {

}
