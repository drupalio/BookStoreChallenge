package co.ximple.challenge.controllers;

import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.UserInformation;
import co.ximple.challenge.models.UserRecord;
import co.ximple.challenge.sevices.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
@Tag(name = "users", description = "Endpoints for managing users operations")
public record UserController (UserService userService){
    @Operation(summary = "Basic login Service", description = "Get user information by email")
    @ApiResponse(responseCode = "200", description = "User information by email",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BookRecord.class)))
    @PostMapping("/")
    UserRecord getUserInformation(@RequestBody UserInformation user){
        return userService.getUserInformation(user);
    }
}
