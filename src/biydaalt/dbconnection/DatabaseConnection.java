package biydaalt.dbconnection;

import biydaalt.model.ProductModel;

import java.sql.*;
import java.util.ArrayList;


// Өгөгдлийн сантай ажиллах класс
public class DatabaseConnection {


//    Өгөгдлийн санд хандар атрибутууд
    public static Connection connection;
    private String _DatabaseURl = "jdbc:mysql://localhost:3306/biydaalt";
    private String _DatabaseUsername = "root";
    private String _DatabasePassword = "a123a123";


    //    Байгуулагч фунцк
    public DatabaseConnection(){
        connect();
    }

//    Өгөгдлийн сантай холбогдох үйлдэл
    public void connect(){
        try{
            connection = DriverManager.getConnection(_DatabaseURl, _DatabaseUsername, _DatabasePassword);

        }catch(SQLException e){
            System.out.println("ERROR connecting to database!");
            System.out.println(e.toString());
        }
    }
//    Өгөгдлийн сангаас select хийх үйлдэл
    public ArrayList<ProductModel> select(String query){
        System.out.println(query);
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            ArrayList<ProductModel> list = new ArrayList<>();
            while (rs.next())
            {
                int id = rs.getInt(1);
                String ner = rs.getString(2);
                String une = rs.getString(3);
                int too = rs.getInt(4);
                ProductModel model = new ProductModel(id,ner,une,too);
                list.add(model);
                // print the results
            }
            System.out.println(list.size());
            return list;
        }catch(SQLException e){
            System.out.println("ERROR while executing select query!");
            System.out.println(e.toString());
            return null;
        }
    }
//    Өгөгдлийн санд өөрчлөлт хийх үйлдэл
    public int update(String query){
        try{
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("ERROR while update query");
            System.out.println(e.toString());
            return -1;
        }
    }
//    Өгөгдлийн сангаас нөхцөл шалгах үйлдэл
    public String check(String query){
        String str = "";
        try{
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);
            while (set.next()){
                str = set.getString(1);
            }

            return str;
        }catch(SQLException e){
            System.out.println("ERROR while checking!");
            System.out.println(e.toString());
            return null;
        }
    }
}
