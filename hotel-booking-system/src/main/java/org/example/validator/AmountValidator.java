package org.example.validator;

public class AmountValidator implements Validator<Integer> {
    @Override
    public boolean isValid(Integer integer) {
        return integer > 0;
    }
}
