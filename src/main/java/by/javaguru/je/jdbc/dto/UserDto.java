package by.javaguru.je.jdbc.dto;

import by.javaguru.je.jdbc.entity.Gender;
import by.javaguru.je.jdbc.entity.Role;
import by.javaguru.je.jdbc.utils.LocalDateFormatter;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class UserDto {
    int id;
    String name;
    LocalDate birthday;
    String email;
    Role role;
    Gender gender;
}
