import org.example.validator.AmountValidator;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AmoundValidatorTest {
    
    @Test
    void shouldGreaterThan0() {
        AmountValidator amountValidator = new AmountValidator();
        assertTrue(amountValidator.isValid(3));
    }
}
