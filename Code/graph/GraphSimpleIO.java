
package graph;

import java.util.Scanner;

public final class GraphSimpleIO{
    // attribut(s)
    private static Scanner scan;


    // Methodes auxiliaires

    // on lui donne un matrcie et un numero de ligne et on recupère la ligne corresponendente au numero
    public static int[] getLine(int x, int[][] matrice){
        return matrice[x-1];
    }

    //Fonction qui renvoi la ligne de la matrice par rapport à un sommet x
    public static int[] getMatrixLine(int x, int[][] matrix)
    {
        int index = 0;
        for(int i = 1; i < matrix.length; i++)
        {
            if(x == matrix[i][0])
            {
                index = i;
                break;
            }
        }
        
        return matrix[index]; 
    }

    // TP2 Exercice 1

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
            if(list.length <= 1){
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

    //Fonction pour calculer une liste d'adjacence à partir d'une ligne de la matrice d'adjacence
    public static int[] computeAdjacentyList(int x, int[][] matrix)/*AKA getAdjacencyListFromMatrix*/{
        // declaration des valiable local 
        int len = matrix.length; // on recupère la taille de la matrcice
        int[] line = getLine(x, matrix);
        int [] ret;

        // variables pour compteur les adjacences de la ligne
        int compteur = 1;
        int [] tab = new int[len];
        tab[0] = x;
        for(int j=1; j< len ; j++){
            if(line[j] != 0){
                tab[compteur] = j;
                compteur += 1;
            }
        }
        
        //On cree un tableau de la bonne taille
        // le compteur est égale au nombre d'élément de la ligne
        // ajoute 2 case pour le numero de ligne qui est dans la case 0  
        ret = new int[compteur+1];

        for(int i=0; i<(compteur+1); i++){
            ret[i] = tab[i];
        }

        return ret; 
    }

    //Fonction pour calculer une ligne de la matrice d'adjacence à partir d'une liste d'adjacence 
    public static int[] computeAdjacencyMatrix(int x, int[][] matrix) /*AKA getMatrixFromAdjacencyList*/
    {
        
        int len = matrix.length; 
        int[] line = getMatrixLine(x, matrix);
        int [] ret = new int[matrix.length];

        //initialiser la ligne de la matrice 
        ret[0] = x;
        for(int i = 1; i < len; i++)
        {
            ret[i] = 0;        
        }
        
        //On parcour la liste d'adjacence du sommet x pour trouver les sommets adjacents à celui ci
        for(int j=1; j<= len ; j++){
            if(line[j] != 0)
            {
                //On met à 1 les sommets adjacents à notre sommet x 
                ret[line[j]] = 1;
            }
        }
        return ret; 
    }


    public static void exo1TP2(){
        // on recupère la description lue
        int len = getInt();

        // lecture du graphique de taille len
        int[][] graph = getmatrix(len);

        // on recupère l'entier n pour calculer la liste d'adjacence
        int n = getInt();

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

    // TP2 Exercice 2
    // a) 
    public static void initialize(){
        scan = new Scanner(System.in);
    }

    // b)
    // la methode get matrix a ete changer au dessus

    // c)

    public static int[][] getgraph(int[][] graph){
        // variable(s) local 
        int len = graph.length;
        int compteur;
        int[] tab = new int[len];
        int current;

        // len-1 tours de boucle
        for(int i=1 ; i< len ; i++){
            compteur =  0;
            // variavble de la boucle
            current = scan.nextInt();

            // si l'utisateur a terminer de saisir les lists
            if(current == 0){
                break;
            }
            else{
                compteur = 1;
                tab[0] = current;

                // saisie de la liste d'adjacence
                do{
                    // scanner
                    current = scan.nextInt();

                    // verrification
                    if(current == 0){
                        break;
                    }
                    else{
                        tab[compteur] = current;
                        compteur += 1;
                    }
                }while(true);

                // copie dans une liste de la bonne taille
                int[] finalTab = new int[compteur];

                for(int j=0 ; j<compteur ; j++){
                    finalTab[j] = tab[j];
                }

                // on ajoute la liste d'adjacence dans la variable graph
                graph[finalTab[0]] = finalTab;
            }
        }
        return graph;
    }

    // d)
    // prend en parametre une matrice d'adjacence 
    public static void printMatrix(int[][] graph){
        for(int x = 1; x < graph.length ; x++){
            for(int y = 1 ; y < graph.length; y++){
                System.out.printf("%2d", graph[x][y]);
            }
            System.out.println();
        }
    }

    // e)
    public static void printGraph(int[][] graph){
        // afficher ligne pare ligne 
        for(int i=1 ; i<graph.length; i++){
            afficherlistAdj(graph[i]);
            System.out.println();
        }
    }

    // f) 
    public static void rawPrintGraph(int[][] graph){
        for(int i=1 ; i<graph.length; i++){
            for(int value : graph[i]){
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }
    }

    // g)
    // methode qui renvoie l'entier ecrit sur le flot de lecture
    public static int getInt(){
        return scan.nextInt();
    }


    // h)
    // il y a deja un constructeur identique par defaut en java 
    // il faut declarer um constructeur prive pour pas que l'utilisateur en cree
    private GraphSimpleIO(){}

}
