package QNO52;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Student {
    private final int id;
    private final String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    String getName() {
        return name;
    }
}

interface StudentRepository {
    Student findById(int id);
}

class StudentService {
    private final StudentRepository repository;

    StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    String getStudentById(int id) {
        return repository.findById(id).getName();
    }
}

public class StudentServiceTest {
    @Test
    void testGetStudentById() {
        StudentRepository mockRepo = mock(StudentRepository.class);
        when(mockRepo.findById(1)).thenReturn(new Student(1, "John"));

        StudentService service = new StudentService(mockRepo);
        assertEquals("John", service.getStudentById(1));

        verify(mockRepo).findById(1);
    }
}
