import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileBarMenu extends JPanel{

    private CashFlow cashFlow = new CashFlow(0,0);

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
                cashFlow = new CashFlow(0,0);

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
