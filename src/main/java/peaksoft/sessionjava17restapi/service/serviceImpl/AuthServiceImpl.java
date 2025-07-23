package peaksoft.sessionjava17restapi.service.serviceImpl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.sessionjava17restapi.config.jwtConfig.JwtService;
import peaksoft.sessionjava17restapi.dto.authDto.request.SignInRequest;
import peaksoft.sessionjava17restapi.dto.authDto.response.AuthResponse;
import peaksoft.sessionjava17restapi.dto.authDto.response.ProfileResponse;
import peaksoft.sessionjava17restapi.entities.User;
import peaksoft.sessionjava17restapi.enums.Gender;
import peaksoft.sessionjava17restapi.enums.Role;
import peaksoft.sessionjava17restapi.repo.UserRepo;
import peaksoft.sessionjava17restapi.service.AuthService;

import java.security.Principal;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostConstruct
    public void saveAdmin(){
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Adminov");
        user.setGender(Gender.MALE);
        user.setEmail("admin@gmail.com");
        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode("Admin123"));
        if (!userRepo.existsByEmail(user.getEmail())) {
            userRepo.save(user);
        }
    }

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) {
        User user = userRepo.findUserByEmail(signInRequest.email()).orElseThrow(()
                -> new EntityNotFoundException(String.format("User with email %s not found!", signInRequest.email())));
        if (!passwordEncoder.matches(signInRequest.password(),user.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }

       return AuthResponse
               .builder()
               .id(user.getId())
               .token(jwtService.generateToken(user))
               .role(user.getRole())
               .build();
    }

    // with securityContext
    @Override
    public ProfileResponse getProfile() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String email = authentication.getName();
        User user = userRepo.findUserByEmail(email).orElseThrow(() ->
                new RuntimeException(String.format("User with  email %s not found!", email)));
        return ProfileResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build() ;
    }

    // with Principal
    public ProfileResponse getAuthenticationWithPrincipal(Principal principal){
        String email = principal.getName();
        User user = userRepo.findUserByEmail(email).orElseThrow(() ->
                new RuntimeException(String.format("User with  email %s not found!", email)));
        return ProfileResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build() ;
    }



}
