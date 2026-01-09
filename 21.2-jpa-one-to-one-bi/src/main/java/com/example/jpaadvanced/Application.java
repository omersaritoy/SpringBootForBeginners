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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {

            // createInstructor(appDAO);
            // findInstructor(appDAO);
            //deleteInstructor(appDAO);
            findInstructorDetail(appDAO);

        };
    }

    //finding instructor detail by id
    private void findInstructorDetail(AppDAO appDAO) {

        //get the instructor detail object
        int theId=5;
        InstructorDetail temp=appDAO.findInstructorDetailById(theId);

        //print the instructor detail
        System.out.println("Instructor Detail: "+temp);

        //print the associated instructor
        System.out.println("The associated instructor : "+temp.getInstructor());

        System.out.println("Done!");


    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;

        System.out.println("Deleting instructor id : " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");

    }

    private void findInstructor(AppDAO appDAO) {

        //select id
        int theId = 2;
        System.out.println("Finding instructor id : " + theId);

        //trying get instructor with id
        Instructor temp = appDAO.findInstructorById(theId);
        System.out.println("Instructor: " + temp);
        System.out.println("The associated instructordetail only : " + temp.getInstructorDetail());


    }

    private void createInstructor(AppDAO appDAO) {

        /*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Haci", "Cavcav", "cavcav@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.cavcav.com/youtube",
						"Luv 2 code!");
            */

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }
}
