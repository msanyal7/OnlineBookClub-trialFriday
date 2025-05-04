package Homepage.View;

import javax.swing.*;
import java.awt.*;

public class HomepageView extends JFrame{
    private JTabbedPane tabbedPane;

    public HomepageView() {
        setTitle("Homepage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void addTab(String title, JPanel content) {
        tabbedPane.addTab(title, content);
    }

    public void showView() {
        setVisible(true);
    }
}