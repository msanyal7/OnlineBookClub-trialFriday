package TrackProgress.View;

import javax.swing.*;

public class AddBookForm extends JPanel{
    private JPanel addBookpnl;
    private JTextField nameTextField;
    private JTextField authorTextField;
    private JTextField numPagesTextField;
    private JButton addButton;
    private JButton backButton;
    private JLabel addABookLabel;
    private JLabel nameLabel;
    private JLabel authorLabel;
    private JLabel pagesLabel;

    public JPanel getPanel() {
        return addBookpnl;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getAuthorTextField() {
        return authorTextField;
    }

    public JTextField getNumPagesTextField() {
        return numPagesTextField;
    }
}
