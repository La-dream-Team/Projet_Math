
package Code;

import java.util.Scanner;

public final class GrapheSimpleIO{

    public static Scanner scan = new Scanner(System.in);

    public static int[][] getmatrix(int len){

        int[][] mat = new int [len+1][len+1];
        
        //System.out.println("Entrez tous les éléménet ligne par ligne :");
        for(int x = 1 ; x <= len ; x++){
            for(int y = 1 ; y <= len ; y++){
                mat[x][y] = scan.nextInt();
            }
        }

        return mat;
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

    public int[] getLine(int x){
        return this.matrice[x-1];
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