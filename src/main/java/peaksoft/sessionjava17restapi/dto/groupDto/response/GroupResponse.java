package peaksoft.sessionjava17restapi.dto.groupDto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class GroupResponse{
    Long id;
    String imageUrl;
    String groupName;
    String description;
    LocalDate createDate;

    public GroupResponse(Long id, String imageUrl, String groupName, String description, LocalDate createDate) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.groupName = groupName;
        this.description = description;
        this.createDate = createDate;
    }
}
