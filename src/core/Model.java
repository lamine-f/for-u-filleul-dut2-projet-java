package core;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;

public class Model {
    
    protected int id_int;
    protected String id_string;

    public Model (){}
    
    public static void get (String model) {
        String path = "jdbc:sqlite:../bd/GestionDesTaches.db";
        
        try {

            Connection conn = DriverManager.getConnection(path);
            Statement stat = conn.createStatement();

            String sql_query = "SELECT * FROM "+model;
            ResultSet result = stat.executeQuery(sql_query);

            if (model.equals("user"))
                while (result.next()){
                    System.out.print( " ["+result.getInt("id_user")+"]");
                    System.out.print( " ["+result.getString("firstname")+"]");
                    System.out.print( " ["+result.getString("lastname")+"]");
                    System.out.print( " ["+result.getString("login")+"]");
                    System.out.print("\n");
                }

            else 
                while (result.next()){
                    System.out.print( " ["+result.getInt("id_task") +"]");
                    System.out.print( " ["+result.getString("title") +"]");
                    System.out.print( " ["+result.getString("data") +"]");
                    System.out.print( " ["+result.getString("end") +"]");
                    System.out.print("\n");

                }

            result.close();
            stat.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet read (String sql_query) {

        String path = "jdbc:sqlite:../bd/GestionDesTaches.db ";
        
        try {

            Connection conn = DriverManager.getConnection(path);
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(sql_query);

            return result;
            /* 
            while (result.next()){
                System.out.println( result.getString("name"));
            }
            result.close();
            stat.close();
            conn.close();
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void write (String sql_query) {

        String path = "jdbc:sqlite:../bd/GestionDesTaches.db ";
        
        try {

            Connection conn = DriverManager.getConnection(path);
            Statement stat = conn.createStatement();
            stat.execute(sql_query);

            stat.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    


    public static int setId (String model) {
        String path = "jdbc:sqlite:../bd/GestionDesTaches.db";
        
        try {

            Connection conn = DriverManager.getConnection(path);
            Statement stat = conn.createStatement();

            if (model.equals("user")){
                String sql_query = "SELECT id_user FROM "+model+" ORDER BY id_user DESC LIMIT 1";
                
                ResultSet result = stat.executeQuery(sql_query);
                int id = result.getInt("id_user");

                result.close();
                stat.close();
                conn.close();
                return id;
            }

            else{
                String sql_query = "SELECT id_task FROM "+model+" ORDER BY id_task DESC LIMIT 1";
                ResultSet result = stat.executeQuery(sql_query);

                int id = result.getInt("id_task");
                result.close();
                stat.close();
                conn.close();
                return id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    

}
