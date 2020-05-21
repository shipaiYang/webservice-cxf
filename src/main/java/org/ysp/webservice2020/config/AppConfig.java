package org.ysp.webservice2020.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.ysp.webservice2020.service.WeatherService;

import javax.xml.ws.Endpoint;

/**
 * @author pai
 * @date 2020/5/4
 */
@Configuration
public class AppConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private WeatherService weatherService;


    /**
     * 添加普通的controller处理
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRestServlet() {
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        //替换成自己的controller包路径
        context.scan("org.ysp.webservice2020.controller");
        DispatcherServlet disp = new DispatcherServlet(context);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(disp);
        registrationBean.setLoadOnStartup(1);
        //映射路径自定义,必须设置一个不重复的名称
        registrationBean.addUrlMappings("/rest/*");
        registrationBean.setName("rest");
        return registrationBean;
    }

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus,weatherService);
        endpoint.publish("/weatherService");
        return endpoint;
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
    }
}
