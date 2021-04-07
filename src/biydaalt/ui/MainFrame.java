package biydaalt.ui;


import biydaalt.dbconnection.DatabaseConnection;
import biydaalt.model.ProductModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


//Үнлдсэн GUI харуулах класс
public class MainFrame {

    private JFrame frame;
    private JTextField name;
    private JTextField sid;
    private JTextField une;
    private JTextField count;
    private JTable table;

    DatabaseConnection DB = new DatabaseConnection();
    int row;
    ArrayList<ProductModel> productList;
    DefaultTableModel dtm;
    String header[]= new String[]{"Барааны нэр","Барааны дугаар","Барааны үнэ","Барааны тоо"};

// Хүснэгтэд барааны жагсаалтыг харуулах үйлдэл
    public void displayProductDetails() {

        productList = DB.select("SELECT * FROM Product");
        dtm.setRowCount(0);
        for(int i=0; i<productList.size();i++){
            Object[] obj={productList.get(i).getName(),productList.get(i).getId(),productList.get(i).getUne(),productList.get(i).getCount()};
            dtm.addRow(obj);
        }
    }

    //    Байгуулагч фунцк
    public MainFrame() {
        initialize();
        productList=new ArrayList<>();
        dtm=new DefaultTableModel(header,0);
        displayProductDetails();
        table.setModel(dtm);
    }

//    Гол UI зурах функц
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1079, 546);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblProductName = new JLabel("Барааны нэр");
        lblProductName.setForeground(new Color(0, 0, 128));
        lblProductName.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblProductName.setBounds(29, 29, 102, 26);
        frame.getContentPane().add(lblProductName);

        name = new JTextField();
        name.setBounds(147, 35, 111, 20);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JLabel lblProductId = new JLabel("Барааны дугаар");
        lblProductId.setForeground(new Color(0, 0, 128));
        lblProductId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblProductId.setBounds(29, 66, 152, 26);
        frame.getContentPane().add(lblProductId);

        sid = new JTextField();
        sid.setColumns(10);
        sid.setBounds(147, 72, 111, 20);
        frame.getContentPane().add(sid);

        JLabel lblUne = new JLabel("Барааны үнэ");
        lblUne.setForeground(new Color(0, 0, 128));
        lblUne.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblUne.setBounds(29, 103, 102, 26);
        frame.getContentPane().add(lblUne);

        une = new JTextField();
        une.setColumns(10);
        une.setBounds(147, 109, 111, 20);
        frame.getContentPane().add(une);

        JLabel lblCount = new JLabel("Барааны тоо");
        lblCount.setForeground(new Color(0, 0, 128));
        lblCount.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCount.setBounds(29, 140, 102, 26);
        frame.getContentPane().add(lblCount);

        count = new JTextField();
        count.setColumns(10);
        count.setBounds(147, 146, 111, 20);
        frame.getContentPane().add(count);

        JButton btnAdd = new JButton("Нэмэх");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(une.getText().isEmpty() || name.getText().isEmpty() || count.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Аль нэг өгөгдөл хоосон байна");
                }else{
                    DB.update("INSERT INTO Product (product_id,product_name,product_price,product_count) VALUES(null,'"+name.getText()+"','"+une.getText()+"',"+parseInt(count.getText())+")");
                    name.setText("");
                    sid.setText("");
                    une.setText("");
                    count.setText("");
                    displayProductDetails();
                }
            }
        });
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAdd.setBounds(29, 194, 89, 23);
        frame.getContentPane().add(btnAdd);

        JButton btnSell = new JButton("Зарах");
        btnSell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sid.getText().isEmpty() || count.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Барааны дугаар эсвэл тоогоо оруулна уу");
                }
                else
                    {
                        if(!une.getText().isEmpty() || !name.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null,"Барааны нэр эсвэл үнэ хэсэгт мэдээлэл байна");
                        }
                        else
                        {
                            int choice=JOptionPane.showConfirmDialog(null, sid.getText()+" дугаартай барааг зарахдаа итгэлтэй байна уу ?", "Зарах",JOptionPane.YES_NO_OPTION);
                            if(choice==0) {
                                String str = DB.check("SELECT IF(product_count < "+parseInt(count.getText())+", \"more\" , \"less\") FROM Product WHERE product_id = "+sid.getText()+"");
                                System.out.println(str);
                                if(str.equals("less")){
                                    DB.update("UPDATE Product SET product_count = product_count - " + parseInt(count.getText()) + " WHERE product_id = " + parseInt(sid.getText()) + "");
                                    sid.setText("");
                                    count.setText("");
                                    displayProductDetails();
                                }else{
                                    JOptionPane.showMessageDialog(null,"Барааны үлдэгдэл хүрэхгүй байна");
                                    sid.setText("");
                                    count.setText("");
                                }
                            }
                        }
                    }
                }
            }
        );

        btnSell.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSell.setBounds(142, 194, 89, 23);
        frame.getContentPane().add(btnSell);

        JButton btnAddCount = new JButton("Барааны тоо нэмэх");
        btnAddCount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sid.getText().isEmpty() || count.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Барааны дугаар эсвэл тоогоо оруулна уу");
                }else{
                    if(!une.getText().isEmpty() || !name.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Барааны нэр эсвэл үнэ хэсэгт мэдээлэл байна");
                    }else{
                        DB.update("UPDATE Product SET product_count = product_count + " + parseInt(count.getText()) + " WHERE product_id = " + parseInt(sid.getText()) + "");
                        sid.setText("");
                        count.setText("");
                        displayProductDetails();
                    }

                }
            }
        });
        btnAddCount.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAddCount.setBounds(29, 232, 200, 23);
        frame.getContentPane().add(btnAddCount);

        JButton btnUpdatePrice = new JButton("Барааны үнэ өөрчлөх");
        btnUpdatePrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(sid.getText().isEmpty() || une.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Барааны дугаар эсвэл үнээ оруулна уу");
                }else{
                    if(!count.getText().isEmpty() || !name.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Барааны нэр эсвэл тоо хэсэгт мэдээлэл байна");
                    }else{
                        DB.update("UPDATE Product SET product_price = '" + une.getText() + "' WHERE product_id = " + parseInt(sid.getText())+"");
                        sid.setText("");
                        une.setText("");
                        displayProductDetails();
                    }
                }
            }
        });
        btnUpdatePrice.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnUpdatePrice.setBounds(29, 272, 200, 23);
        frame.getContentPane().add(btnUpdatePrice);

        JLabel hintText =new JLabel("Та барааг устгахыг хүсвэл барааны ID-г оруулж устгах товчыг дарна уу!");
        hintText.setBounds(142,350,700,100);
        JLabel hintText1 =new JLabel("Харин шинэчлэхийг шинэчлэх барааны ID-г оруулж бусад мэдээллээ оруулснаар мэдээлэл шинэчлэгднэ!");
        hintText1.setBounds(142,390,700,100);
        frame.getContentPane().add(hintText);
        frame.getContentPane().add(hintText1);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(279, 36, 737, 339);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                row=table.getSelectedRow();
                sid.setText(dtm.getValueAt(row, 1).toString());

            }
        });
        scrollPane.setViewportView(table);
        frame.setVisible(true);
    }

}