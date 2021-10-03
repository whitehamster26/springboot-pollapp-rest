package ru.dsemenko.pollrest.web.utils.validators;

import ru.dsemenko.pollrest.web.utils.validators.exceptions.ValidatorException;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Validator<T> {
    protected final Set<ValidatorCondition<T>> conditions;

    public Validator() {
        this.conditions = new HashSet<>();
    }

    protected void addCondition(Predicate<T> condition, String errorMessage) {
        conditions.add(new ValidatorCondition<>(condition, errorMessage));
    }

    public void validate(T obj) throws ValidatorException {
        for (ValidatorCondition<T> condition : conditions) {
            condition.check(obj);
        }
    }
}
