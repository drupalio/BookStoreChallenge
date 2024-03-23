package co.ximple.challenge.models;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record BookRecord(
        @JsonSerialize(using = ToStringSerializer.class)
        @JsonProperty("id") Optional<Long> id,
        @JsonProperty("title") String title,
        @JsonProperty("author") String author,
        @JsonProperty("gender") GenderRecord gender
) {}