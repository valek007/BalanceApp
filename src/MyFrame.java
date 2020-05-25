import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public static final String RESOURCES = "out/production/Balance/resources/";

    private FileBarMenu barMenu = new FileBarMenu();
    private ExpenseAccount account = new ExpenseAccount();
    private Toolkit myScreen = Toolkit.getDefaultToolkit();
    private Image appIcon = myScreen.getImage(RESOURCES+"wallet.png");


    public MyFrame() throws HeadlessException {

        add(account, BorderLayout.SOUTH);
        add(barMenu);


        setTitle("Wallet Balance");
        setIconImage(appIcon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,200,440,200);
        setResizable(false);
        setVisible(true);
    }
}
