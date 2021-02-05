/**
 * implement select operation for database
 */
public class Select {
    /**
     * select method
     * select account from database
     * @param database is database
     * @param name name of account
     * @return Account class
     */
    public Account select(DataBase database,String name){

        try{
            for(int i = 0;i<database.getDatabase().size();i++){
                if(database.getDatabase().get(i).getName().equals(name)){
                    System.out.println(database.getDatabase().get(i));
                    return database.getDatabase().get(i);
                }
            }
        }catch(Exception e){
            System.out.println("not in the database\n System exit");
            System.exit(1);
        }

        return null;

    }
}
