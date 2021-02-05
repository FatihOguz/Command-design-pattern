import java.util.ArrayList;

/**
 * define database
 */
public class DataBase {
    /**
     * arraylist for Account class
     */
    private ArrayList<Account> database;

    /**
     * constructor
     * @param database arraylist for account class
     */
    public DataBase(ArrayList<Account> database) {
        this.database = database;
    }

    /**
     * get database
     * @return arraylist (account class type)
     */
    public ArrayList<Account> getDatabase() {
        return database;
    }

    /**
     * update database
     * @param database arraylist (account class type)
      */
    public void setDatabase(ArrayList<Account> database) {
        this.database = database;
    }

    /**
     * show information for database
     * @return String
     */
    @Override
    public String toString() {
       String res="";
        for(int i=0;i<database.size();i++){
           res = res + this.database.get(i) + "\n";
       }
        return res;
    }
}
