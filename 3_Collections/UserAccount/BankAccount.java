package coll.UserAccounts;

/**
 * A bank account with an associated owner and available funds.
 */
public class BankAccount {
    private double funds;
    private User owner;
    /**
     * Constructs a bank object with $0.0 funds and assigns the owner as the given User.
     *
     * @param owner-  the owner.
     */
    public BankAccount(User owner) {
        this.funds = 0;
        this.owner = owner;
    }

    /**
     * Gets the total funds in the account.
     *
     * @return the total funds.
     */
    public double getFunds() {
        return funds;
    }

    /**
     * Deposits money into the account.
     *
     * @param deposit - the sum of money to be deposited.
     */
    public void deposit(double deposit) {
        funds += deposit;
    }

    /**
     * Withdraws money from the account. Only the owner can withdraw funds.
     *
     * @param user - the user requesting to withdraw funds.
     * @param withdrawal - the amount requested to be withdrawn.
     * @throws UserException if anyone but the owner is attempting to withdraw funds.
     * @throws FundsException if there are insufficient funds in the account.
     */
    public void withdraw(User user, double withdrawal) throws UserException, FundsException {
        //if user requesting withdrawal isn't owner
        if (user != owner){
            throw new UserException();
        }

        //if insufficient funds for withdrawal
        if (funds - withdrawal < 0){
            throw new FundsException();
        } else {
            funds -= withdrawal;
        }


    }
}