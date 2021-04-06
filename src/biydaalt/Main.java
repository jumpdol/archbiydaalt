package biydaalt;

import biydaalt.model.productModel;
import biydaalt.ui.FirstFrame;

import java.sql.*;
import java.util.ArrayList;

class Main {

    public static ArrayList<productModel> data = new ArrayList<productModel>();

    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/biydaalt";
        String username = "root";
        String password = "a123a123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Product";
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            int count = 0;
            while (res.next()){
                int id = res.getInt(1);
                String ner = res.getString(2);
                String une = res.getString(3);
                int too = res.getInt(4);
                productModel model = new productModel(id,ner,une,too);
                data.add(model);
                System.out.println(data.get(0).getName());
                count++;
                System.out.println("Baraanii id: "+ id + ": " + ner + ": " + une+ ": " + too);
            }

            statement.close();
            connection.close();


            System.out.println("Connected database");
        } catch (SQLException e){
            System.out.println("Oops, Error!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new FirstFrame();
    }

}