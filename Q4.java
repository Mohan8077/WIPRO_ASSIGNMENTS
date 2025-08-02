package Junit;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

class Student {
 private int id;
 private String name;

 public Student(int id, String name) {
     this.id = id;
     this.name = name;
 }

 public String getName() {
     return name;
 }
}

interface StudentRepository {
 Optional<Student> findById(int id);
}

class StudentService {
 private StudentRepository repository;

 public StudentService(StudentRepository repository) {
     this.repository = repository;
 }

 public String getStudentById(int id) {
     return repository.findById(id)
                      .map(Student::getName)
                      .orElse("Student Not Found");
 }
}

public class Q4 {

 @Test
 public void testGetStudentByIdReturnsCorrectName() {
	 
 
     StudentRepository mockRepo = mock(StudentRepository.class);

     when(mockRepo.findById(1)).thenReturn(Optional.of(new Student(1, "Sunil")));

     StudentService service = new StudentService(mockRepo);

     String result = service.getStudentById(1);

     assertEquals("Sunil", result);

     verify(mockRepo).findById(1);
 }
}
