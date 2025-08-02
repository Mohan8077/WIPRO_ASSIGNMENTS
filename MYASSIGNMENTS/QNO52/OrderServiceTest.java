package QNO52;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PaymentService {
    void processPayment() {
        System.out.println("Payment processed");
    }
}

class OrderService {
    private final PaymentService paymentService;

    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    void placeOrder() {
        paymentService.processPayment();
    }
}

public class OrderServiceTest {
    @Test
    void testPlaceOrder() {
        PaymentService mockPayment = mock(PaymentService.class);
        OrderService service = new OrderService(mockPayment);
        service.placeOrder();

        verify(mockPayment, times(1)).processPayment();
    }
}
