package com.utour.youdai.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.utour.youdai.admin.project.**.mapper")
public class YouDaiApplication {
    public static void main(String[] args) {
        // System.se/dev-apitProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(YouDaiApplication.class, args);

    }
}
