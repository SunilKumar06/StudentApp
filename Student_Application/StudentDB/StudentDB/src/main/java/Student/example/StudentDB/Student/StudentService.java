package Student.example.StudentDB.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentDetails()
    {
        return studentRepository.findAll();
    }

    public void addnewStudent(Student student)
    {
         Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
         if(studentByEmail.isPresent())
         {
           throw new IllegalArgumentException("Email taken already");
         }
         studentRepository.save(student);
        System.out.println(student);
    }
}
