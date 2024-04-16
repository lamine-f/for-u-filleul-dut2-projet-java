package model;

import java.sql.*;

import core.Model;
import tools.Tools;

public class Tasks extends core.Model {

    private int id_task;
    private String title;
    private String state;
    private Date start; 
    private Date end; 
    private int to_id_user;
    private String data;


    //MUTATEURS
    public void setId_task (int u_id_task) {this.id_task = u_id_task;}
    public void setTitle (String u_title) { this.title = u_title;}
    public void setState (String u_state) { this.state = u_state;}
    public void setData (String u_data) { this.data = u_data;}
    public void setStart (Date u_start) { this.start = u_start;}
    public void setEnd (Date u_end) { this.end = u_end;}
    public void setTo_id_user (int u_to_id_user) {this.to_id_user = u_to_id_user;}
    

    //ASCESSEUR
    public String getTitle () { return this.title;}
    public String getData () { return this.data;}
    public Date getStart () { return this.start;}
    public Date getEnd () { return this.end;}

    //CONSTRUCTEUR
    public Tasks () {
    }
    public Tasks (String u_title, String u_data, String u_state, Date u_start, Date u_end, int u_to_id_user) {
        
        setData(u_data);
        setTitle(u_title);
        setState(u_state);
        setStart(u_start);
        setEnd(u_end);
        setTo_id_user(u_to_id_user);
    }


    //FONCTIONS UTILES
    public void initFrom (int id_task) {

    }
    
    public void putOnDataBase () {

        String sql_query = "INSERT INTO tasks (id_task, title, data, state, start, end, to_id_user) VALUES ("+this.id_task+", '"+this.title+"','"+this.data+"','"+this.state+"','"+this.start+"','"+this.end+"',"+this.to_id_user+")";
        
        //Tools.print(sql_query);
        Model.write(sql_query);
    }



    public static Tasks [] getTasks (User u1) {

        try {

            ResultSet rs = Model.read("SELECT * FROM tasks WHERE to_id_user = "+u1.getIdUser()+" LIMIT 1000" );

            Tasks [] ts = new Tasks [Tasks.getTasksNumber(u1)];
            int i = 0;
            while (rs.next()){

                ts[i] = new Tasks(rs.getString("title"), rs.getString("data"), rs.getString("state"), Date.valueOf(rs.getString("start")), Date.valueOf(rs.getString("end")), rs.getInt("to_id_user"));
                i++;
            }
            rs.close();
        
            return ts;
            
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public static int getTasksNumber (User u1) {

        try {

            ResultSet rs = Model.read("SELECT * FROM tasks WHERE to_id_user = "+u1.getIdUser()+" LIMIT 1000" );
            int i = 0;
            while (rs.next()){
                i++;
            }

            rs.close();
            return i;
            
        }catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }

}



