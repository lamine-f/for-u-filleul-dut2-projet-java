package view;

import core.Controller;
import model.Tasks;
import model.User;
import tools.Tools;

public class Views {

    public static void MENU_CONNECTED () {

        ViewTools.template("MENU\n1) Ajouter une tache\n2) Voir les taches\n3) Supprimer une tache\n4) Modifier une tache");
    }
    
    public static void ACCEUIL () {
        ViewTools.template("ACCEUIL\n\n1) Se connecter\n2) S'inscrire");
    }

    public static void TasksView (Tasks t1){

        String res = "";
        res+= "TITRE: "+t1.getTitle()+"\n";
        res+= "DESCRIPTION: "+t1.getData()+"\n";
        res+= "DEBUT : "+t1.getStart()+"\n";
        res+= "FIN : "+t1.getEnd()+"\n";

        ViewTools.simpletemplate(res);
    }
}
