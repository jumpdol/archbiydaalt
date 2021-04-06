package biydaalt.ui;

import biydaalt.model.productModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainFrame {

    ArrayList<productModel> productList;
    String header[]= new String[]{"Product id","Product ner","Product une","Product too"};

    DefaultTableModel dtm;
    int row,col;

    public static void visibleTrue(ArrayList<productModel> data){




        //Creating the Frame
        JFrame frame = new JFrame("Main frame");
        frame.setSize(400, 400);
        JPanel panel = new JPanel();

        JButton registerProductButton =new JButton();
        JButton sellProductButton =new JButton();


        registerProductButton.setText("Бараа бүртгэх");
        sellProductButton.setText("Бараа зарах");

        panel.add(registerProductButton);
        panel.add(sellProductButton);




        frame.add(panel);

        registerProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerProduct.visibleTrue();
            }
        });

        frame.setVisible(true);
    }
}