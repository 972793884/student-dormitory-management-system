package com.star.timer;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Configuration
@EnableScheduling
public class TestTimer {
    //秒(, - * /) 分(, - * /) 时(, - * /) 日(, - * ? / L W ) 周(, - * ? / L #) 月(, - * /) 年(, - * /)  年非必写
    @Scheduled(cron = "0/10 * * * * ?")
    public void aa(){
        System.out.println("start");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(date);
        //System.out.println(now);
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                System.out.println("张三:"+nextLine+"\t"+now);
            }
        }

        //scanner.close();
    }
}
