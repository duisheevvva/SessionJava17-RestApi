package peaksoft.sessionjava17restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.sessionjava17restapi.dto.groupDto.response.GroupResponse;
import peaksoft.sessionjava17restapi.entities.Group;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<Group,Long> {

    @Query("select new peaksoft.sessionjava17restapi.dto.groupDto.response.GroupResponse(g.id,g.groupName,g.imageUrl,g.description,g.createDate) from Group g")
    List<GroupResponse> getAll();
}
