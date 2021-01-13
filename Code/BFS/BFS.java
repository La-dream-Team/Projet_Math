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
        for(i = 1; i < this.color.length; i++)
        {
            this.setColor(i, color.GREEN);
        }
    }

    // d.

    // Methode pour executer l'algorithme de parcours en largeur
    // int r = randomVertex(n); r est le sommet d'origine du parcour
    public void algorithmForConnectedGraph(int n, int r)
    {
        QueueBounded<Integer> F = new QueueBounded<Integer>(n);
        //initializeColors();
        F.add(r);
        setDistance(r, 0);
        setColor(r, color.ORANGE);
        setParent(r, 0);
        while(!F.isEmpty())
        {
            int origin = F.extract();
            for(int i : graph.getAdjacencyList(origin))
            {
                if(getColor(i) == color.GREEN)
                {
                    setDistance(i, getDistance(origin)+1);
                    setColor(i, color.ORANGE);
                    setParent(i, origin);
                    F.add(i);
                }
            }
            setColor(origin, color.RED);
        }
    }

    // g.

    // Methode pour executer l'algorithme de parcours en largeur pour un graphe non connexe
    public void algorithmForUnconnectedGraph(int n)
    {
        for(int i = 1; i < graph.order(); i++)
        {
            if(getColor(i) == color.GREEN)
            {
                algorithmForConnectedGraph(n, i);
            }
        }
    }

    // Exercice 2

    public boolean isConnectedGraph()
    {
        boolean ret = true;
        for(int i = 1; i < graph.order(); i++)
        {
            if(getColor(i) != color.RED)
            {
                ret = false;
            }
        }
        return ret;
    }

    // Exercice 3

    /*
    public  relatedComponents(int n)
    {
        int[] cc = new int[n+1];
    }
    */
}