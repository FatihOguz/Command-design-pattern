import java.util.HashMap;

/**
 * this class define bank account
 */
public class Account {
    /**
     * customer name
     */
    private String name;
    /**
     * how many money
     */
    private double amount;
    /**
     * string features for alter methods
     */
    private HashMap<String,String> alterString=new HashMap<String,String>();
    /**
     * double features for alter methods
     */
    private HashMap<String,Double> alterDouble=new HashMap<String ,Double>();

    /**
     * constructor
     * @param name customer name
     * @param amount how many money
     */
    public Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    /**
     * get name
     * @return string
     */
    public String getName() {
        return name;
    }

    /**
     * update name
     * @param name customer name
     */
    public void setName(String name) {
        this.name = name;
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
     * @param amount how many money
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * show informatiom of account
     * @return String
     */
    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", alterString=" + alterString +
                ", alterDouble=" + alterDouble +
                '}';
    }

    /**
     * get string type features for alter methods
     * @return hashmap
     */
    public HashMap<String, String> getAlterString() {
        return alterString;
    }

    /**
     * update alterString
     * @param alterString hashmap
     */
    public void setAlterString(HashMap<String, String> alterString) {
        this.alterString = alterString;
    }

    /**
     * get alter double
     * @return hashmap
     */
    public HashMap<String, Double> getAlterDouble() {
        return alterDouble;
    }

    /**
     * update alterDouble
     * @param alterDouble hashmap
     */
    public void setAlterDouble(HashMap<String, Double> alterDouble) {
        this.alterDouble = alterDouble;
    }
}
