package QNO52;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Account {
    int id;
    double balance;

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    void debit(double amt) { balance -= amt; }
    void credit(double amt) { balance += amt; }
    double getBalance() { return balance; }
}

interface AccountRepository {
    Account findById(int id);
    void update(Account account);
}

interface NotificationService {
    void send(String message);
}

class AccountService {
    private final AccountRepository repo;
    private final NotificationService notifier;

    AccountService(AccountRepository repo, NotificationService notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    boolean transfer(int fromId, int toId, double amount) {
        Account from = repo.findById(fromId);
        Account to = repo.findById(toId);
        if (from == null || to == null || from.getBalance() < amount) return false;

        from.debit(amount);
        to.credit(amount);
        repo.update(from);
        repo.update(to);
        notifier.send("Transferred " + amount + " from " + fromId + " to " + toId);
        return true;
    }
}

public class AccountServiceTest {
    @Test
    void testSuccessfulTransfer() {
        AccountRepository repo = mock(AccountRepository.class);
        NotificationService notify = mock(NotificationService.class);
        Account from = new Account(1, 1000);
        Account to = new Account(2, 500);

        when(repo.findById(1)).thenReturn(from);
        ((Object) when(repo.findById(2))).thenReturn(to);

        AccountService service = new AccountService(repo, notify);
        boolean result = service.transfer(1, 2, 300);

        assertTrue(result);
        assertEquals(700, from.getBalance());
        assertEquals(800, to.getBalance());

        verify(repo, times(2)).update(any());
        verify(notify, times(1)).send("Transferred 300.0 from 1 to 2");
    }

    private Object when(Account byId) {
		// TODO Auto-generated method stub
		return null;
	}

	private AccountRepository mock(Class<AccountRepository> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    void testInsufficientBalance() {
        AccountRepository repo = mock(AccountRepository.class);
        NotificationService notify = mock(NotificationService.class);
        when(repo.findById(1)).thenReturn(new Account(1, 100));
        when(repo.findById(2)).thenReturn(new Account(2, 100));

        AccountService service = new AccountService(repo, notify);
        assertFalse(service.transfer(1, 2, 200));

        verify(repo, never()).update(any());
        verify(notify, never()).send(any());
    }

    @Test
    void testAccountNotFound() {
        AccountRepository repo = mock(AccountRepository.class);
        NotificationService notify = mock(NotificationService.class);
        when(repo.findById(1)).thenReturn(null);

        AccountService service = new AccountService(repo, notify);
        assertFalse(service.transfer(1, 2, 100));

        verify(repo, never()).update(any());
        verify(notify, never()).send(any());
    }
}
