package peaksoft.sessionjava17restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.sessionjava17restapi.dto.groupDto.request.GroupRequest;
import peaksoft.sessionjava17restapi.dto.groupDto.response.GroupResponse;
import peaksoft.sessionjava17restapi.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @PostMapping
    public String save(@RequestBody GroupRequest groupRequest){
        return groupService.save(groupRequest);
    }

    @GetMapping
    public List<GroupResponse> getAll(){
       return groupService.getAll();
    }

}
