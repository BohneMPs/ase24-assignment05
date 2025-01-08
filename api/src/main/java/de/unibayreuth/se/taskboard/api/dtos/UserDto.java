package de.unibayreuth.se.taskboard.api.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
public class UserDto{
    @Nullable
    private final UUID id;
    @Nullable
    private final LocalDateTime createdAt;
    @NotNull
    private final String name;
}
