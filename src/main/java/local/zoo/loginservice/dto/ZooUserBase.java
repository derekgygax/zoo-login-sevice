package local.zoo.loginservice.dto;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.Email;
import local.zoo.loginservice.enums.Role;

public record ZooUserBase(
        @Schema(required = true, title = "Email", description = "Email for the Zoo User", maxLength = 250) @Email(message = "Invalid email format") String email,
        @Schema(required = true, title = "Roles", description = "Roles the user has in the zoo") List<Role> role) {
}
