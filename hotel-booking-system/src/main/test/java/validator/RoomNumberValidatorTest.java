package validator;

import org.example.validator.RoomNumberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomNumberValidatorTest {
    @Test
    void shouldReturnTrueIfValid(){
        RoomNumberValidator roomNumberValidator = new RoomNumberValidator();
        assertTrue(roomNumberValidator.isValid("321B"));
    }
    @Test
    void shouldReturnFalseIfInvalid(){
        RoomNumberValidator roomNumberValidator = new RoomNumberValidator();
        assertFalse(roomNumberValidator.isValid("32A"));
    }
}
