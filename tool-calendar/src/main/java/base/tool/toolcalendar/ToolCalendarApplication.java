package base.tool.toolcalendar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangyx-v
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(" base.tool.toolcalendar.dao")
public class ToolCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolCalendarApplication.class, args);
    }

}
