import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExpenseAccount extends JPanel{

    public static final String FROMINCOME = "income";
    public static final String FROMEXPENSE = "expense";

    private Label fromIncomeLabel = new Label("From ",2);
    private Label fromExpenseLabel = new Label("From ",2);
    private static JTextField fromIncomeField = new JTextField(FROMINCOME, 15);
    private static JTextField fromExpenseField = new JTextField(FROMEXPENSE,15);


    private Label incomeLabel = new Label("income: ",2);
    private Label expenseLabel = new Label("expense: ",2);
    private Label balanceLabel = new Label("Balance:  ",2);
    private static JTextField incomeField = new JTextField("0",6);
    private static JTextField expensesField = new JTextField("0",6);
    private static JTextArea balanceArea = new JTextArea("0",1,6);

    private JButton balanceButton = new JButton("Balance",new ImageIcon(MyFrame.RESOURCES+"balance.png"));

    private Box mainBox = Box.createVerticalBox();
    private Box box1 = Box.createHorizontalBox();
    private Box box2 = Box.createHorizontalBox();
    private Box box3 = Box.createHorizontalBox();
    private Box box4 = Box.createHorizontalBox();

    public static void setFromIncomeField(String text) {
        fromIncomeField.setText(text);
    }

    public static void setFromExpenseField(String text) {
        fromExpenseField.setText(text);
    }

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

    public static JTextField getFromIncomeField() {
        return fromIncomeField;
    }

    public static JTextField getFromExpensesField() {
        return fromExpenseField;
    }

    public JTextArea getBalanceArea() {
        return balanceArea;
    }

    public ExpenseAccount() {

        incomeField.setMaximumSize(incomeField.getPreferredSize());
        expensesField.setMaximumSize(expensesField.getPreferredSize());
        balanceArea.setMaximumSize(balanceArea.getPreferredSize());
        balanceArea.setEditable(false);

        fromIncomeField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                fromIncomeField.setText("");
            }
        });

        fromExpenseField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                fromExpenseField.setText("");
            }
        });


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

        box1.add(fromIncomeLabel);
        box1.add(fromIncomeField);
        box1.add(incomeLabel);
        box1.add(incomeField);
        box2.add(fromExpenseLabel);
        box2.add(fromExpenseField);
        box2.add(expenseLabel);
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
