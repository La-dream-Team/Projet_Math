
package Code;

import java.util.Scanner;

public final class GrapheSimpleIO{
    // methodes auxiliaires

    // on lui donne un matrcie et un numero de ligne et on recupère la ligne corresponendente au numero
    public static int[] getLine(int x, int[][] matrice){
        return matrice[x-1];
    }

    // methode qui renvoie l'entier ecrit sur le flot de lecture
    public static int lireEntier(){
        Scanner scan = new Scanner(system.in);

        return scan.nextInt();
    }

    // methode qui affiche une liste d'adjacence
    public static void afficherlistAdj(int[] list){
        if((list.length > 1) && (list[1] != 0)){
            System.out.printf("%d : ", list[0]);
            
            // on affiche tous les numéros de case 
            for(int i=1 ; i<list.length; i++){
                if(list[i] !=0){
                    System.out.printf("%d ",list[i]);
                }
            }
        }
        else{
            // si la liste est vide on affiche juste 0
            if(list.length > 1){
                System.out.printf("0\n");
            }
            else{
                // si la liste n'est pas vide on afficher la ligne et 0 
                System.out.printf("%d : 0\n", list[0]);
            }
        }
    }

    // la methode prend en argument la taille de la matrice qui est lue en entrée
    public static int[][] getmatrix(int n){
        // on crée des variables locals
        Scanner scan = new Scanner(system.in); // un scanner pour recuperer les valeurs de la matrice
        int[][] mat = new int [n+1][n+1]; 
        
        //System.out.println("Entrez tous les elemenets ligne par ligne :");
        // on ecrit dans les casses du tableau de l'indice 1 a n, dans les deux dimensions  
        for(int x = 1 ; x <= n ; x++){
            for(int y = 1 ; y <= n ; y++){
                mat[x][y] = scan.nextInt();
            }
        }

        return mat;
    }

    public static int[] computeAdjacentyList (int x, int[][] matrix){
        // declaration des valiable local 
        int len = graph.length; // on recupère la taille de la matrcice
        int[] line = getLine(x, matrix);
        int [] ret;

        // variables pour compteur les adjacences de la ligne
        int compteur = 0;
        int [] tab = new int[len];
        tab[0] = x;
        for(int j=1; j<= len ; j++){
            if(line[j] != 0){
                tab[compteur] = j;
                compteur += 1;
            }
        }
        
        // le compteur est égale au nombre d'élément de la ligne
        // ajoute 2 case pour le numero de ligne qui est dans la case 0  
        ret = new int[compteur+1];

        for(int i=0; i<(compteur+1); i++){
            ret[i] = tab[i];
        }

        return ret; 
    }


    public static void exo1TP2(){
        // on recupère la description lue
        int len = lireEntier();

        // lecture du graphique de taille len
        int[][] graph = getmatrix(len);

        // on recupère l'entier n pour calculer la liste d'adjacence
        int n = lireEntier();

        // on verifie qu'il soit conforme
        if((n<= len) && (n>0)){
            int[] listn = computeAdjacentyList(n, graph);

            // on affiche la liste d'adjacence
            afficherlistAdj(listn);
        }
        else{
            System.err.println("l'entier entree est incorect !");
        }
    }











    public static void getGraph(int[][] graph){
        int len = graph.length;
        int compteur = 0;
        while(compteur != len){
            int line = scan.nextInt();
            int next; 
            int retlen = 0;
            int [] tab = new int[len];
            do{
                next = scan.nextInt();
                if(next != 0){
                    tab[retlen]= next;
                    retlen += 1;
                }
                else 
                    break;
            }while(true);

            int[] retline = new int[compteur];

            for(int i = 0; i < compteur; i++){
                retline[i] = tab[i];
            }

            graph[line] = retline;
        }
    }

    

    public static int[][] getlists(int[][] matrice){
        int len = matrice.length; 
        int [][] ret = new int[len+1][];

        for(int line=1; line <= len ; line++){
            boolean empty = true;
            int compteur = 0;
            int [] tab = new int[len];
            for(int j=1; j<= len ; j++){
                if(matrice[line][j] != 0){
                    if(empty){
                        tab[compteur] = line;
                        compteur += 1;
                    }
                    empty = false;
                    tab[compteur] = j;
                    compteur += 1;
                }
            }
            
            int[] current_line = new int[compteur];

            for(int i=0; i<compteur; i++){
                current_line[i] = tab[i];
            }

            ret[line] = current_line;
        }

        return ret; 
    }

    private void printNbr( int current){
        System.out.printf(" %3d", current);
    }

    public static void printgraph(int[][] adj){
        for(int line=1; line < adj.length; line ++){
            for(int i = 0 ; i< adj[line].length ; i++){
                if(i==0)
                    System.out.print( adj[line][i]+ " : ");
                else
                    System.out.fprint("%1d", adj[line][i]);
            }

            System.out.fprint("%1d\n", 0);
        }
    }

    // prend en para une matrice d'adjacence 
    public static void printmatrix(int[][] graph){
        for(int x = 1; x < graph.length ; x++){
            for(int y = 1 ; y < graph.length; y++){
                System.out.printf("%3d", graph[x][j]);
            }
            System.out.println();
        }
    }
    

   

}