package Table_Source;

import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JTextField txtOrder;
    private JTextField txtMovie;
    private JTextField txtGallery;
    private JTable jTable1;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnInsert.addActionListener(e -> {
            int iCntRow = 0;
            iCntRow = jTable1.getSelectedRow();
            for (int idx = 0; idx < jTable1.getRowCount(); idx++) {
                if (jTable1.getValueAt(idx, 0) == null) {
                    iCntRow = idx;
                    break;
                }
            }

            jTable1.setValueAt(txtOrder.getText(), iCntRow, 0);
            jTable1.setValueAt(txtMovie.getText(), iCntRow, 1);
            jTable1.setValueAt(txtGallery.getText(), iCntRow, 2);
        });

        btnUpdate.addActionListener(e -> {
            int iCntRow = 0;
            iCntRow = jTable1.getSelectedRow();

            jTable1.setValueAt(txtOrder.getText(), iCntRow, 0);
            jTable1.setValueAt(txtMovie.getText(), iCntRow, 1);
            jTable1.setValueAt(txtGallery.getText(), iCntRow, 2);
        });
        btnDelete.addActionListener(e -> {
            int iCntRow = 0;
            iCntRow = jTable1.getSelectedRow();

            for (int idx = 0; idx < jTable1.getColumnCount(); idx++) {
                jTable1.setValueAt(null, iCntRow, idx);
            }

            txtOrder.setText(null);
            txtMovie.setText(null);
            txtGallery.setText(null);
        });
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
