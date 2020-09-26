package ComboBox_Source;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JTextArea textArea1;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        comboBox1.addItemListener(e -> {
            String strData = null;
            strData = "선택 항목 : " + Objects.requireNonNull(comboBox1.getSelectedItem()).toString() + "입니다. \n";
            textArea1.setText(strData);
        });
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
