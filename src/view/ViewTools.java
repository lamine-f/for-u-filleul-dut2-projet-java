package view;

public class ViewTools {

    private static void print(String str){
        System.out.print(str);

    }
    private static String horizontal (String str, String replace) {
        String motif = "";
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == '\t'){
                for (int j=0; j<2; j++)
                    motif+=replace;
            }
            motif+=replace;
        }

        return motif;
    }

    private static String simplehorizontal (String str, String replace) {
        String motif = "";
        for (int i=0; i<50; i++){
            if (str.charAt(i) == '\t'){
                for (int j=0; j<2; j++)
                    motif+=replace;
            }
            motif+=replace;
        }

        return motif;
    }
    
    public static void template(String body){

        print(cover(body, "-", 2));


        print("\n");
    } 


    public static void simpletemplate(String body ){

        print(simpleCover(body, "-", 2));


        print("\n");
    } 


    public static String simpleCover (String body, String motif, int line) {
        String res = "";

        String topRender = simplehorizontal(body, motif);
        String bottomRender = "";
        for (int i=0; i<line; i++){
            topRender+="\n";
            bottomRender+="\n";
        }
        bottomRender += simplehorizontal(body, motif);


        res+=topRender;
        res+=body;
        res+=bottomRender;

        return res;
    }


    public static String cover (String body, String motif, int line) {
        String res = "";

        String topRender = horizontal(body, motif);
        String bottomRender = "";
        for (int i=0; i<line; i++){
            topRender+="\n";
            bottomRender+="\n";
        }
        bottomRender += horizontal(body, motif);


        res+=topRender;
        res+=body;
        res+=bottomRender;

        return res;
    }
}

