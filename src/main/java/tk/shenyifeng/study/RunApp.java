package tk.shenyifeng.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("tk.shenyifeng.study.mapper")
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class,args);
    }
}
