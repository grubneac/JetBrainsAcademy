package interfaceExample;

interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here
class AccountServiceImpl implements AccountService {
    private Account[] accounts;

    public AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        for (Account curAccount : accounts) {
            if (curAccount.getOwner().getId() == id) {
                return curAccount;
            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        long counter = 0L;
        for (Account curAccount : accounts) {
            if (curAccount.getBalance() > value) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Account[] accounts = {new Account(12, 5847, new User(1, "user1", "xyz")),
                              new Account(14, 5848, new User(5, "user2", "abz"))};
        AccountService service = new AccountServiceImpl(accounts);
        Account temp = service.findAccountByOwnerId(5L); // returns an account where owner id is 10
        System.out.println(temp.getId());
        System.out.println(service.countAccountsWithBalanceGreaterThan(5849L));
    }
}

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
