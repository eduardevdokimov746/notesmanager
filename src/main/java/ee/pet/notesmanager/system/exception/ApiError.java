package ee.pet.notesmanager.system.exception;

import java.util.List;

public record ApiError(String status, String message, List<String> errors) {}
