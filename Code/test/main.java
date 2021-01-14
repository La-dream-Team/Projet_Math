package test;

import java.util.Scanner;
import graph.GraphSimple;
import graph.GraphSimpleIO;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int scanInt;

        System.out.println("Sous quel format voulez vous entrer votre graphe ? \n1. matrice d’adjacence \n2. tableau de liste d’adjacence \nEntrez 1 ou 2 sinon 0 pour quitter.");

        // on lit le flot d'entré
        scanInt = scan.nextInt();

        // si l'entier est égale à 0 on quitte
        if(scanInt != 0)
        {
            // si l'utilisateur veut continuer
            int len;

            // il faut initialiser la classe GraphSimpleIO()
            GraphSimpleIO func = new GraphSimpleIO();
            initialize();

            // on recupère la taille de la matrice
            len = GraphSimpleIO.getInt();

            GraphSimple currentGraph = new GraphSimple(len);

            if(scanInt == 1)
            {
                // l'utilisateur entre un matrice d'adjacence
                // on lit la matrice d'ajcancen
                int[][] matrix = GraphSimpleIO.getmatrix(len);

                // j'affecte la matrice
                currentGraph.setAdjacencyMatrix(matrix);

                // convertion en tableau de liste d'adjacence
                currentGraph.fromMatrix();
            }
            else
            {
                // l'utilisateur entre un matrice d'adjacence
            }
  
        }

    }
}
