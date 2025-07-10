package peaksoft.sessionjava17restapi.service;

import org.springframework.stereotype.Service;

import peaksoft.sessionjava17restapi.dto.groupDto.request.GroupRequest;
import peaksoft.sessionjava17restapi.dto.groupDto.response.GroupResponse;
import peaksoft.sessionjava17restapi.entities.Student;

import java.util.List;

@Service
public interface GroupService {
    String save(GroupRequest groupRequest);
    List<GroupResponse> getAll();

}
