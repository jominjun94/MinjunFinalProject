package com.cos.Mproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{ // upload 함수 정의 
	
	@Value("${file.path}")
	private String uploadFolder;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		//C:/Users/82107/Desktop/spring/upload2/
		
		registry.addResourceHandler("/upload2/**") // jsp 페이지에서 /upload/ 이런주소패턴이 나오면 발동한다
		.addResourceLocations("file:///"+uploadFolder)
		.setCachePeriod(60*60*6)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}

}
