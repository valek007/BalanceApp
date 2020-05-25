import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExpenseAccount extends JPanel{

    private Label incomeLabel = new Label("Income: ",2);
    private Label expensesLabel = new Label("Expenses: ",2);
    private Label balanceLabel = new Label("Balance:  ",2);
    private static JTextField incomeField = new JTextField("0",15);
    private static JTextField expensesField = new JTextField("0",15);
    private static JTextArea balanceArea = new JTextArea("0",1,15);

    private JButton balanceButton = new JButton("Balance");

    private Box mainBox = Box.createVerticalBox();
    private Box box1 = Box.createHorizontalBox();
    private Box box2 = Box.createHorizontalBox();
    private Box box3 = Box.createHorizontalBox();
    private Box box4 = Box.createHorizontalBox();

    public static void setIncomeField(String text) {
        incomeField.setText(text);
    }

    public static void setExpensesField(String text) {
        expensesField.setText(text);
    }

    public static void setBalanceArea(String text) {
        balanceArea.setText(text);
    }

    public static JTextField getIncomeField() {
        return incomeField;
    }

    public static JTextField getExpensesField() {
        return expensesField;
    }

    public JTextArea getBalanceArea() {
        return balanceArea;
    }

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
        box4.add(balanceButton);

        mainBox.add(box1);
        mainBox.add(box2);
        mainBox.add(box3);
        mainBox.add(box4);

        setSize(400,150);
        add(mainBox);
    }
}
