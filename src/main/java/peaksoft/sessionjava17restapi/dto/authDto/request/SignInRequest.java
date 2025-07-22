package peaksoft.sessionjava17restapi.dto.authDto.request;

import lombok.Builder;

@Builder
public record SignInRequest(
        String email,
        String password
) {

}
