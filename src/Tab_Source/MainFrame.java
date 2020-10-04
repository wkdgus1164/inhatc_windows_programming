package Tab_Source;

import jdk.jfr.events.ExceptionThrownEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JProgressBar progressBar1;
    private JButton btnSearch;
    private JLabel lblEndVal;
    private JLabel lblStartVal;
    private JLabel lblTitle;
    private JSlider slider1;
    private JLabel lblLow;
    private JLabel lblHigh;
    private JLabel lblValue;
    private JButton lblSoundValue;
    private JTextField txtInputValue;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        tabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int iTabIndex = 0;
                String strTabTitle = null;

                iTabIndex = tabbedPane1.getSelectedIndex();
                strTabTitle = tabbedPane1.getTitleAt(iTabIndex);
                textField1.setText(strTabTitle + " 정보를 볼 수 있습니다.");
            }
        });
        tabbedPane1.addTab("ProgressBar", tabbedPane2);
        tabbedPane1.addTab("Slider", tabbedPane3);

        textField1.setText("상태 정보 출력");
        btnSearch.addActionListener(e -> fProgressBar_Value());
        slider1.addChangeListener(e -> lblValue.setText(Integer.toString(slider1.getValue())));
        lblSoundValue.addActionListener(e -> slider1.setValue(Integer.parseInt(txtInputValue.getText())));
    }

    private void fProgressBar_Value() {
        try {
            for (int idx = 0; idx <= 100; idx++) {
                progressBar1.setValue(idx);
                Thread.sleep(100);
                lblTitle.setText(idx + "% 검색 중");
            }
        } catch (Exception e) {
            this.setTitle("검색 중단");
        }
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
