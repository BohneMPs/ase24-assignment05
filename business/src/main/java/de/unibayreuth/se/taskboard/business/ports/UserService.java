package de.unibayreuth.se.taskboard.business.ports;

import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.DuplicateNameException;
import de.unibayreuth.se.taskboard.business.exceptions.MalformedRequestException;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface UserService {
    void clear();

    @NonNull
    List<User> getAll();

    @NonNull
    User getById(@NonNull UUID uuid);

    @NonNull
    User create(@NonNull User user) throws MalformedRequestException;
}
