package TableSorting_Source;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.*;
import java.util.Vector;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JTree tree1;
    private JLabel lblPath;
    private JButton btnAdd;
    private JButton btnDelete;

    DefaultTreeModel defaultTreeModel = null;
    DefaultTreeSelectionModel defaultTreeSelectionModel = new DefaultTreeSelectionModel();
    DefaultMutableTreeNode defaultMutableTreeNode_root = new DefaultMutableTreeNode("강의자료");
    DefaultMutableTreeNode defaultMutableTreeNode_com = new DefaultMutableTreeNode("컴퓨터언어");

    public MainFrame() {

        defaultTreeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        Vector<DefaultMutableTreeNode> myVC = new Vector<DefaultMutableTreeNode>();
        String[] objFolder = {"Java", "C#", "JSP"};
        for (int idx = 0; idx < objFolder.length; idx++) {
            myVC.add(new DefaultMutableTreeNode(objFolder[idx]));
            defaultMutableTreeNode_com.add(myVC.get(idx));
        }
        defaultMutableTreeNode_root.add(defaultMutableTreeNode_com);
        defaultTreeModel = new DefaultTreeModel(defaultMutableTreeNode_root);
        tree1.setModel(defaultTreeModel);
        tree1.setEditable(true);
        setContentPane(contentPane);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tree1.addComponentListener(new ComponentAdapter() {
        });

        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
                if (node == null) return;

                lblPath.setText("Path : " + node.getUserObject() + "선택 !!! \n");
            }
        });

        tree1.addTreeExpansionListener(new TreeExpansionListener() {
            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                lblPath.setText("Path : " + event.getPath() + "\n");
            }

            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                lblPath.setText("Path : " + event.getPath() + "\n");
            }
        });

        btnAdd.addActionListener(e -> {
            int index = 0;

            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("새 폴더");
            index = node.getChildCount();
            defaultTreeModel.insertNodeInto(node1, node, index);
            tree1.setModel(defaultTreeModel);
            tree1.setSelectionModel(defaultTreeSelectionModel);
        });

        btnDelete.addActionListener(e -> {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();

            defaultTreeModel.removeNodeFromParent(node);
            tree1.setModel(defaultTreeModel);
            tree1.setSelectionModel(defaultTreeSelectionModel);
        });
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
