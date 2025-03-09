import org.example.observer.NotificationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {
    @Test
    void testUpdateNotification() {
        NotificationService service = new NotificationService();
        assertDoesNotThrow(() -> service.update("Nova tarefa adicionada"));
    }
}
