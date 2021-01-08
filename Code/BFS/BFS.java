package BFS;

public class BFS{

    //Attributs
    private color[] color;
    private int[] distance;
    private int[] parent;
    
    //Constructor

    public BFS (int n)
    {
        this.color = new color[n+1];
        this.distance = new int[n+1];
        this.parent = new int[n+1];
    }

    // getter / setter
    
    // couleurs 
    private color getColor(int x)
    {
        return this.color[x];
    }

    private void setColor(int x, color c)
    {
        this.color[x] = c;
    }

    // distance
    private int getDistance(int x)
    {
        return this.distance[x];
    }

    private void setDistance(int x, int dist)
    {
        this.distance[x] = dist;
    }

    // parent
    private int getparent(int x)
    {
        return this.parent[x];
    }

    private void setParent(int x, int par)
    {
        this.parent[x] = par;
    }

    // Methods

    // Methode pour initialiser le tableau de couleurs
    public void initializeColors()
    {
        for(i = 1; i < this.color.length; i++)
        {
            this.setColor(i, color.GREEN);
        }
    }

    // Methode pour generer un sommet d'origin aleatoire
    public int randomVertex(int n)
    {
        int r = (int)((Math.random()*n) + 1);
        return r;
    }
    

    //Methode pour executer l'algorithme de parcours en largeur
    public void algorithm(int n)
    {
        initializeColors();
        int r = randomVertex(n);
    }
}