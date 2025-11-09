package org.example.validator;

public class RoomNumberValidator implements Validator<String> {
    @Override
    public boolean isValid(String string) {
        return string.matches("\\d{3}[A-Z]");
    }
}
