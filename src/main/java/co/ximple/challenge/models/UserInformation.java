package co.ximple.challenge.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record UserInformation(@JsonProperty("email") String email, @JsonProperty("password")String password) { }
