import org.example.chain.TitleValidation;
import org.example.template.Task;
import org.example.factory.PersonalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TitleValidationTest {
    private TitleValidation titleValidation;

    @BeforeEach
    void setUp() {
        titleValidation = new TitleValidation();
    }

    @Test
    void testValidTitle() {
        Task validTask = new PersonalTask().createTask("Valido", "titulo ok");
        assertDoesNotThrow(() -> titleValidation.validate(validTask));
    }

    @Test
    void testInvalidTitle() {
        Task invalidTask = new PersonalTask().createTask("", "Sem título");
        assertThrows(IllegalArgumentException.class, () -> titleValidation.validate(invalidTask));
    }
}
