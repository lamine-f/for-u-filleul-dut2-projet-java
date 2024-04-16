//import core.*;
//import model.*;
import core.Controller;
import core.Model;
import model.Tasks;
import model.User;
import tools.Tools;
import view.*;


/*
REMARQUES
=> javac App.java && java -classpath ".:../bd/GestionDesTaches.db" App

=> trim les entrées (')

*/



public class App {

    public static void main (String [] args){

       
        
        User u2 = new User("just", "passer", "Mouhamed", "Leye");
        u2.setId_user(1);
        
        User u1 = new User();
        do {
            
            u1 = new User();
            Views.ACCEUIL();
            int choice = Controller.getUserChoice("[1/2] : ",1, 2 );

            if (Controller.Control_ACCEUIL(choice, u1) == 1){

                do {

                    Views.MENU_CONNECTED();
                    Controller.Control_MENU_CONNECTED(Controller.getUserChoice("[1/2/3/4] : ",1, 4 ),  u1);
                        
                }
                while(!Tools.input("Deconnecter [y/n]: ").equals("y"));


            }

        }
        while(!Tools.input("Quitter [y/n]: ").equals("y"));
        /* 
         * 
         Views.MENU();
         int choice = Controller.getUserChoice("[1/2/3/4] : ",1, 4 );
         Controller.Control(choice);
         */

        /* 
        //u2.putOnDataBase();
        //t1.putOnDataBase();

        User u1 = new User();
        Tasks t1 = new Tasks();

        Controller.Connection(u1);
        Controller.Registration(u1);

        //GET ACCEUIL VIEW
        ACCEUIL
        1) Se connecter
        2) S'inscrire

        //GET MENU
        MENU
        1) Ajouter une tache
        2) Voir les taches
        3) Supprimer une tache
        4) Modifier une tache

            ADD TASKS
            Controller.addTask(u1, t1);


            SEE TASKS
            Controller.allTasks(u1);
            Tools.print(u2.getTasks()[0].getTitle());

            REMOVE TASKS

            MODIFY TASKS



        */
        //Controller.allTasks(u2);

        //Tools.print(u2.getTasks()[0].getTitle());


        /*
         *
            
            Tasks t1 = new Tasks();
            Controller.addTask(u2, t1);
            */

        
    
        




        /* 
         Model.get("user");
         Tools.print("-------------------------");
         Model.get("tasks");
         */
    }

}