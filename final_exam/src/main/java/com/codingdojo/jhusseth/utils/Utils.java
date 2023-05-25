package com.codingdojo.jhusseth.utils;

import com.codingdojo.jhusseth.domain.dto.UserDetailsDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public class Utils {

    private static final String DATE_TIME_FORMAT = "HH:mm a MMM d";

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String DATE_INPUT_FORMAT = "yyyy-mm-dd";

    private static final String TIME_ZONE = "America/Bogota";

    public static String encodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
        return passwordEncoder.encode(password);
    }

    public static String concatErrorMessageList(BindingResult errors) {
        if (Objects.nonNull(errors.getFieldError())) {
            return String.format("%s",Objects.requireNonNull(errors.getFieldError().getDefaultMessage()));
        }
        return "";
    }

    public static Optional<String> getCurrentUserLoginUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()).getUsername());
    }

    public static Optional<Long> getCurrentUserLoginId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()).getId());
    }

    private static UserDetailsDTO extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetailsDTO) {
            return (UserDetailsDTO) authentication.getPrincipal();
        }
        return null;
    }

    public static String localDateToString(LocalDate date) {
        if (date != null) {
            return date.toString();
        }
        return null;
    }

    public static LocalDate stringToLocalDate(String date) {
        if (date != null) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
            String localDate = format.format(LocalDate.parse(date));
            return LocalDate.parse(localDate, format);
        }
        return null;
    }

    public static String localDateTimeToString(LocalDateTime date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
            return formatter.format(date);
        }
        return null;
    }

}
