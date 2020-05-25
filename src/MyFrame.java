import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    ExpenseAccount account = new ExpenseAccount();

    public MyFrame() throws HeadlessException {

        add(account);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,200,400,150);
        setResizable(false);
        setVisible(true);
    }
}
