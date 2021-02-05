/**
 * this class implements command interface
 * implement execute and undo method for alter operation
 * alter operation add columns in database
 */
public class AlterCommand implements Command {
    /**
     *
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
            for(int i=0;i<dataBase.getDatabase().size();i++){
                dataBase.getDatabase().get(i).getAlterString().put(key,stringProperties);
            }

        }else{
            for(int i=0;i<dataBase.getDatabase().size();i++){
                dataBase.getDatabase().get(i).getAlterDouble().put(key,doubleProperties);
            }

        }


        return null;
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
            for(int i=0;i<dataBase.getDatabase().size();i++){
                dataBase.getDatabase().get(i).getAlterString().remove(key);
            }

        }else{
            for(int i=0;i<dataBase.getDatabase().size();i++){
                dataBase.getDatabase().get(i).getAlterDouble().remove(key);
            }

        }

        return null;
    }
}
