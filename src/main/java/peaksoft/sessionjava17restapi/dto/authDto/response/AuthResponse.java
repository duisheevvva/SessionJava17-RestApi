package peaksoft.sessionjava17restapi.dto.authDto.response;

import lombok.Builder;
import peaksoft.sessionjava17restapi.enums.Role;

@Builder
public record AuthResponse(
        Long id,
        String token,
        Role role
) {

}
