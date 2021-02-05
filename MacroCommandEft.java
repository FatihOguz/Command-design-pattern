import java.util.Stack;

/**
 * this class implement command interface
 * do eft operations
 *
 */
public class MacroCommandEft implements Command {


    /**
     * command array
     */
    private Command[] commands ;
    /**
     * this stack for roll back operatons
     * provides a return with the last mistake made first
     */
    private Stack<Command> undoStack = new Stack<Command>();
    /**
     * this database holds on accounts
     */
    private DataBase dataBase;
    /**
     * this speacial accounts
     */
    private Account account;

    /**
     * is name of giver customer
     */
    private String giver;

    /**
     * is name of receiver customer
     */
    private String receiver;
    /**
     * how many money
     */
    private double amount;
    /**
     *  add or take out money
     */
    private boolean addOrTakeOutMoney;

    /**
     * constructor
     * @param dataBase is database
     * @param commands is command array
     */
    public MacroCommandEft(DataBase dataBase,Command[] commands)
    {
        this.dataBase = dataBase;
        this.commands = commands;
    }

    /**
     *
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
       account = commands[0].execute(dataBase, account, giver, receiver,  amount,addOrTakeOutMoney);
        undoStack.push(commands[0]);
        account=commands[1].execute(dataBase, account, giver, receiver,  amount,addOrTakeOutMoney);
        undoStack.push(commands[1]);
        account=commands[0].execute(dataBase, account,  receiver,giver,  amount,addOrTakeOutMoney);
        undoStack.push(commands[0]);
        account=commands[1].execute(dataBase, account,  receiver,giver,  amount,!addOrTakeOutMoney);
        undoStack.push(commands[1]);

        this.dataBase=dataBase;
        this.receiver=receiver;
        this.giver=giver;
        this.amount=amount;
        this.addOrTakeOutMoney=addOrTakeOutMoney;
        this.account=account;
        return account;
    }

    /**
     * roll back execute method
     * call override undo method
     * @return Account class
     */
    public Account undo(){
        return undo(this.getDataBase(),this.getAccount(),this.getGiver(),this.getReceiver(),this.getAmount(),this.isAddOrTakeOutMoney());
    }

    /**
     *
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
        int count=0;
        while(!undoStack.isEmpty()){
            account=undoStack.lastElement().undo(dataBase, account,giver,receiver,amount,addOrTakeOutMoney);
            undoStack.pop();
            count++;
            if(count==2 ){
                addOrTakeOutMoney=!addOrTakeOutMoney;
                count=0;
            }
        }
        return null;
    }






    /**
     * get commands
     * @return command array
     */
    public Command[] getCommands() {
        return commands;
    }

    /**
     * update commands
     * @param commands command array
     */
    public void setCommands(Command[] commands) {
        this.commands = commands;
    }

    /**
     * get undoStack
     * @return stack
     */
    public Stack<Command> getUndoStack() {
        return undoStack;
    }

    /**
     * update undoStack
     * @param undoStack stack
     */
    public void setUndoStack(Stack<Command> undoStack) {
        this.undoStack = undoStack;
    }

    /**
     * get data base
     * @return Database class
     */
    public DataBase getDataBase() {
        return dataBase;
    }

    /**
     * update data base
     * @param dataBase is data base
     */
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * get account
     * @return Account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * update account
     * @param account is account
     */
    public void setAccount(Account account) {
        this.account = account;
    }


    /**
     * get giver name
     * @return string
     */
    public String getGiver() {
        return giver;
    }

    /**
     * update giver name
     * @param giver is name
     */
    public void setGiver(String giver) {
        this.giver = giver;
    }

    /**
     * get receiver name
     * @return string
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * update receiver name
     * @param receiver name
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * get amount money
     * @return double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * update amount money
     * @param amount double value
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * add or take out money
     * @return boolean
     */
    public boolean isAddOrTakeOutMoney() {
        return addOrTakeOutMoney;
    }

    /**
     * update boolean value
     * @param addOrTakeOutMoney is boolean
     */
    public void setAddOrTakeOutMoney(boolean addOrTakeOutMoney) {
        this.addOrTakeOutMoney = addOrTakeOutMoney;
    }
}
