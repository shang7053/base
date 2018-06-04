/**
 * Copyright (c) 2018-2020, CMGPlex Inc. All Rights Reserved.
 * <p>
 * Project Name: gateway
 * @version: 1.0
 * @date:  2018-04-09 14:06:38
 */
package com.scc.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author York Liu (york.liu@cmgplex.com)
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				/** .groupName("test") */
				.enable(true).genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false)
				.forCodeGeneration(true).pathMapping("/").select().paths(Predicates.or(PathSelectors.regex("/.*")))
				.build().apiInfo(this.apiInfo());
		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API说明文档").description("自动生成的API说明文档")
				.termsOfServiceUrl("http://www.cmgplex.com/").version("1.0").build();
	}
}
