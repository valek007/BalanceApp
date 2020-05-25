import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExpenseAccount extends JPanel{

    private CashFlow cashFlow = new CashFlow(0,0);

    private Label incomeLabel = new Label("Income: ",2);
    private Label expensesLabel = new Label("Expenses: ",2);
    private Label balanceLabel = new Label("Balance:  ",2);
    private JTextField incomeField = new JTextField("0",15);
    private JTextField expensesField = new JTextField("0",15);
    private JTextArea balanceArea = new JTextArea("0",1,15);

    private JButton newButton = new JButton("New");
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");
    private JButton balanceButton = new JButton("Balance");

    private Box mainBox = Box.createVerticalBox();
    private Box box1 = Box.createHorizontalBox();
    private Box box2 = Box.createHorizontalBox();
    private Box box3 = Box.createHorizontalBox();
    private Box box4 = Box.createHorizontalBox();

    public ExpenseAccount() {

        incomeField.setMaximumSize(incomeField.getPreferredSize());
        expensesField.setMaximumSize(expensesField.getPreferredSize());
        balanceArea.setMaximumSize(balanceArea.getPreferredSize());
        balanceArea.setEditable(false);

        incomeField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                incomeField.setText("");
                balanceArea.setText("0");
            }
        });

        expensesField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                expensesField.setText("");
                balanceArea.setText("0");
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cashFlow = new CashFlow(0,0);

                incomeField.setText("0");
                expensesField.setText("0");
                balanceArea.setText("0");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cashFlow.setIncome(Double.parseDouble(incomeField.getText()));
                cashFlow.setExpense(Double.parseDouble(expensesField.getText()));

                incomeField.setText("0");
                expensesField.setText("0");
                balanceArea.setText("0");
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String income = "" + cashFlow.getTotalIncomeCash();
                incomeField.setText(income);

                String expense = "" + cashFlow.getTotalExpenseCash();
                expensesField.setText(expense);

                String balance = "" + cashFlow.getTotalBalance();
                balanceArea.setText(balance);
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double income = Double.parseDouble(incomeField.getText());
                double expense = Double.parseDouble(expensesField.getText());

                String result = "" + (income - expense);
                balanceArea.setText(result);

            }
        });

        box1.add(incomeLabel);
        box1.add(incomeField);
        box2.add(expensesLabel);
        box2.add(expensesField);
        box3.add(balanceLabel);
        box3.add(balanceArea);
        box4.add(newButton);
        box4.add(saveButton);
        box4.add(loadButton);
        box4.add(balanceButton);

        mainBox.add(box1);
        mainBox.add(box2);
        mainBox.add(box3);
        mainBox.add(box4);

        add(mainBox);
    }
}
