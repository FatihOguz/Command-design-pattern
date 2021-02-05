import java.util.Stack;

/**
 * add features all accounts in database
 * for example add address columns for all accounts in database
 * and this class implements Command interface
 */
public class addPropertiesAllData implements Command {
    /**
     * this array hold commands
     * these commands do commands
     * for example select , update,
     *              select alter
     *              etc
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
     * for hash maps key
     */
    private String key;
    /**
     *  string value  for stringAlter
     */
    private String stringProperties;
    /**
     * double value for doubleAlter
     */
    private double doubleProperties;
    /**
     * lag to understand whether the attribute to be added is string type or number type.
     */
    private boolean stringOrDouble;

    /**
     * add features for all accounts in database
     * @param dataBase is database
     * @param commands in macro command for operations
     */
    public addPropertiesAllData(DataBase dataBase,Command[] commands) {
        this.dataBase = dataBase;
        setCommands(commands);
    }

    /**
     * execute command
     * @param database is database
     * @param key key for hashmap
     * @param stringProperties value string
     * @param doubleProperties value double
     * @param stringOrDouble flag for string or double if string true
     */
    public void execute(DataBase database,String key,String stringProperties,Double doubleProperties,boolean stringOrDouble){
        this.key=key;
        this.stringProperties=stringProperties;
        this.doubleProperties=doubleProperties;
        this.stringOrDouble=stringOrDouble;
        commands[0].execute(this.getDataBase(),this.account,key,stringProperties,doubleProperties,stringOrDouble);
        this.key=key;
        this.stringProperties=stringProperties;
        this.doubleProperties=doubleProperties;
        this.stringOrDouble=stringOrDouble;


    }

    /**
     * this method is empty
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

        return null;
    }

    /**
     * undo command
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
       commands[0].undo(this.getDataBase(),this.account,this.key,this.stringProperties,this.doubleProperties,this.stringOrDouble);
        return null;
    }

    /**
     * call undo(this.getDataBase(),this.account,this.key,this.stringProperties,this.doubleProperties,this.stringOrDouble);
     * When executing execute, information was saved to the elements of the class.
     */
    public void undo(){
        undo(this.getDataBase(),this.account,this.key,this.stringProperties,this.doubleProperties,this.stringOrDouble);
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
     * get key
     * @return string
     */
    public String getKey() {
        return key;
    }

    /**
     * update key
     * @param key is string
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * get string properties for hashmap
     * @return string
     */
    public String getStringProperties() {
        return stringProperties;
    }

    /**
     * update string properties
     * @param stringProperties is string
     */

    public void setStringProperties(String stringProperties) {
        this.stringProperties = stringProperties;
    }

    /**
     * get double properties
     * @return double
     */
    public double getDoubleProperties() {
        return doubleProperties;
    }

    /**
     * update double properties
     * @param doubleProperties is double
     */
    public void setDoubleProperties(double doubleProperties) {
        this.doubleProperties = doubleProperties;
    }

    /**
     * if it is string ,return true,it is double return false
     * @return boolean
     */
    public boolean isStringOrDouble() {
        return stringOrDouble;
    }

    /**
     * update boolean value
     * @param stringOrDouble boolean
     */
    public void setStringOrDouble(boolean stringOrDouble) {
        this.stringOrDouble = stringOrDouble;
    }
}
