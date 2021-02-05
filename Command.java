/**
 * this interface declare execute and undo for update,select and alter operations
 */
public interface Command {
    /**
     * this method do special wanted operation
     * @param dataBase is data base
     * @param account is bank account
     * @param giver giver man
     * @param receiver receiver man
     * @param amount money amount
     * @param addOrTakeOutMoney give or receive money
     * @return Account class
     */
    Account execute(DataBase dataBase,Account account,String giver,String receiver,double amount,boolean addOrTakeOutMoney);

    /**
     *
     * this method is rollback database
     * @param dataBase is data base
     * @param account is bank account
     * @param giver giver man
     * @param receiver receiver man
     * @param amount money amount
     * @param addOrTakeOutMoney give or receive money
     * @return Account class
     */
    Account undo(DataBase dataBase,Account account,String giver,String receiver,double amount,boolean addOrTakeOutMoney);
}
