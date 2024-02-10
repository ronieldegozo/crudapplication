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
			createStudent(studentDao);
		};
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
