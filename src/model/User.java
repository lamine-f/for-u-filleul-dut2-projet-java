package model;

import core.*;
import tools.*;
import java.sql.*;

public class User extends Model {

    private int id_user;
    private String login;
    private String password;
    private String firstname; 
    private String lastname; 

    private Tasks [] tasks;
    private int tasksnumber;


    //MUTATEUR
    public void setId_user (int u_id_user) {this.id_user = u_id_user;}
    public void setLogin (String u_login) { this.login = u_login;}
    public void setPassword (String u_password) { this.password = u_password;}
    public void setFirstname (String u_firstname) { this.firstname = u_firstname;}
    public void setLastname (String u_lastname) { this.lastname = u_lastname;}
    
    public void setTasks (Tasks [] u_tasks) { this.tasks = u_tasks; }
    public void setTasksnumber (int u_tasksnumber) {this.tasksnumber = u_tasksnumber;}


    //Ascesseur
    public int getIdUser () { return this.id_user;}
    public String getLogin () { return this.login;}
    public String getPassword () { return this.password;}
    public String getFirstname () { return this.firstname;}

    public Tasks [] getTasks () { return this.tasks; }


    //CONSTRUCTEUR
    public User () {
    }
    public User (String u_login, String u_password, String u_firstname, String u_lastname) {
        
        setLogin(u_login);
        setPassword(u_password);
        setFirstname(u_firstname);
        setLastname(u_lastname);
    }


    public void putOnDataBase () {

        String sql_query = "INSERT INTO user (id_user, login, password, firstname, lastname) VALUES ("+this.id_user+", '"+this.login+"','"+this.password+"','"+this.firstname+"','"+this.lastname+"')";
        
        Model.write(sql_query);
    }


    public static void initFromDB (User u1) {

        try {

            ResultSet rs = Model.read("SELECT * FROM user WHERE login = '"+u1.getLogin()+"' LIMIT 1");

            u1.setFirstname(rs.getString("firstname"));
            u1.setLastname(rs.getString("lastname"));
            u1.setId_user(rs.getInt("id_user"));
            
            rs.close();
        }catch(Exception e){

        }

    }

    public static boolean shouldConnect (User u1) {

        try {

            ResultSet rs = Model.read("SELECT password FROM user WhERE login = '"+u1.getLogin()+"' LIMIT 1");
            String password = rs.getString("password");

            rs.close();
            if (password.equals(u1.getPassword()))
                return true;
            
        }catch(Exception e){

        }
        return false;
    }






    
}
