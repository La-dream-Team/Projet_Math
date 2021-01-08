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

    //Methods

    //Methode pour initialiser le tableau de couleurs
    public void initializeColors()
    {
        for(i = 1; i < this.color.length; i++)
        {
            this.color[i] = color.GREEN;
        }
    }

    //Methode pour executer l'algorithme de parcours en largeur
    public void algorithm()
    {
        initializeColors();
    }
}