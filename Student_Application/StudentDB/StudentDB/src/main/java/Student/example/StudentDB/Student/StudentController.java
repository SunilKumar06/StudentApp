package Student.example.StudentDB.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path ="/api/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
   public List<Student> getStudent()
   {
       return studentService.getStudentDetails();
   }

   // Take a request body from client and map it to Student
   @PostMapping
    public void registernewStudent(@RequestBody Student student)
   {
       studentService.addnewStudent(student);
   }
}
