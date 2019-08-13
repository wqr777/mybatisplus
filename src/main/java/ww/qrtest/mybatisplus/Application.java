package ww.qrtest.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ww.qrtest.mybatisplus.util.TokenUtil;


@SpringBootApplication
@MapperScan("ww.qrtest.mybatisplus.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
