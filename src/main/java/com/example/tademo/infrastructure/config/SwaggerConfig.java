package com.example.tademo.infrastructure.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public abstract class SwaggerConfig {

	private static String projectTitle;
	private static String projectDescription;
	private static String buildVersion;

	@Value("${build.version}")
	public void setBuildVersion(String version) {
		SwaggerConfig.buildVersion = version;
	}

	@Value("${project.title}")
	public void setProjectTitle(String title) {
		SwaggerConfig.projectTitle = title;
	}

	@Value("${project.description}")
	public void setProjectDescription(String description) {
		SwaggerConfig.projectDescription = description;
	}

	// default API in & out
	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>(Arrays.asList("application/json"));

	private static final Set<String> DEFAULT_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

//	private final String baseUrl;
//
//	public SwaggerConfig(String baseUrl) {
//		this.baseUrl = baseUrl;
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
//		registry.addResourceHandler(baseUrl + "/swagger-ui/**")
//				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//				.resourceChain(false);
//	}
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController(baseUrl + "/swagger-ui/")
//				.setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
//	}

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.produces(DEFAULT_PRODUCES)
				.consumes(DEFAULT_CONSUMES);
//				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {

		final ApiInfoBuilder builder = new ApiInfoBuilder();

		builder.title(SwaggerConfig.projectTitle).description(SwaggerConfig.projectDescription)
				.version(SwaggerConfig.buildVersion).contact(new Contact("RedHat", "redhat SA", "ysuen@redhat.com"))
				.license("(C) Copyright Test");

		return builder.build();
	}

}
