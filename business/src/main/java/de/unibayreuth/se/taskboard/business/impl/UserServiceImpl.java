package de.unibayreuth.se.taskboard.business.impl;

import de.unibayreuth.se.taskboard.business.domain.Task;
import de.unibayreuth.se.taskboard.business.domain.TaskStatus;
import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.DuplicateNameException;
import de.unibayreuth.se.taskboard.business.exceptions.MalformedRequestException;
import de.unibayreuth.se.taskboard.business.exceptions.TaskNotFoundException;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import de.unibayreuth.se.taskboard.business.ports.UserPersistenceService;
import de.unibayreuth.se.taskboard.business.ports.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPersistenceService userPersistenceService;

    @Override
    public void clear() {userPersistenceService.clear();}

    @Override
    public @NonNull List<User> getAll() {
        return userPersistenceService.getAll();
    }

    @Override
    public @NonNull User getById(@NonNull UUID uuid) throws UserNotFoundException {
        return userPersistenceService.getById(uuid).orElseThrow(() -> new UserNotFoundException("Task with ID " + uuid + " does not exist."));
    }

    @Override
    public @NonNull User create(@NonNull User user) throws MalformedRequestException {
        if (user.getId() != null) {
            throw new MalformedRequestException("User ID must not be set.");
        }
        return userPersistenceService.upsert(user);
    }
}
