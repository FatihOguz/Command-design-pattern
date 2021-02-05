

import java.util.ArrayList;
import java.util.Scanner;

/**
 * create a menu
 * this menu give eft,add columns for account and add columns for all accounts in database operations
 *
 */
public class DemoSon {
    /**
     * create menu
     * @param args is empty
     */
    public static void main(String[] args){

        /**
         * array list for accouts
         */
        ArrayList<Account> accounts =new ArrayList<Account>();
        accounts.add(new Account("fatih", 46));
        accounts.add(new Account("mesut", 19));
        accounts.add(new Account("caner", 41));
        /**
         * data base holds arraylist (type account class)
         */
        DataBase dataBase = new DataBase(accounts);
        /**
         * select class
         */
        Select select = new Select();
        /**
         * update class
         */
        Update update = new Update();
        /**
         * account is null
         */
        Account account = null;
        /**
         *  command array for eft operations
         */
        Command[] commandEft = {new SelectCommand(select),new UpdateCommand(update)};
        /**
         * moacro command eft take database and command array for eft operation
         */
        MacroCommandEft eft = new MacroCommandEft(dataBase,commandEft);
        /**
         * command array for add column for a account
         */
        Command[] commandAlterAdd = { new SelectCommand(select), new AlterAdd()};
        /**
         * addPropertiesDataBase add column for a account
         */
        addPropertiesDataBase addPropertiesDataBase = new addPropertiesDataBase(dataBase,commandAlterAdd);
        /**
         * command array for addPropertiesAllData
         */
        Command[] commandAddPropertiesAllData = {new AlterCommand()};
        /**
         * addPropertiesAllData add column for all account in database
         */
        addPropertiesAllData addPropertiesAllData = new addPropertiesAllData(dataBase,commandAddPropertiesAllData);


        /**
         * scanner for take input from user
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * integer value for order of user
         */
        int order=-1;
        while(order!=0){
            System.out.println("exit--->0");
            System.out.println("EFT (send money to someone)----->1");
            System.out.println("enter new information to the account  (alter database)--->2");
            System.out.println("enter new information to the all accounts  (alter database)--->3");
                order= scanner.nextInt();
            if(order==1){
                System.out.println("SHOW DATABASE\n" + dataBase);
                System.out.println("give me your name");
                String giver = scanner.next();
                System.out.println("give me receiver");
                String receiver = scanner.next();
                System.out.println("give me amount");
                double amount = scanner.nextDouble();
                eft.execute(eft.getDataBase(),account,receiver,giver,amount,true);
                System.out.println("SHOW DATABASE\n" + dataBase);
                System.out.println("SORRY, TRANSACTIONS ARE BEING ROLLED BACK DUE TO MALFUNCTION");
                eft.undo();
                System.out.println("SHOW DATABASE\n" + dataBase);
            }
            else if(order==2){
                System.out.println("SHOW DATABASE\n" + dataBase);
                System.out.println("give me your name");
                String giver = scanner.next();
                System.out.println("give me information (string)  (example address,goldAccount etc)");
                String key = scanner.next();
                System.out.println("if information type is string press 1 , if information type is double press 2 ");
                int press= scanner.nextInt();
                if(press==1){
                    System.out.println("write information ( example bahcelievler/Istanbul for address)");
                    String stringProperties=scanner.next();
                    addPropertiesDataBase.execute(giver,key,stringProperties,6,true);
                    System.out.println("SHOW DATABASE\n" + dataBase);
                    System.out.println("SORRY, TRANSACTIONS ARE BEING ROLLED BACK DUE TO MALFUNCTION");
                    addPropertiesDataBase.undo();
                    System.out.println("SHOW DATABASE\n" + dataBase);
                }
                else if(press==2){
                    System.out.println("write information ( example 89 for goldAccount)");
                    Double doubleProperties = scanner.nextDouble();
                    addPropertiesDataBase.execute(giver,key,"1333",doubleProperties,false);
                    System.out.println("SHOW DATABASE\n" + dataBase);
                    System.out.println("SORRY, TRANSACTIONS ARE BEING ROLLED BACK DUE TO MALFUNCTION");
                    addPropertiesDataBase.undo();
                    System.out.println("SHOW DATABASE\n" + dataBase);
                }
                else{
                    System.out.println("please press 1 or 2");
                }

            }
            else if(order == 3){

                System.out.println("SHOW DATABASE\n" + dataBase);
                System.out.println("give me information (string)  (example address,goldAccount etc)");
                String key = scanner.next();
                System.out.println("if information type is string press 1 , if information type is double press 2 ");
                int press= scanner.nextInt();
                if(press==1){
                    System.out.println("write information ( example no address for address)");

                    scanner.next();
                    String stringProperties=scanner.nextLine();
                    addPropertiesAllData.execute(addPropertiesAllData.getDataBase(),key,stringProperties, (double) 6,true);
                    System.out.println("SHOW DATABASE\n" + dataBase);
                    System.out.println("SORRY, TRANSACTIONS ARE BEING ROLLED BACK DUE TO MALFUNCTION");
                    addPropertiesAllData.undo();
                    System.out.println("SHOW DATABASE\n" + dataBase);
                }
                else if(press==2){
                    System.out.println("write information ( example 89 for goldAccount)");
                    Double doubleProperties = scanner.nextDouble();
                    addPropertiesAllData.execute(addPropertiesAllData.getDataBase(),key,"1333",doubleProperties,false);
                    System.out.println("SHOW DATABASE\n" + dataBase);
                    System.out.println("SORRY, TRANSACTIONS ARE BEING ROLLED BACK DUE TO MALFUNCTION");
                    addPropertiesAllData.undo();
                    System.out.println("SHOW DATABASE\n" + dataBase);
                }
                else{
                    System.out.println("please press 1 or 2");
                }


            }
            else{
                System.out.println("please press 0,1,2 or 3");
            }


        }



    }
}
