/**
 * this class implement command interface
 */
public class SelectCommand implements Command {
    /**
     * select class
     * implement select operation
     */
    private Select select;

    /**
     * constructor
     * @param select Select class
     */
    public SelectCommand(Select select) {
        this.select = select;
    }

    /**
     * execute select operation
     * @param dataBase is data base
     * @param account is bank account
     * @param giver giver man
     * @param receiver receiver man
     * @param amount money amount
     * @param addOrTakeOutMoney give or receive money
     * @return account class
     */
    @Override
    public Account execute(DataBase dataBase, Account account, String giver, String receiver,double amount, boolean addOrTakeOutMoney) {
        System.out.println("run select execute");
        Account account1 = this.select.select(dataBase,giver);
        if(account1== null){
            System.out.println("there is not account in database so system exit");
            System.exit(7);
        }
        return account1;
    }

    /**
     * roll back execurte method
     * @param dataBase is data base
     * @param account is bank account
     * @param giver giver man
     * @param receiver receiver man
     * @param amount money amount
     * @param addOrTakeOutMoney give or receive money
     * @return Account class
     */
    @Override
    public Account undo(DataBase dataBase, Account account, String giver, String receiver, double amount,boolean addOrTakeOutMoney) {
        System.out.println("run select undo");
        Account account1=this.execute(dataBase,account,giver,receiver,amount,addOrTakeOutMoney);
        System.out.println(account1);
        return account1;
    }

    /**
     * get select variable
     * @return Select class
     */
    public Select getSelect() {
        return select;
    }

    /**
     * update select variable
     * @param select Select class
     */
    public void setSelect(Select select) {
        this.select = select;
    }
}
