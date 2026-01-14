package com.example.jpaadvanced;

import com.example.jpaadvanced.dao.AppDAO;
import com.example.jpaadvanced.entity.Course;
import com.example.jpaadvanced.entity.Instructor;
import com.example.jpaadvanced.entity.InstructorDetail;
import com.example.jpaadvanced.entity.Review;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToUrl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.List;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {

            // createCourseAndReview(appDAO);
            //retrieveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);
        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int theId=10;

        System.out.println("Deleting course id:"+theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        //get course and reviews
        int theId=10;
        Course tempCourse=appDAO.findCourseAndReviewsByCourseId(theId);

        //print the course
        System.out.println(tempCourse);

        //print the reviews
        System.out.println(tempCourse.getReviews());

        System.out.println("Done!");
    }

    private void createCourseAndReview(AppDAO appDAO) {
        //create a course
        Course tempCourse = new Course("Pacman - How to score One Million Points ");

        //add reviews
        tempCourse.addReview(new Review("Great course ... loved it"));
        tempCourse.addReview(new Review("Cool course,job well done"));
        tempCourse.addReview(new Review("What a dumb course,you are an idiot"));

        //save the course and leverage the cascade all
        System.out.println("Saving course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Deleting course id:" + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;
        //find the course
        System.out.println("Finding course id:" + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        //update the course
        System.out.println("Updating course id:" + theId);
        tempCourse.setTitle("Enjoy the Simple Things");

        appDAO.update(tempCourse);

        System.out.println("Done!");

    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

        //find the Instructor
        System.out.println("Finding instructor id : " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        //update the instructor
        System.out.println("Update instructor id:" + theId);
        tempInstructor.setLastName("Tester");

        appDAO.update(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;

        //find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("Instructor:" + tempInstructor);
        System.out.println("the associated courses:" + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        //find instructor
        System.out.println("Finding instructor id:" + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Instructor:" + tempInstructor);

        //find courses for instructor
        System.out.println("Finding courses for instructor id:" + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        //associated the object
        tempInstructor.setCourses(courses);

        System.out.println("The associated courses:" + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id:" + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Instructor:" + tempInstructor);
        System.out.println("the associated courses:" + tempInstructor.getCourses());


        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

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

        //create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        //add course to instructor

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        //save the instructor
        //Note:this will also save the courses because of cascadetype.persist
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());

        appDAO.save(tempInstructor);


    }

    //delete instructor detail
    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 5;
        System.out.println("Deleting instructor detail id : " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    //finding instructor detail by id
    private void findInstructorDetail(AppDAO appDAO) {

        //get the instructor detail object
        int theId = 5;
        InstructorDetail temp = appDAO.findInstructorDetailById(theId);

        //print the instructor detail
        System.out.println("Instructor Detail: " + temp);

        //print the associated instructor
        System.out.println("The associated instructor : " + temp.getInstructor());

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
