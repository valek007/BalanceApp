import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private Label incomeLabel = new Label("Income");
    private Label expensesLabel = new Label("Expenses");
    private Label balanceLabel = new Label("Balance");
    private JTextField incomeField = new JTextField(10);
    private JTextField expensesField = new JTextField(10);
    private JTextArea balanceField = new JTextArea(1,10);
    private JButton saveButton = new JButton("Save");
    private JButton balanceButton = new JButton("Balance");
    private Box mainBox = Box.createVerticalBox();
    private Box box1 = Box.createHorizontalBox();
    private Box box2 = Box.createHorizontalBox();
    private Box box3 = Box.createHorizontalBox();
    private Box box4 = Box.createHorizontalBox();

    public MyFrame() throws HeadlessException {

        box1.add(incomeLabel);
        box1.add(incomeField);
        box2.add(expensesLabel);
        box2.add(expensesField);
        box3.add(balanceLabel);
        box3.add(balanceField);
        box4.add(saveButton);
        box4.add(balanceButton);

        mainBox.add(box1);
        mainBox.add(box2);
        mainBox.add(box3);
        mainBox.add(box4);

        add(mainBox);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,200,300,150);
        setVisible(true);
    }
}
