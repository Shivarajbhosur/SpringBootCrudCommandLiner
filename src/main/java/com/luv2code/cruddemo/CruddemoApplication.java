package com.luv2code.cruddemo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(String[] args)
	{
		return runner ->
		{
			System.out.println("Hello word");
		};
	}*/
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner ->
		{
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			 //deleteStudent(studentDAO);
			//deleteALlStudents(studentDAO);


		};
	}

	private void deleteALlStudents(StudentDAO studentDAO) {
		int nordeleted=studentDAO.deleteALL();
		System.out.println("Number of rows deletde" +nordeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("deleted student is id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("student details by Id: "+ studentId);

		Student myStudent =studentDAO.findById(studentId);
		myStudent.setFirstName("Shivaraj");
		System.out.println(myStudent);

		studentDAO.update(myStudent);
		System.out.println("updated: "+myStudent);

	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.StudentByLastName("sangu");
		for (Student tempStudent : theStudent)
		{
			System.out.println(tempStudent);
		}
	}


	private void queryForStudent(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findALL();
		//display list of students
		for(Student tempStudents:theStudents)
		{
			System.out.println(tempStudents);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Student object is created");
		Student tempStudent = new Student("Sangu","sangu","s@gmail.com");

		//savethe bject
		System.out.println("student object is saved");
		studentDAO.save(tempStudent);

		//displat student
		System.out.println("saved student generated id:" +tempStudent.getId());

		//find student by id
		System.out.println("/n find student by id"+ tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println(myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("created new student object....!");
		Student tempstudent = new Student("paaaaaul", "DOE", "Paul@WM.com");
		Student tempstudent2 = new Student("ram", "DOE", "Paul@WM.com");
		Student tempstudent3 = new Student("sham", "DOE", "Paul@WM.com");
		//save the object
		System.out.println("Saving the object....");
		studentDAO.save(tempstudent);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
		//display the id of saved student
		System.out.println("display the id of saved student"+ tempstudent.getId());


	}

}
