package CheckBoxRadioButton_source;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JCheckBox 현금이체CheckBox;
    private JCheckBox 카드CheckBox;
    private JCheckBox 포인트CheckBox;
    private JRadioButton 회원RadioButton;
    private JRadioButton 비회원RadioButton;
    private JButton btnOK;
    private JTextArea textArea1;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strData = "회원님은 ";

                if (현금이체CheckBox.isSelected()) strData += 현금이체CheckBox.getText();
                if (카드CheckBox.isSelected()) strData += 카드CheckBox.getText();
                if (포인트CheckBox.isSelected()) strData += 포인트CheckBox.getText();
                strData += " 결제 방법을 선택하였습니다. \n";
                textArea1.setText(strData);
                strData = null;
            }
        });
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
