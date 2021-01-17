package BFS;

import graph.GraphSimple;

public class BFS{
    // Exercice 1

    // b.

    // Attributs
    private Color[] color;
    private int[] distance;
    private int[] parent;
    
    // Constructor

    public BFS (int n)
    {
        this.color = new Color[n+1];
        this.distance = new int[n+1];
        this.parent = new int[n+1];
    }

    // Methods

    // Getters && Setters
    
    // Color
    private Color getColor(int x)
    {
        return this.color[x];
    }

    private void setColor(int x, Color c)
    {
        this.color[x] = c;
    }

    // Distance
    private int getDistance(int x)
    {
        return this.distance[x];
    }

    private void setDistance(int x, int dist)
    {
        this.distance[x] = dist;
    }

    // Parent
    private int getparent(int x)
    {
        return this.parent[x];
    }

    private void setParent(int x, int par)
    {
        this.parent[x] = par;
    }

    // Methode pour generer un sommet d'origin aleatoire
    public int randomVertex(int n)
    {
        int r = (int)((Math.random()*n) + 1);
        return r;
    }

    // c.

    // Methode pour initialiser le tableau de couleurs
    // Avant de commencer l'algorithme il faut appeler ce methode
    public void initializeColors()
    {
        //Pour tous les sommets du graphe on fait :
        for(int i = 1; i < this.color.length /*graph.order()+1*/; i++)
        {
            //On met la couleur du sommet à vert
            this.setColor(i, Color.GREEN);
        }
    }

    // d.

    // Methode pour executer l'algorithme de parcours en largeur
    // int r = randomVertex(n); r est le sommet d'origine du parcour
    //initializeColors();
    public void algorithmForConnectedGraphV1(int r, GraphSimple graph)
    {
        //On crée une file d'attente de taille maximale n
        QueueBounded<Integer> F = new QueueBounded<Integer>(graph.order());
        //On ajoute dans la file le sommet d'origine du parcours
        F.add(r);
        this.setDistance(r, 0);
        this.setColor(r, Color.ORANGE);
        this.setParent(r, 0);
        //Pendant que la file d'attente n'est pas vide
        while(!F.isEmpty())
        {
            //On extrait le sommet de la file d'attente
            int origin = F.extract();
            //Pour tous les sommets adjacents au sommet qu'on vient d'extraire de la file d'attente on fait :
            for(int i : graph.getAdjacencyList(origin))
            {
                //Si sa couleur est vert
                if(this.getColor(i) == Color.GREEN)
                {
                    //On l'ajoute dans la file d'attente
                    this.setDistance(i, this.getDistance(origin)+1); //Distance à l'origine = distance du sommet adjacent + 1
                    this.setColor(i, Color.ORANGE);
                    this.setParent(i, origin);
                    F.add(i);
                }
            }
            //On met en rouge le sommet qu'on a extrait de la file d'attente
            this.setColor(origin, Color.RED);
        }
    }

    // g.

    // Methode pour executer l'algorithme de parcours en largeur pour un graphe non connexe
    //initializeColors();
    public void algorithmForUnconnectedGraphV1(GraphSimple graph)
    {
        //Pour tous les sommets du graphe on fait :
        for(int i = 1; i < graph.order()+1; i++)
        {
            //Si la couleur du sommet est vert alors
            if(this.getColor(i) == Color.GREEN)
            {
                //On execute l'algortihme de parcours en largeur en utilisant le sommet i comme sommet d'origine
                this.algorithmForConnectedGraphV1(i, graph);
            }
        }
    }


    // Exercice 2

    //Methode à executer après l'algorithme de parcours en longueur pour tester si un graph est connexe ou pas
    public boolean isConnectedGraph(GraphSimple graph)
    {
        boolean ret = true;
        //Pour tout sommet appartenant au graphe on fait :
        for(int i = 1; i < graph.order()+1; i++)
        {
            //Si la couleur du sommet n'est pas rouge
            if(this.getColor(i) != Color.RED)
            {
                //Cela signifie que le graphe n'est pas connexe
                ret = false;
            }
        }
        return ret;
    }

    
    // Exercice 3

    //Si le graphe est connexe on sait qu'il n'y a qu'une composante connexe
    public void algorithmForConnectedGraphV2(int r, GraphSimple graph, int[]cc)
    {
        //On crée une file d'attente de taille maximale n
        QueueBounded<Integer> F = new QueueBounded<Integer>(graph.order());
        //On ajoute dans la file le sommet d'origine du parcours
        F.add(r);
        this.setDistance(r, 0);
        this.setColor(r, Color.ORANGE);
        this.setParent(r, 0);
        cc[r] = r; //Le sommet racine du composante connexe est le sommet d'origine
        //Pendant que la file d'attente n'est pas vide
        while(!F.isEmpty())
        {
            //On extrait le sommet de la file d'attente
            int origin = F.extract();
            //Pour tous les sommets adjacents au sommet qu'on vient d'extraire de la file d'attente on fait :
            for(int i : graph.getAdjacencyList(origin))
            {
                //Si sa couleur est vert
                if(this.getColor(i) == Color.GREEN)
                {
                    //On l'ajoute dans la file d'attente
                    this.setDistance(i, this.getDistance(origin)+1); //Distance à l'origine = distance du sommet adjacent + 1
                    this.setColor(i, Color.ORANGE);
                    this.setParent(i, origin);
                    cc[i] = r; //Le sommet racine du composante connexe est le sommet d'origine
                    F.add(i);
                }
            }
            //On met en rouge le sommet qu'on a extrait de la file d'attente
            this.setColor(origin, Color.RED);
        }
    }

    //Si le graphe n'est pas connexe et on veut trouver ses composantes connexes
    public void algorithmForUnconnectedGraphV2(GraphSimple graph, int[] cc)
    {
        //Pour tous les sommets du graphe on fait :
        for(int i = 1; i < graph.order()+1; i++)
        {
            //Si la couleur du sommet est vert alors
            if(this.getColor(i) == Color.GREEN)
            {
                //On execute l'algortihme de parcours en largeur en utilisant le sommet i comme sommet d'origine
                this.algorithmForConnectedGraphV2(i, graph, cc);
            }
        }
    }
    
    //Methode pour calculer les composantes connexes d'un graphe 
    public void relatedComponents(GraphSimple graph)
    {
        //On crée le tableau de composantes connexes
        int[] cc = new int[graph.order()+1];
        //On execute l'algorithme de parcours en largeur pour trouver les composantes connexes du graphe
        this.algorithmForUnconnectedGraphV2(graph, cc);
        //On affiche le tableau de composantes connexes
        System.out.print("cc(x) :");
        for(int i = 1; i < graph.order()+1; i++)
        {
            System.out.print("");
            System.out.print(cc[i]);
            System.out.print("");
        }
    }
    
}
