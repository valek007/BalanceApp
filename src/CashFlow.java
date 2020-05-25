import java.util.ArrayList;
import java.util.HashMap;

public class CashFlow {

    private static int totalRecordCounter = 0;

    private ArrayList<String> fromIncomeCash = new ArrayList<>();
    private ArrayList<String> fromExpenseCash = new ArrayList<>();

    private String fromIncome;
    private String fromExpense;

    private ArrayList<Double> totalIncomeCash = new ArrayList<>();
    private ArrayList<Double> totalExpenseCash = new ArrayList<>();
    private double income;
    private double expense;

    private double balance = 0;


    public void setFromIncome(String fromIncome) {
        this.fromIncome = fromIncome;
        fromIncomeCash.add(fromIncome);
    }

    public void setFromExpense(String fromExpense) {
        this.fromExpense = fromExpense;
        fromExpenseCash.add(fromExpense);
    }

    public void setIncome(double income) {
        this.income = income;
        totalIncomeCash.add(income);
        incrementRecord();
    }

    public void setExpense(double expense) {
        this.expense = expense;
        totalExpenseCash.add(expense);
    }

    public double getBalance() {
        return balance;
    }

    public double getTotalIncomeCash() {

        double incomeResult = 0;

        for(Double x: totalIncomeCash){
            incomeResult+=x;
        }
        return incomeResult;
    }

    public double getTotalExpenseCash() {

        double expenseResult = 0;

        for(Double j: totalExpenseCash){
            expenseResult+=j;
        }
        return expenseResult;
    }

    public double getTotalBalance(){

        return getTotalIncomeCash() - getTotalExpenseCash();
    }

    public ArrayList<String> getFromIncomeCash() {
        return fromIncomeCash;
    }

    public ArrayList<String> getFromExpenseCash() {
        return fromExpenseCash;
    }

    public ArrayList<Double> getIncomeCash() {
        return totalIncomeCash;
    }

    public ArrayList<Double> getExpenseCash() {
        return totalExpenseCash;
    }


    public synchronized int incrementRecord(){
        return totalRecordCounter++;
    }

    public int getTotalRecordCounter() {
        return totalRecordCounter;
    }
}
