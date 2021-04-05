package biydaalt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class mainFrame {
    public static void visibleTrue(){
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