import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private Label incomeLabel = new Label("Income: ",2);
    private Label expensesLabel = new Label("Expenses: ",2);
    private Label balanceLabel = new Label("Balance:  ",2);
    private JTextField incomeField = new JTextField(15);
    private JTextField expensesField = new JTextField(15);
    private JTextArea balanceArea = new JTextArea(1,15);
    private JButton saveButton = new JButton("Save");
    private JButton balanceButton = new JButton("Balance");
    private Box mainBox = Box.createVerticalBox();
    private Box box1 = Box.createHorizontalBox();
    private Box box2 = Box.createHorizontalBox();
    private Box box3 = Box.createHorizontalBox();
    private Box box4 = Box.createHorizontalBox();

    public MyFrame() throws HeadlessException {

        incomeField.setMaximumSize(incomeField.getPreferredSize());
        expensesField.setMaximumSize(expensesField.getPreferredSize());
        balanceArea.setMaximumSize(balanceArea.getPreferredSize());

        box1.add(incomeLabel);
        box1.add(incomeField);
        box2.add(expensesLabel);
        box2.add(expensesField);
        box3.add(balanceLabel);
        box3.add(balanceArea);
        box4.add(saveButton);
        box4.add(balanceButton);

        mainBox.add(box1);
        mainBox.add(box2);
        mainBox.add(box3);
        mainBox.add(box4);

        add(mainBox);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,200,250,150);
        setResizable(false);
        setVisible(true);
    }
}
