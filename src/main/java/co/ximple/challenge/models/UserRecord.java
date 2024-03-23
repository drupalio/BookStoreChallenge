package co.ximple.challenge.models;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record UserRecord(
        @JsonSerialize(using = ToStringSerializer.class)
        @JsonProperty("id") Optional<Long> id,
        @JsonProperty("name") String name,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("email") String email
) {}
