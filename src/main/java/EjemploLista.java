import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EjemploLista extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton button1;
    private JButton button2;
    private JList list1;
    private JList list2;

    public EjemploLista() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        DefaultListModel<String> m1=new DefaultListModel<>();
        DefaultListModel<String> m2=new DefaultListModel<>();
        String[] frutas={"Manzana", "Pera", "Durazno","Naranja","Mandarina", "Sandía", "Melón calameño", "Melún Tuna"};
        int i=0;
        for (String fruta : frutas) {
            m1.addElement(fruta);
        }
        list1.setModel(m1);
        list2.setModel(m2);

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
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               List<String> selection=list1.getSelectedValuesList();
                for (String s : selection) {
                    m2.addElement(s);
                    m1.removeElement(s);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selection=list2.getSelectedValuesList();
                for (String s : selection) {
                    m1.addElement(s);
                    m2.removeElement(s);
                }
            }
        });
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
        EjemploLista dialog = new EjemploLista();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }
}
