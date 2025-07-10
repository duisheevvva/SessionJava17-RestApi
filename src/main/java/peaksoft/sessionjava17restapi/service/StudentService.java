package peaksoft.sessionjava17restapi.service;

import org.springframework.stereotype.Service;
import peaksoft.sessionjava17restapi.dto.SimpleResponse;
import peaksoft.sessionjava17restapi.dto.studentDto.request.StudentRequest;
import peaksoft.sessionjava17restapi.dto.studentDto.request.UpdateStudentRequest;
import peaksoft.sessionjava17restapi.dto.studentDto.response.GetStudentWithGroupResponse;
import peaksoft.sessionjava17restapi.entities.Student;

import java.util.List;

@Service
public interface StudentService {
    SimpleResponse saveWithGroup(Long id, StudentRequest studentRequest);
    List<Student> getAll();
    Student getById(Long id);
    String update (Long id, UpdateStudentRequest updateStudentRequest);
    String delete (Long id);
    List<GetStudentWithGroupResponse> getStudentWithGroup(Long id);

}
