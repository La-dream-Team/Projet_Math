package BFS;

public class BFS{
    // Exercice 1

    // b.

    // Attributs
    private color[] color;
    private int[] distance;
    private int[] parent;
    
    // Constructor

    public BFS (int n)
    {
        this.color = new color[n+1];
        this.distance = new int[n+1];
        this.parent = new int[n+1];
    }

    // Getters && Setters
    
    // Color
    private color getColor(int x)
    {
        return this.color[x];
    }

    private void setColor(int x, color c)
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

    // Methods

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
        for(int i = 1; i < this.color.length; i++)
        {
            this.setColor(i, color.GREEN);
        }
    }

    // d.

    // Methode pour executer l'algorithme de parcours en largeur
    // int r = randomVertex(n); r est le sommet d'origine du parcour
    //initializeColors();
    public void algorithmForConnectedGraph(int r)
    {
        QueueBounded<Integer> F = new QueueBounded<Integer>(graph.order());
        F.add(r);
        this.setDistance(r, 0);
        this.setColor(r, color.ORANGE);
        this.setParent(r, 0);
        while(!F.isEmpty())
        {
            int origin = F.extract();
            for(int i : graph.getAdjacencyList(origin))
            {
                if(this.getColor(i) == color.GREEN)
                {
                    this.setDistance(i, this.getDistance(origin)+1);
                    this.setColor(i, color.ORANGE);
                    this.setParent(i, origin);
                    F.add(i);
                }
            }
            this.setColor(origin, color.RED);
        }
    }

    // g.

    // Methode pour executer l'algorithme de parcours en largeur pour un graphe non connexe
    //initializeColors();
    public void algorithmForUnconnectedGraph()
    {
        for(int i = 1; i < graph.order()+1; i++)
        {
            if(this.getColor(i) == color.GREEN)
            {
                algorithmForConnectedGraph(i);
            }
        }
    }


    // Exercice 2

    //Methode à executer après l'algorithme de parcours en longueur pour tester si un graph est connexe ou pas
    public boolean isConnectedGraph()
    {
        boolean ret = true;
        for(int i = 1; i < graph.order()+1; i++)
        {
            if(this.getColor(i) != color.RED)
            {
                ret = false;
            }
        }
        return ret;
    }

    
    // Exercice 3

    //Si le graphe est connexe
    public void RC1(int r, int[]cc)
    {
        QueueBounded<Integer> F = new QueueBounded<Integer>(graph.order());
        F.add(r);
        this.setDistance(r, 0);
        this.setColor(r, color.ORANGE);
        this.setParent(r, 0);
        cc[r] = r;
        while(!F.isEmpty())
        {
            int origin = F.extract();
            for(int i : graph.getAdjacencyList(origin))
            {
                if(this.getColor(i) == color.GREEN)
                {
                    this.setDistance(i, this.getDistance(origin)+1);
                    this.setColor(i, color.ORANGE);
                    this.setParent(i, origin);
                    cc[i] = r;
                    F.add(i);
                }
            }
            this.setColor(origin, color.RED);
        }
    }

    //Si le graphe n'est pas connexe
    public void RC2(int[] cc)
    {
        for(int i = 1; i < graph.order()+1; i++)
        {
            if(this.getColor(i) == color.GREEN)
            {
                RC1(i, cc);
            }
        }
    }
    
    //Methode pour calculer les composantes connexes d'un graphe 
    public void relatedComponents()
    {
        int[] cc = new int[graph.order()+1];
        RC2(cc);
        System.out.print("cc(x) :");
        for(int i = 1; i < graph.order()+1; i++)
        {
            System.out.print("");
            System.out.print(cc[i]);
            System.out.print("");
        }
    }
    
}