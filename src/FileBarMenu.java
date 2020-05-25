import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileBarMenu extends JPanel{

    private CashFlow cashFlow = new CashFlow();

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");

    private JMenuItem newItem = new JMenuItem("New");
    private JMenuItem saveItem = new JMenuItem("Save");
    private JMenuItem loadItem = new JMenuItem("Load");
    private JMenuItem exportItem = new JMenuItem("Export");

    public FileBarMenu() {

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cashFlow = new CashFlow();

                ExpenseAccount.setFromIncomeField(ExpenseAccount.FROMINCOME);
                ExpenseAccount.setFromExpenseField(ExpenseAccount.FROMEXPENSE);

                ExpenseAccount.setIncomeField("0");
                ExpenseAccount.setExpensesField("0");
                ExpenseAccount.setBalanceArea("0");
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cashFlow.setFromIncome(ExpenseAccount.getFromIncomeField().getText());
                cashFlow.setFromExpense(ExpenseAccount.getFromExpensesField().getText());
                cashFlow.setIncome(Double.parseDouble(ExpenseAccount.getIncomeField().getText()));
                cashFlow.setExpense(Double.parseDouble(ExpenseAccount.getExpensesField().getText()));

                ExpenseAccount.setFromIncomeField(ExpenseAccount.FROMINCOME);
                ExpenseAccount.setFromExpenseField(ExpenseAccount.FROMEXPENSE);

                ExpenseAccount.setIncomeField("0");
                ExpenseAccount.setExpensesField("0");
                ExpenseAccount.setBalanceArea("0");
            }
        });

        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String income = "" + cashFlow.getTotalIncomeCash();
                ExpenseAccount.setIncomeField(income);

                String expense = "" + cashFlow.getTotalExpenseCash();
                ExpenseAccount.setExpensesField(expense);

                String balance = "" + cashFlow.getTotalBalance();
                ExpenseAccount.setBalanceArea(balance);
            }
        });

        exportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("balance.txt"))){

                    String fromIncomeCash = "";
                    String fromExpenseCash = "";
                    String incomeCash = "";
                    String expenseCash = "";

                    int counter = cashFlow.getTotalRecordCounter();

                    for(int i=0; i<counter; i++){
                        fromIncomeCash = cashFlow.getFromIncomeCash().get(i);
                        fromExpenseCash = cashFlow.getFromExpenseCash().get(i);
                        incomeCash = "" + cashFlow.getIncomeCash().get(i);
                        expenseCash = "" + cashFlow.getExpenseCash().get(i);
                        writer.write("From " + fromIncomeCash + " income: " + incomeCash + "$ \n");
                        writer.write("From " + fromExpenseCash + " expense: " + expenseCash + "$ \n");
                    }

                    writer.write("\nTotal income: " + cashFlow.getTotalIncomeCash() + "$ \n");
                    writer.write("Total expense: " + cashFlow.getTotalExpenseCash() + "$ \n");
                    writer.write("Balance: " + cashFlow.getTotalBalance() + "$ \n\n");

                }  catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });




        menuFile.add(newItem);
        menuFile.add(saveItem);
        menuFile.add(loadItem);
        menuFile.add(exportItem);
        menuBar.add(menuFile);
        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        setSize(10,10);
    }
}
