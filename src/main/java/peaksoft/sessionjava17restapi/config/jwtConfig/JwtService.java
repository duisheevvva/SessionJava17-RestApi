package peaksoft.sessionjava17restapi.config.jwtConfig;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import peaksoft.sessionjava17restapi.entities.User;
import peaksoft.sessionjava17restapi.repo.UserRepo;


import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class JwtService {
    @Value("${security.secret.key}")
    private String secretKey; // java17
    private final UserRepo userRepo;


    // create token
    public String generateToken(User user){
        ZonedDateTime now = ZonedDateTime.now();
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plusSeconds(100000000).toInstant())
                .sign(getAlgorithm());
    }

    //
    public User verifyToken(String token){
        Algorithm algorithm = getAlgorithm();
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String email = decodedJWT.getClaim("email").asString();
        return userRepo.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found with email: " + email)
        );
    }

    public User getAuthentication(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepo.findUserByEmail(email).orElseThrow(() ->
                new RuntimeException(String.format("User with  email %s not found!", email)));
    }
    public Algorithm getAlgorithm(){
        return Algorithm.HMAC256(secretKey);
    }

    // SecurityContextHolder




}
