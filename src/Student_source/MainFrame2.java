package Student_source;

import javax.swing.*;
import java.awt.event.*;

public class MainFrame2 extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JButton 입력InputButton;
    private JTextArea textArea1;

    public MainFrame2() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        입력InputButton.addActionListener(e -> {
            String strCRLF = "\n";
            String strData = "";
            strData = textArea1.getText();
            strData += textArea1.getText() + strCRLF;
            textArea1.setText(strData);
        });
    }

    public static void main(String[] args) {
        MainFrame2 dialog = new MainFrame2();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
