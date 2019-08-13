package ww.qrtest.mybatisplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ww.qrtest.mybatisplus.util.TokenUtil;

@Configuration
public class TokenConfig {
    @Bean
    public TokenUtil tokenUtil(){
        return new TokenUtil();
    }
}
