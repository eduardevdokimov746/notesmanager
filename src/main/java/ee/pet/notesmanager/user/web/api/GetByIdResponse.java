package ee.pet.notesmanager.user.web.api;

import ee.pet.notesmanager.user.User;

import java.time.Instant;

public record GetByIdResponse (
        int id,
        String login,
        Instant createdAt,
        Instant updatedAt
) {
    public static GetByIdResponse buildBy(User user) {
        return new GetByIdResponse(user.getId(), user.getLogin(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
