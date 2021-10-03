package ru.dsemenko.pollrest.web.utils.validators.exceptions;

public class ValidatorException extends Exception {
    public ValidatorException(String message) {
        super("Ошибка валидации: " + message);
    }
}
