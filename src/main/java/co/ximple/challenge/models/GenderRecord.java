package co.ximple.challenge.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record GenderRecord(
        @JsonProperty("id") Optional<Long> id,
        @JsonProperty("name") String name
) {}