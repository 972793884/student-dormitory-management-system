package com.star;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class sc {
    //秒(, - * /) 分(, - * /) 时(, - * /) 日(, - * ? / L W ) 周(, - * ? / L #) 月(, - * /) 年(, - * /)  年非必写
    @Scheduled(cron = "0/20 * * * * ?")
    public void aa(){
        System.out.println(666);
    }

}
