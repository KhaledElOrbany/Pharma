package eg.pharma.api.features.auth.dto;

public record AuthenticationResponse(String token, long expiresIn) {
}
