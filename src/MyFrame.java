import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    FileBarMenu barMenu = new FileBarMenu();
    ExpenseAccount account = new ExpenseAccount();

    public MyFrame() throws HeadlessException {

        add(barMenu);
        add(account, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,200,400,200);
        setResizable(false);
        setVisible(true);
    }
}
