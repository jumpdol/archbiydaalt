package biydaalt;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerProduct{
    public static void visibleTrue(){
        //Creating the Frame
        JFrame frame = new JFrame("Main frame");
        frame.setSize(400, 400);
        frame.getContentPane().setLayout(null);

        JLabel productIdLabel = new JLabel("Бүтээгдэхүүний дугаар");
        productIdLabel.setBounds(58,7,220,23);
        frame.getContentPane().add(productIdLabel);
        JTextField productId;

        productId = new JTextField();
        productId.setBounds(58,27,120,23);
        frame.getContentPane().add(productId);
        productId.setColumns(10);

        JLabel productNameLabel = new JLabel("Бүтээгдэхүүний нэр");
        productNameLabel.setBounds(58,47,220,23);
        frame.getContentPane().add(productNameLabel);
        JTextField productName;

        productName = new JTextField();
        productName.setBounds(58,67,120,23);
        frame.getContentPane().add(productName);
        productName.setColumns(10);

        JLabel productPriceLabel = new JLabel("Бүтээгдэхүүний үнэ");
        productPriceLabel.setBounds(58,87,220,23);
        frame.getContentPane().add(productPriceLabel);
        JTextField productPrice;

        productPrice = new JTextField();
        productPrice.setBounds(58,107,120,23);
        frame.getContentPane().add(productPrice);
        productPrice.setColumns(10);

        JLabel productCountLabel = new JLabel("Бүтээгдэхүүний тоо");
        productCountLabel.setBounds(58,127,220,23);
        frame.getContentPane().add(productCountLabel);
        JTextField productCount;

        productCount = new JTextField();
        productCount.setBounds(58,147,120,23);
        frame.getContentPane().add(productCount);
        productCount.setColumns(10);

        JButton button = new JButton("Бүртгэх");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"Амжилттай бүртгэгдлээ");
            }
        });

        button.setBounds(58,297,120,23);
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }


}
