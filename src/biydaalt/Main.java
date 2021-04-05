package biydaalt;

import java.sql.*;

class Main {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/biydaalt";
        String username = "root";
        String password = "a123a123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Users";
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            int count = 0;
            while (res.next()){
                String ner = res.getString(1);
                String owog = res.getString("owog");
                String utas = res.getString(3);
                count++;
                System.out.println("Customer "+ count + ": " + ner + ": " + owog+ ": " + utas);
            }
            connection.close();

            statement.close();
            connection.close();


            System.out.println("Connected database");
        } catch (SQLException e){
            System.out.println("Oops, Error!");
            e.printStackTrace();
        }
        mainFrame.visibleTrue();
    }
}