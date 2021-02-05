/**
 * implement update operation for database
 *
 */
public class Update {
    /**
     * add money to account
     * @param account is Account class
     * @param amount is amount of money
     * @return Account class
     */
    public Account addMoney(Account account,double amount){
        account.setAmount(account.getAmount()+ amount);
        return account;
    }

    /**
     * take out money from account
     * @param account is account class
     * @param amount is amount of money
     * @return Account class
     */
    public Account takeOutMoney(Account account ,double amount){
        account.setAmount(account.getAmount() - amount);
        return account;
    }

    /**
     * update operation for database
     * @param account is Account class
     * @param amount is amount of money
     * @param addOrTakeOutMoney  is boolean ad or take out money from account
     * @return Account class
     */
    public Account update(Account account,double amount,boolean addOrTakeOutMoney){
        try{
            if(addOrTakeOutMoney==true){

                addMoney(account,amount);
                return account;
            }
            else{
                takeOutMoney(account,amount);
                return account;
            }
        }catch(Exception ex){
            System.out.println("there are not account\n System exit");
            System.exit(1);
        }
      return null;
    }


}
