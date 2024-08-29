package com.example.monwebetable;

import com.example.monwebetable.models.NoteFile;
import com.example.monwebetable.models.Student;
import com.example.monwebetable.models.Teacher;
import com.example.monwebetable.models.User;
import com.example.monwebetable.services.DTO.StudentDTO;
import com.example.monwebetable.services.DTO.TeacherDTO;
import com.example.monwebetable.services.DTO.UserDTO;
import com.example.monwebetable.services.StudentService;
import com.example.monwebetable.services.TeacherService;
import com.example.monwebetable.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.time.Instant;
import java.util.List;
@AllArgsConstructor
@SpringBootApplication
public class MonWebEtableApplication  implements CommandLineRunner {

	private UserService userService;
	private TeacherService teacherService;
	private StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(MonWebEtableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
  	 // INFORMATION D'UN ETUDIANT
		StudentDTO student = new StudentDTO();
		student.setMatricule("12600W");
		student.setNom("John");
		student.setPrenom("Doe");
		student.setClasse("licence1");
		student.setTelephone("0707070707");
		student.setDateNaissance(java.sql.Date.valueOf("2000-01-01"));
		student.setVille("Paris");

			//  ****** INFORMATION D'UN ETUDIANT*****
		StudentDTO student1 = new StudentDTO();
		student1.setMatricule("12600W");
		student1.setNom("John");
		student1.setPrenom("Doe");
		student1.setClasse("master");
		student1.setDateNaissance(java.sql.Date.valueOf("2000-01-01"));
		student1.setVille("Paris");

		studentService.save(student);
		studentService.save(student1);


		//***************Création d'un nouvel teacher*******
		TeacherDTO teacher = new TeacherDTO();
		teacher.setNom("Smith");
		teacher.setPrenom("Jane");
		teacher.setVacant(true);
		teacher.setMatiereEnseigne("Mathematics");
		teacher.setProchainCours("Calculus");
		teacher.setSujetProchaineReunion("Curriculum Development");


		TeacherDTO teacher2 = new TeacherDTO();
		teacher2.setNom("AKE");
		teacher2.setPrenom("LOULOU");
		teacher2.setVacant(true);
		teacher2.setMatiereEnseigne("Mathematics");
		teacher2.setProchainCours("Calculus");
		teacher2.setSujetProchaineReunion("Curriculum Development");


		TeacherDTO teacher3 = new TeacherDTO();
		teacher3.setNom("Djenabou");
		teacher3.setPrenom("Diallo");
		teacher3.setVacant(true);
		teacher3.setMatiereEnseigne("Lv2");
		teacher3.setProchainCours("Physique");
		teacher3.setSujetProchaineReunion(" Development Personel");
		teacher3.setTelephone("0102030404");
		teacher3.setVille("Man");

		teacherService.save(teacher);
		teacherService.save(teacher2);
		teacherService.save(teacher3);





		//***************Création d'un nouvel utilisateur*****************
		UserDTO user = new UserDTO();
		user.setPseudo("Nogbou");
		user.setPassword("word123");
		user.setCreationDate(Instant.now());

		UserDTO user2 = new UserDTO();
		user2.setPseudo("Koffi");
		user2.setPassword("word12");
		user2.setCreationDate(Instant.now());

		UserDTO user3 = new UserDTO();
		user3.setPseudo("Ange");
		user3.setPassword("word12345");
		user3.setCreationDate(Instant.now());

		UserDTO user4 = new UserDTO();
		user4.setPseudo("dodo");
		user4.setPassword("word");
		user4.setCreationDate(Instant.now());

		userService.save(user);
		userService.save(user2);
		userService.save(user3);
		userService.save(user4);



		/*Création d'un nouvel teacher
		Teacher teacher = new Teacher();
		teacher.setNom("Smith");
		teacher.setPrenom("Jane");
		teacher.setVacant(true);
		teacher.setMatiereEnseigne("Mathematics");
		teacher.setProchainCours("Calculus");
		teacher.setSujetProchaineReunion("Curriculum Development");

		teacherService.save(teacher);/*
		 */



	}






	}