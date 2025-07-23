package peaksoft.sessionjava17restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.sessionjava17restapi.dto.authDto.request.SignInRequest;
import peaksoft.sessionjava17restapi.dto.authDto.response.AuthResponse;
import peaksoft.sessionjava17restapi.dto.authDto.response.ProfileResponse;
import peaksoft.sessionjava17restapi.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthApi {
    private final AuthService authService;

    @PostMapping
    public AuthResponse signIn (SignInRequest signInRequest){
        return authService.signIn(signInRequest);
    }

    @GetMapping()
    public ProfileResponse getProfile(){
        return authService.getProfile();
    }
}
