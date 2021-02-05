import java.util.Stack;

/**
 *  * add features for a account in database
 */
public class addPropertiesDataBase  implements Command{



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
     * constructor
     * @param dataBase is data base
     * @param commands in macro command for operations
     */
    public addPropertiesDataBase(DataBase dataBase,Command[] commands) {
        this.dataBase = dataBase;
       setCommands(commands);
    }


    /**
     * execute command
     * @param name is customer name
     * @param key key for hashmap
     * @param stringProperties value string
     * @param doubleProperties value double
     * @param stringOrDouble flag for string or double if string true
     */
    public void execute(String name,String key,String stringProperties,double doubleProperties,boolean stringOrDouble){

        this.key=key;
        this.stringProperties=stringProperties;
        this.doubleProperties=doubleProperties;
        this.stringOrDouble=stringOrDouble;
        /**
         * do select
         */
        this.account=commands[0].execute(this.dataBase,this.account,name,this.stringProperties,this.doubleProperties,this.stringOrDouble);
        undoStack.push(commands[0]);
        System.out.println("--->" + this.account);
       this.account=commands[1].execute(this.dataBase,this.account,this.key,this.stringProperties,this.doubleProperties,stringOrDouble);
        undoStack.push(commands[1]);
        System.out.println(" ---> " + this.account);
    }




    /**
     *
     * this method is empty
     * @param dataBase is data base
     * @param account is bank account
     * @param key is key for properties hash map
     * @param stringProperties string properties (address,etc)
     * @param doubleProperties double properties (goldAccount ,etc)
     * @param stringOrDouble is boolean if properties string true
     * @return Account class
     */
    @Override
    public Account execute(DataBase dataBase, Account account, String key, String stringProperties, double doubleProperties, boolean stringOrDouble) {
        return null;
    }

    /**
     * roll back of execute method
     * @param dataBase is data base
     * @param account is bank account
     * @param key is key for properties hash map
     * @param stringProperties string properties (address,etc)
     * @param doubleProperties double properties (goldAccount ,etc)
     * @param stringOrDouble is boolean if properties string true
     * @return Account class
     */
    @Override
    public Account undo(DataBase dataBase, Account account, String key, String stringProperties, double doubleProperties, boolean stringOrDouble) {



        //commands[0].undo(this.dataBase,this.account,this.key,this.stringProperties,this.doubleProperties,this.stringOrDouble);
        commands[1].undo(this.dataBase,this.account,this.key,this.stringProperties,this.doubleProperties,this.stringOrDouble);
        return this.account;
    }

    /**
     * call  override  undo
     */

    public void undo(){
        undo(this.dataBase,this.account,this.key,this.stringProperties,this.doubleProperties,this.stringOrDouble);
    }

    /**
     * get command array
     * @return command array
     */
    public Command[] getCommands() {
        return commands;
    }

    /**
     * update command array
     * @param commands command array
     */
    public void setCommands(Command[] commands) {
        this.commands = commands;
    }
}
