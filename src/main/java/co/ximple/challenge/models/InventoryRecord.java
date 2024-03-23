package co.ximple.challenge.models;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record InventoryRecord(
        @JsonSerialize(using = ToStringSerializer.class)
        @JsonProperty("id") Optional<Long> id,
        @JsonProperty("book") BookRecord book,
        @JsonProperty("available") boolean available
) {}
