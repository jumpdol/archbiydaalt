package biydaalt.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import biydaalt.model.productModel;

import static java.lang.Integer.parseInt;

public class FirstFrame {

    private JFrame frame;
    private JTextField name;
    private JTextField sid;
    private JTextField section;
    private JTextField enrollment;
    private JTable table;

    int row;
    ArrayList<productModel> productList;
    DefaultTableModel dtm;
    String header[]= new String[]{"product Name","product ID","product une","product too"};


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FirstFrame window = new FirstFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void displayStudentDetails(){
        dtm.setRowCount(0);
        for(int i=0; i<productList.size();i++){
            Object[] obj={productList.get(i).getName(),productList.get(i).getId(),productList.get(i).getUne(),productList.get(i).getCount()};
            dtm.addRow(obj);
        }
    }

    /**
     * Create the application.
     */
    public FirstFrame() {
        initialize();
        productList=new ArrayList<>();
        dtm=new DefaultTableModel(header,0);
        table.setModel(dtm);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 204, 51));
        frame.setBounds(100, 100, 1079, 546);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblStudentName = new JLabel("baraanii ner");
        lblStudentName.setForeground(new Color(0, 0, 128));
        lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStudentName.setBounds(29, 29, 102, 26);
        frame.getContentPane().add(lblStudentName);

        name = new JTextField();
        name.setBounds(127, 35, 111, 20);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JLabel lblStudentId = new JLabel("baraanii ID");
        lblStudentId.setForeground(new Color(0, 0, 128));
        lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStudentId.setBounds(29, 66, 102, 26);
        frame.getContentPane().add(lblStudentId);

        sid = new JTextField();
        sid.setColumns(10);
        sid.setBounds(127, 72, 111, 20);
        frame.getContentPane().add(sid);

        JLabel lblSection = new JLabel("baraanii une");
        lblSection.setForeground(new Color(0, 0, 128));
        lblSection.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSection.setBounds(29, 103, 102, 26);
        frame.getContentPane().add(lblSection);

        section = new JTextField();
        section.setColumns(10);
        section.setBounds(127, 109, 111, 20);
        frame.getContentPane().add(section);

        JLabel lblEnrollment = new JLabel("baraanii too");
        lblEnrollment.setForeground(new Color(0, 0, 128));
        lblEnrollment.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEnrollment.setBounds(29, 140, 102, 26);
        frame.getContentPane().add(lblEnrollment);

        enrollment = new JTextField();
        enrollment.setColumns(10);
        enrollment.setBounds(127, 146, 111, 20);
        frame.getContentPane().add(enrollment);

        JButton btnAdd = new JButton("Нэмэх");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                productModel data = new productModel(parseInt(sid.getText()),name.getText(),section.getText(),parseInt(enrollment.getText()));
                productList.add(data);
                displayStudentDetails();
            }
        });
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAdd.setBounds(29, 194, 89, 23);
        frame.getContentPane().add(btnAdd);

        JButton btnDelete = new JButton("устгах");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice=JOptionPane.showConfirmDialog(null, "Delete this data ?", "Delete",JOptionPane.YES_NO_OPTION);
                if(choice==0){
                    dtm.removeRow(row);
                    productList.remove(row);
                    displayStudentDetails();
                }

            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnDelete.setBounds(142, 194, 89, 23);
        frame.getContentPane().add(btnDelete);

        JButton btnUpdate = new JButton("Шинэчлэх");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                productList.get(row).ner=name.getText();
                productList.get(row).id=parseInt(sid.getText());
                productList.get(row).une=section.getText();
                productList.get(row).count=parseInt(enrollment.getText());
                displayStudentDetails();
            }
        });
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnUpdate.setBounds(29, 232, 89, 23);
        frame.getContentPane().add(btnUpdate);

        JButton btnRefresh = new JButton("Хоослох");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                name.setText("");
                sid.setText("");
                section.setText("");
                enrollment.setText("");
            }
        });
        btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRefresh.setBounds(142, 232, 89, 23);
        frame.getContentPane().add(btnRefresh);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(279, 36, 737, 339);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                row=table.getSelectedRow();

                name.setText(dtm.getValueAt(row, 0).toString());
                sid.setText(dtm.getValueAt(row, 1).toString());
                section.setText(dtm.getValueAt(row, 2).toString());
                enrollment.setText(dtm.getValueAt(row, 3).toString());

            }
        });
        scrollPane.setViewportView(table);
    }

}