package com.example.jpaadvanced;

import com.example.jpaadvanced.dao.AppDAO;
import com.example.jpaadvanced.entity.Instructor;
import com.example.jpaadvanced.entity.InstructorDetail;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToUrl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){

        return runner->{
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor temp=new Instructor("Ömer","Cavcav","cavcav@gmail.com");
        InstructorDetail tempInstructorDetail=new InstructorDetail("www.omer.com","Play Table Tennis");
        temp.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: "+temp);
        appDAO.save(temp);
        System.out.println("Done.");

    }

}
