package com.rougeniel.crudapplication;

import com.rougeniel.crudapplication.dao.StudentDao;
import com.rougeniel.crudapplication.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudapplicationApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
//			createStudent(studentDao);
//			createMultipleStudent(studentDao);
			readStudent(studentDao);
		};
	}

	private void readStudent(StudentDao studentDao) {
		//create a student object
		System.out.println("Create student object: ");
		Student stud1 = new Student("Roniel", "Delos Santos", "ronieldegozo@gmail.com");

		//save student object
		studentDao.save(stud1);
		System.out.println("Save Student" + stud1);

		//display id of save student
		long theId = stud1.getId();
		System.out.println("Saved: " + theId);

		//retrieve student base on id: primary key
		System.out.println("Retrive student: ");
		Student displayStud = studentDao.findById(theId);

		//display student
		System.out.println("Students is : " + displayStud);

	}

	private void createMultipleStudent(StudentDao studentDao) {
		//create student object
		System.out.println("Creating a new Student!");
		Student stud2 = new Student("Rogine Grace","Laurito","17rogine@gmail.com");
		Student stud3 = new Student("Reniella Grace","De Gozo","reniellgrace@gmail.com");
		Student stud4 = new Student("Nathan","De Gozo","nathan@gmail.com");

		//save student object
		System.out.println("Saving Students");
		studentDao.save(stud2);
		studentDao.save(stud3);
		studentDao.save(stud4);
		//display the id of the save student

		System.out.println("Student ID 2: " + stud2.getId() + " Student ID 3: " + stud3.getId() + " Student ID 4 " + stud4.getId());
	}

	private void createStudent(StudentDao studentDao) {
		//create student object
		System.out.println("Creating a new Student!");
		Student stud1 = new Student("Mc Roniel","De Gozo","ronieldegozo@gmail.com");

		//save student object
		System.out.println("Saving Students");
		studentDao.save(stud1);
		//display the id of the save student

		System.out.println("Student ID: " + stud1.getId());
	}

}
