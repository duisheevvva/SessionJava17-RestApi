package peaksoft.sessionjava17restapi.dto.studentDto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class GetStudentWithGroupResponse {
    String groupName;
    String studentName;

    public GetStudentWithGroupResponse(String groupName, String studentName) {
        this.groupName = groupName;
        this.studentName = studentName;
    }
}
