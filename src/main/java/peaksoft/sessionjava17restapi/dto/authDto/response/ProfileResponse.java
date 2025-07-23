package peaksoft.sessionjava17restapi.dto.authDto.response;

import lombok.Builder;
import peaksoft.sessionjava17restapi.enums.Role;
@Builder
public record ProfileResponse(
        Long id,
        String email,
        Role role
) {
}
