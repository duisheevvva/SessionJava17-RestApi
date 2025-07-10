package peaksoft.sessionjava17restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.sessionjava17restapi.dto.studentDto.response.GetStudentWithGroupResponse;
import peaksoft.sessionjava17restapi.entities.Student;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query("select new peaksoft.sessionjava17restapi.dto.studentDto.response.GetStudentWithGroupResponse(g.groupName, s.firstName) from Student  s " +
            "join Group  g on s.group.id= :id")
    List<GetStudentWithGroupResponse> getStudentWithGroup(@Param("id") Long id);

}
