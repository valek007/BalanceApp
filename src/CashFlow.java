import java.util.ArrayList;

public class CashFlow {

    private ArrayList<Double> totalIncomeCash = new ArrayList<>();
    private ArrayList<Double> totalExpenseCash = new ArrayList<>();
    private double income;
    private double expense;
    private double balance = 0;

    public CashFlow(double income, double expense) {
        this.income = income;
        this.expense = expense;
        totalIncomeCash.add(income);
        totalExpenseCash.add(expense);
        balance = income - expense;
    }

    public void setIncome(double income) {
        this.income = income;
        totalIncomeCash.add(income);
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
}
