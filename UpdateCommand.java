/**
 * this class implements command interface
 * and has update class
 *
 */
public class UpdateCommand implements Command{
    /**
     * Update class variable
     */
    private Update update;

    /**
     * constructor
     * @param update is Update class variable
     */
    public UpdateCommand(Update update) {
        this.update = update;
    }

    /**
     * update variable execute update operation for account in database
     * @param dataBase is data base
     * @param account is bank account
     * @param giver giver man
     * @param receiver receiver man
     * @param amount money amount
     * @param addOrTakeOutMoney give or receive money
     * @return Account class
     */
    @Override
    public Account execute(DataBase dataBase, Account account, String giver, String receiver, double amount, boolean addOrTakeOutMoney) {
        System.out.println("run update execute");
        account = update.update(account,amount,addOrTakeOutMoney);
        System.out.println(account);
        return account;
    }

    /**
     * roll back execute method
     * @param dataBase is data base
     * @param account is bank account
     * @param giver giver man
     * @param receiver receiver man
     * @param amount money amount
     * @param addOrTakeOutMoney give or receive money
     * @return Account class
     */
    @Override
    public Account undo(DataBase dataBase, Account account, String giver, String receiver, double amount, boolean addOrTakeOutMoney) {
        System.out.println("run update undo");
       if(addOrTakeOutMoney==true){
           addOrTakeOutMoney=true;
       }
       else{
           addOrTakeOutMoney=false;
       }
       account=update.update(account,amount,addOrTakeOutMoney);
        System.out.println(account);
        return account;
    }

    /**
     * get update variable
     * @return Update class
     */
    public Update getUpdate() {
        return update;
    }

    /**
     * update Update variable
     * @param update Update class
     */
    public void setUpdate(Update update) {
        this.update = update;
    }
}
