
package Code;

public class GraphSimple{
    // TP2
    // exercice 3

    // a)
    // cet attribut est le tableau de liste d'adjacence 
    private int[][] graph;


    // c)
    
    // nous avons décidé de laisser la case 0 du tableau de liste d'adjacence vide 
    // l'ordre correspond donc à la taille du tableau - 1
    public int order(){
        return (this.graph.length -1);
    }

    // la methode degre renvoie le degre du sommet x de l'objet courrant
    // la case 0 contient x la suite du tableau contient les numeros de colonnes different de 0 
    public int degre(int x){
        return (this.graph[x].length -1);
    }

    // 
    public boolean isVertex(int x){


        return true;
    }

}