import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null account list safely
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            // FIX: dueDate may be null for restructured accounts
            if (account.getDueDate() != null
                    && account.getDueDate().before(new Date())) {

                // FIX: Only overdue accounts with outstanding balance > 0
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
