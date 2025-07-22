package peaksoft.sessionjava17restapi.dto.studentDto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import peaksoft.sessionjava17restapi.enums.Gender;
import peaksoft.sessionjava17restapi.enums.StudyFormat;

import java.time.LocalDate;

public record StudentRequest(
        Long id,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        Gender gender,
        String email,
        String password,
        StudyFormat studyFormat
) {
}
