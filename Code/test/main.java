package test;

import java.util.Scanner;
import graph.GraphSimple;
import graph.GraphSimpleIO;
import BFS.BFS;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int scanInt;

        // si l'utilisateur veut continuer
        int len;

        // il faut initialiser la classe GraphSimpleIO()
        GraphSimpleIO.initialize();

        System.out.println("Entrez l'ordre du graph ");

        // on recupère la taille de la matrice
        len = GraphSimpleIO.getInt();

        GraphSimple currentGraph = new GraphSimple(len);

        System.out.println("Entrez la liste d'adjacence pour chaque sommet de votre graphe. \nVeuillez terminer chaque liste par 0 et taper 0 pour arreter la saisie.");
        // l'utilisateur entre un tableau de liste d'adjacence
        currentGraph.scanAdjavencyList();
        
        System.out.println("\nVoici les listes d'adjacences que vous qvez saisi");
        GraphSimpleIO.printGraph(currentGraph.getTabAdjacencyList());

        // on cree et initialise la recherche
        BFS currentBFS = new BFS(currentGraph.order());
        currentBFS.initializeColors();
        // on regarde si le graph est connexe
        System.out.println("On cherhe a savoir si le graphe donée est connexe.");
        if(currentBFS.isConnectedGraph(currentGraph))
            System.out.println("Le graphe est connexe !");
        else
        {
            System.out.println("Le graphe n'est pas connexe !");
            System.out.println("On regarde combien il y a de composantes connexes :");
            //on regarde combien il y a de composantes connexes
            currentBFS.relatedComponents(currentGraph);
        }

    }
}
