package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName: XMLConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年9月6日 下午3:45:47
 * 
 */
@Configuration
@ImportResource(locations = { "classpath:application-bean.xml" })
public class XMLConfig {

}
