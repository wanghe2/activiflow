package flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:activiti.cfg.xml")
public class FLowMain {

    public static void main(String[] args){
        SpringApplication.run(FLowMain.class,args);
    }
}
