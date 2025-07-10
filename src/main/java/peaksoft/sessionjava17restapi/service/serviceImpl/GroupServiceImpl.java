package peaksoft.sessionjava17restapi.service.serviceImpl;

import org.springframework.stereotype.Service;
import peaksoft.sessionjava17restapi.dto.groupDto.request.GroupRequest;
import peaksoft.sessionjava17restapi.dto.groupDto.response.GroupResponse;
import peaksoft.sessionjava17restapi.entities.Group;
import peaksoft.sessionjava17restapi.repo.GroupRepo;
import peaksoft.sessionjava17restapi.service.GroupService;

import java.time.LocalDate;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;

    public GroupServiceImpl(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    @Override
    public String save(GroupRequest groupRequest) {
        Group group = new Group();
        group.setImageUrl(groupRequest.imageUrl());
        group.setGroupName(groupRequest.groupName());
        group.setDescription(groupRequest.description());
        group.setCreateDate(LocalDate.now());
        groupRepo.save(group);
        return "Success";
    }

    @Override
    public List<GroupResponse> getAll() {
        return groupRepo.getAll();
    }
}
