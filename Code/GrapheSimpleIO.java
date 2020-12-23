
package Code;

import java.util.Scanner;

public final class GrapheSimpleIO{
    // methodes auxiliaires

    // on lui donne un matrcie et un numero de ligne et on recupère la ligne corresponendente au numero
    public static int[] getLine(int x, int[][] matrice){
        return matrice[x-1];
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
        // ajoute 2 case pour le numero de ligne qui est dans la case 0 et le 0 dans la dernière case 
        ret = new int[compteur+2];

        for(int i=0; i<(compteur+1); i++){
            ret[i] = tab[i];
        }
        // fin de ligne
        ret[compteur+1] = 0;

        return ret; 
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