package org.peng.mvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Create by peng on 2021/6/17.
 */
@Configurable
@ComponentScan
public class MVCApp {
    public static void main(String[] args) throws ServletException, LifecycleException {

        //使用嵌入式tomcat启动
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port",8080));
        tomcat.getConnector();

        //由web server(此处为tomcat)提供context环境
        Context context = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        WebResourceRoot resourceRoot = new StandardRoot(context);
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/"));
        context.setResources(resourceRoot);

        tomcat.start();
        tomcat.getServer().await();
        
    }
}
