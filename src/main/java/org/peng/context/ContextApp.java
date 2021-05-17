package org.peng.context;

import org.peng.context.base.Cinema;
import org.peng.context.base.MovieService;
import org.peng.context.service.DefaultMovieService;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParserContext;

/**
 * Create by peng on 2021/5/17.
 * spring-context提供运行环境，保存对象状态
 * 在基础IOC功能上提供扩展服务，此外还提供许多企业级服务的支持，有邮件服务、任务调度、JNDI定位，EJB集成、远程访问、缓存以及多种视图层框架的支持。
 */
//@Configuration告诉Spring在Application.java中定义了一个或多个@Bean方法，让Spring容器可以在运行时生成这些Bean
@Configuration
//@ComponentScan让Spring容器自动扫描当前package下的标有@Component的class，这些class都将由Spring托管
@ComponentScan
public class ContextApp {
    @Bean
    public MovieService getMovieService() {
        return new DefaultMovieService();
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ContextApp.class);
        //测试样例
        Cinema cinema = applicationContext.getBean(Cinema.class);
        cinema.printMovieName();
        //入口方法:BeanDefinitionParserDelegate.parseCustomElement
        applicationContext.close();
    }
}
