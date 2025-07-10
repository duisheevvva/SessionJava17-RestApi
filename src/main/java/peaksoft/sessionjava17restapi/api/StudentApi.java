package peaksoft.sessionjava17restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.sessionjava17restapi.dto.SimpleResponse;
import peaksoft.sessionjava17restapi.dto.studentDto.request.StudentRequest;
import peaksoft.sessionjava17restapi.dto.studentDto.request.UpdateStudentRequest;
import peaksoft.sessionjava17restapi.dto.studentDto.response.GetStudentWithGroupResponse;
import peaksoft.sessionjava17restapi.entities.Student;
import peaksoft.sessionjava17restapi.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @PostMapping
    public SimpleResponse save(@RequestParam Long id , @RequestBody StudentRequest studentRequest){
       return studentService.saveWithGroup(id,studentRequest);
    }

    @GetMapping("getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public String update (@PathVariable Long id, @RequestBody UpdateStudentRequest updateStudentRequest){
        return studentService.update(id, updateStudentRequest);
    }


    @GetMapping("/getAllStudentWithGroup/{id}")
    public List<GetStudentWithGroupResponse> getStudentWithGroup(@PathVariable Long id){
        return studentService.getStudentWithGroup(id);
    }

}
