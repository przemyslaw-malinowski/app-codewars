package interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class SolutionTest {

    public static final String THERE_IS_NO_PERMUTATIONS_THAT_BALANCE_THOSE_ACCOUNTS_TO_THRESHOLD = "There is no permutations that balance those accounts to threshold!";

    @Test
    public void shouldWriteDownThereIsNoPossibleToBalanceAccountsThere() {
        //GIVEN
        Logger log = spy(new Logger());
        Account acct1 = new Account("acct1", 120);
        Account acct2 = new Account("acct2", 70);
        Account acct3 = new Account("acct3", 120);
        Account acct4 = new Account("acct4", 70);
        List<Account> allAccounts = Arrays.asList(acct1, acct2, acct3, acct4);
        Solution.setLogger(log);

        //WHEN
        Solution.balanceAccounts(allAccounts, 100);

        //THEN
        verify(log).info(eq(THERE_IS_NO_PERMUTATIONS_THAT_BALANCE_THOSE_ACCOUNTS_TO_THRESHOLD));
    }

    @Test
    public void shouldWriteDownAllPossibleSolutionsForAccountsSimple() {
        //GIVEN
        Logger log = spy(new Logger());
        Account acct1 = new Account("acct1", 120);
        Account acct2 = new Account("acct2", 70);
        Account acct3 = new Account("acct3", 120);
        List<Account> allAccounts = Arrays.asList(acct1, acct2, acct3);
        Solution.setLogger(log);

        //WHEN
        Solution.balanceAccounts(allAccounts, 100);

        //THEN
        //verify(log).info(eq(THERE_IS_NO_PERMUTATIONS_THAT_BALANCE_THOSE_ACCOUNTS_TO_THRESHOLD));
    }
}