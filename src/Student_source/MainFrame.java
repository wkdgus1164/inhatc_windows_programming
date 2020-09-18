package Student_source;

import javax.swing.*;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JButton okButton;
    private JLabel titleLabel;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel thirdLabel;
    private JButton buttonOK;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        okButton.addActionListener(e -> {
            firstLabel.setText("Inha Technical College");
            secondLabel.setText("Dept.Computer Science Jang Hyun Han");
            thirdLabel.setText("Jang Hyun Han");
        });
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
