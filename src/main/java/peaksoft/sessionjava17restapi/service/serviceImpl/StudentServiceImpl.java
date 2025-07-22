package peaksoft.sessionjava17restapi.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.sessionjava17restapi.dto.SimpleResponse;
import peaksoft.sessionjava17restapi.dto.studentDto.request.StudentRequest;
import peaksoft.sessionjava17restapi.dto.studentDto.request.UpdateStudentRequest;
import peaksoft.sessionjava17restapi.dto.studentDto.response.GetStudentWithGroupResponse;
import peaksoft.sessionjava17restapi.entities.Group;
import peaksoft.sessionjava17restapi.entities.Student;
import peaksoft.sessionjava17restapi.entities.User;
import peaksoft.sessionjava17restapi.enums.Role;
import peaksoft.sessionjava17restapi.repo.GroupRepo;
import peaksoft.sessionjava17restapi.repo.StudentRepo;
import peaksoft.sessionjava17restapi.repo.UserRepo;
import peaksoft.sessionjava17restapi.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final GroupRepo groupRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public SimpleResponse saveWithGroup(Long id, StudentRequest studentRequest) {
        Group group = groupRepo.findById(id).orElseThrow(() ->
                new NullPointerException("Group with id " + id + "Not found!"));
        User user = new User();
        user.setFirstName(studentRequest.firstName());
        user.setLastName(studentRequest.lastName());
        user.setDateOfBirth(studentRequest.dateOfBirth());
        user.setGender(studentRequest.gender());
        user.setEmail(studentRequest.email());
        user.setPassword(passwordEncoder.encode(studentRequest.password()));
        user.setRole(Role.STUDENT);
        userRepo.save(user);
        Student student = new Student();
        student.setStudyFormat(studentRequest.studyFormat());
        student.setUser(user);
        student.setGroup(group);
        studentRepo.save(student);
        group.getStudents().add(student);
        groupRepo.save(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved")
                .build();
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new NullPointerException("Not found"));
    }

    @Override
    public String update(Long id, UpdateStudentRequest updateStudentRequest) {
//        Student oldStudent = getById(id);
//        oldStudent.setFirstName(updateStudentRequest.getFirstName());
//        oldStudent.setLastName(updateStudentRequest.getLastName());
//        studentRepo.save(oldStudent);
        return "Success";
    }

    @Override
    public String delete(Long id) {
        return null;
    }

//    @Override
//    public List<GetStudentWithGroupResponse> getStudentWithGroup(Long id) {
//        return studentRepo.getStudentWithGroup(id);
//
//    }
}
