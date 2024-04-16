package core;

import java.sql.Date;


import view.ViewTools;
import model.Tasks;
import model.User;
import tools.Tools;
import view.Views;

public class Controller {


    public static int getUserChoice (String entry, int min, int max) {

        int choice;
        do {

            choice = Integer.valueOf(Tools.input(entry));
        }
        while(choice < min || choice > max);

        return choice;
    }

    public static int Control_ACCEUIL (int choice, User u1) {
        
        //CONNEXION
        if (choice == 1){
            if (Controller.Connection(u1))
                return 1;

            return -1;
        }

        //INSCRIPTION
        else if (choice == 2){
            Controller.Registration(u1);
            u1.putOnDataBase();
            return 1;
        }

        return -1;
    }

    public static void Control_MENU_CONNECTED (int choice, User u1) {

        while(true) {

            //Ajouter une tache
            if (choice == 1){
                Tasks t1 = new Tasks();
                Controller.addTask(u1, t1);
                t1.putOnDataBase();

                return;
            }

            //Voir toutes les taches
            else if (choice == 2){
                Controller.AllSelfTask(u1);
                return;
            }
            
            //Supprimer une taches
            else if (choice == 3){

                return;
            }
            
            //Modifier une tache
            else if (choice == 4){

                return;
            }
        }
        
    }

    public static boolean Connection (User u1) {

        ViewTools.template("Menu: CONNEXION ");
        
        u1.setLogin(Tools.input("LOGIN :"));
        u1.setPassword(Tools.input("PASSWORD :"));

        if (User.shouldConnect(u1)){

            User.initFromDB(u1);
            return true;
        }

        Tools.print("Désolé, veuillez creer un compte");
        return false;
    }


    public static void Registration (User u1) {

        ViewTools.template("Bienvenue ");

        String firstname = Tools.input("Prénom(s) :");
        String lastname = Tools.input("Nom :");
        String login = Tools.input("Nom d'utilisateur :");
        String password;
        String password2;
        boolean hide = false;
        do {

            if (hide)
                ViewTools.template("Pas de correspondance !");
            password = Tools.input("Mot de Passe :");
            password2 = Tools.input("Confirmer le Mot de Passe :");
            hide = true;

        }while(!password.equals(password2));
        
        u1.setId_user(Model.setId("user") + 1);
        u1.setLogin(login);
        u1.setPassword(Tools.encrypt(password2));
        u1.setFirstname(firstname);
        u1.setLastname(lastname);

    }


    public static void allTasks (User u1) {

        u1.setTasks(Tasks.getTasks(u1));
        u1.setTasksnumber(Tasks.getTasksNumber(u1));

    }


    public static void addTask (User u1, Tasks t1) {

        //APPELLE AU TASKS 
        String u_title = Tools.input("Titre : ");
        String u_data =Tools.input("Contenue : ");
        String u_state = "in_proccess";        
        Date u_start = new Date(System.currentTimeMillis());
        Date u_end =  Date.valueOf(Tools.input("Date (format YY-MM-DD) : "));;
        int u_to_id_user = u1.getIdUser();

        t1.setId_task(Model.setId("tasks") + 1);
        t1.setTitle(u_title);
        t1.setData(u_data);
        t1.setState(u_state);
        t1.setStart(u_start);
        t1.setEnd(u_end);
        t1.setTo_id_user(u_to_id_user);        
    
        ViewTools.template("Tache ajouter avec sucees");
        //t1.putOnDataBase();
    }


    public static void AllSelfTask (User u1) {
        Controller.allTasks(u1);
        Tasks [] ts = u1.getTasks();

        int len = ts.length;

        if (len >= 1){

            do {
                Tools.print("Mes taches");
                for (int i=0; i<len; i++){
                    int number = i+1;
                    Tools.print(number+") "+ts[i].getTitle()+" Jour: "+ts[i].getEnd());
                }
                Tools.print("\n");
                int choice = Controller.getUserChoice("[1/2] : ",1, len );

                Views.TasksView (ts[choice-1]);
            
            }while(!Tools.input("Voir une autre tache [y/n]: ").equals("n"));
        }else{
            Tools.print("Pas encore de taches !");
        }

        
    }


    public static void removeTask (Tasks t1) {

    }

    public static void modifyTask (Tasks t1) {

    }

    public static void setTaskFinish (Tasks t1) {

    }

    public static void setTaskInprocess (Tasks t1) {

    }
}