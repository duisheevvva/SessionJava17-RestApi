package peaksoft.sessionjava17restapi.service;

import org.springframework.stereotype.Service;
import peaksoft.sessionjava17restapi.dto.authDto.request.SignInRequest;
import peaksoft.sessionjava17restapi.dto.authDto.response.AuthResponse;

@Service
public interface AuthService {
    AuthResponse signIn(SignInRequest signInRequest);
}
