/**
 * implements command interface
 * this add columns for database
 */
public class AlterAdd implements Command {
    /**
     * execure method
     * @param dataBase is data base
     * @param account is bank account
     * @param key is key for hash map
     * @param stringProperties string properties
     * @param doubleProperties is double properties
     * @param stringOrDouble if it is true properties value string otherwise false
     * @return Account class
     */
    @Override
    public Account execute(DataBase dataBase, Account account, String key, String stringProperties, double doubleProperties, boolean stringOrDouble) {
        if(stringOrDouble==true){
           account.getAlterString().put(key,stringProperties);

        }else{

            account.getAlterDouble().put(key,doubleProperties);
            System.out.println(account);
        }


        return account;
    }
    /**
     * roll back execute method
     * @param dataBase is data base
     * @param account is bank account
     * @param stringProperties string properties
     * @param doubleProperties is double properties
     * @param stringOrDouble if it is true properties value string otherwise false
     * @return account class
     */
    @Override
    public Account undo(DataBase dataBase, Account account, String key, String stringProperties, double doubleProperties, boolean stringOrDouble) {

        if(stringOrDouble==true){
                account.getAlterString().remove(key);
        }else{
            account.getAlterDouble().remove(key);
        }

        return null;
    }



}
