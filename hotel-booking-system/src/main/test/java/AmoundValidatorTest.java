import org.example.validator.AmountValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmoundValidatorTest {
    @Test
    void shouldGreaterThan0() {
        AmountValidator amountValidator = new AmountValidator();
        assertTrue(amountValidator.isValid(3));
    }
}
