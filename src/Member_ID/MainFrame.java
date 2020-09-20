package Member_ID;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JButton regBtn;
    private JTextField idField;
    private JTextField pwField;
    private JTextField pwConfirmField;
    private JTextField nameField;
    private JButton idConfirmBtn;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JLabel pwConfirmLabel;
    private JLabel nameLabel;
    private JButton buttonCancel;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(regBtn);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        idConfirmBtn.addActionListener(e -> {
            System.out.println(idField.getText());
            if (pwField.getText().equals(pwConfirmField.getText())) System.out.print(pwField.getText());
            checkIfIdExists();
        });
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void checkIfIdExists() {
        try {
            File file = new File("C:/Users/wkdgu/Desktop/member.txt");
            FileReader fileReader = new FileReader(file);
            int singleCh = 0;
            while ((singleCh = fileReader.read()) != -1) {
                String result = Character.toString((char) singleCh);
                System.out.print(result);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
