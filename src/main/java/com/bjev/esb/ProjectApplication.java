package com.bjev.esb;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.bjev.esb.mapper")
@Slf4j
public class ProjectApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext application = SpringApplication.run(ProjectApplication.class, args);

        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t"
                + "Application '{}' is running! Access URLs:\n\t" + "Login: \thttp://{}:{}/login\n\t"
                + "Doc: \thttp://{}:{}/doc.html\n" + "----------------------------------------------------------",
                env.getProperty("spring.application.name"), InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

}
