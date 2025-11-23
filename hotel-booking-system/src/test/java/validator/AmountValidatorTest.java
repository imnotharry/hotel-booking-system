package validator;

import org.example.validator.AmountValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmountValidatorTest {
    @Test
    void shouldGreaterThan0() {
        AmountValidator amountValidator = new AmountValidator();
        assertTrue(amountValidator.isValid(3));
    }

    @Test
    void shouldReturnFalse() {
        AmountValidator amountValidator = new AmountValidator();
        assertFalse(amountValidator.isValid(-3));
    }

    @Test
    void shouldReturnFalseWhen0() {
        AmountValidator amountValidator = new AmountValidator();
        assertFalse(amountValidator.isValid(0));
    }
}
