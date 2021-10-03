package ru.dsemenko.pollrest.web.utils.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.dsemenko.pollrest.web.config.AppDataInit;
import ru.dsemenko.pollrest.web.utils.validators.exceptions.ValidatorException;

import java.util.function.Predicate;

class ValidatorCondition<T>  {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorCondition.class);
    private final String errMessage;
    private final Predicate<T> condition;

    public ValidatorCondition(Predicate<T> condition, String errMessage) {
        this.condition = condition;
        this.errMessage = errMessage;
    }

    public void check(T obj) throws ValidatorException {
        if (!condition.test(obj)) {
            LOGGER.error("Validator failed on {} with message \"{}\"", obj, errMessage);
            throw new ValidatorException(errMessage);
        }
    }
}
