package graph;

public class GraphSimple{
    // TP2
    // exercice 3

    // a)
    // cet attribut est le tableau de liste d'adjacence 
    private int[][] AdjacencyMatrix;
    private int[][] AdjacencyListTable; //Il faut l'initialiser

    public GraphSimple(int n)
    {
        this.AdjacencyMatrix = new int[n+1][n+1];
        this.AdjacencyListTable = new int[n+1][1]; //N sommets et 0 aretes (new int[n+1][])
        
        this.initialize();
    }

    // inisialisation de la table de liste d'adjcence 
    public void initialize()
    {
        int len = this.AdjacencyListTable.length;

        for(int i=1; i < len ; i++)
        {
            this.AdjacencyListTable[i][0] = i;
        }
    }

    // b)

    //Pour ajouter la liste d'adjacence d'un sommet du graphe au tableau de listes d'adjacence
    public void setAdjacencyList(int x, int[] neighborhood)
    {
        if(isVertex(x) && neighborhood.length != 0)
        {
            //On cherche le sommet dans notre tableau pre-initialise
            for(int i = 1; i < this.AdjacencyListTable.length; i++)
            {
                if(x == this.AdjacencyMatrix[i][0])
                {
                    //On realloue la taille de la liste d'adjacence pour le sommet x et on copie les elements
                    int[] newArray = new int[neighborhood.length+1];
                    System.arraycopy(neighborhood, 0, newArray, 1, neighborhood.length);
                    System.arraycopy(AdjacencyListTable[i], 0, newArray, 0, AdjacencyListTable[i].length /*Ou 1*/);
                    //On affecte le la liste d'adjacence a notre tableau
                    this.AdjacencyListTable[i] = newArray;
                }
            }
        }
    }

    //Fonction qui renvoi la liste d'adjacence d'un sommet x
    public int[] getAdjacencyList(int x)
    {
        int index = 0;
        if(isVertex(x))
        {
            for(int i = 1; i < this.AdjacencyListTable.length+1; i++)
            {
                if(x == this.AdjacencyListTable[i][0])
                {
                    index = i;
                    break;
                }
            }
        }
        return this.AdjacencyListTable[index];
    }

    // c)
    
    // nous avons décidé de laisser la case 0 du tableau de liste d'adjacence vide 
    // l'ordre correspond donc à la taille du tableau - 1
    public int order(){
        return (this.AdjacencyMatrix.length -1);
    }

    //Fonction pour verifier qu'un entier x est bien un sommet du graphe
    public boolean isVertex(int x){
        boolean ret = false;
        for(int i = 1; i < this.AdjacencyMatrix.length; i++)
        {
            if(x == this.AdjacencyMatrix[i][0])
            {
                ret = true;
                break;
            }
        }
        return ret; 
    }

    //Fonction pour verifier que les sommets x et y sont les extremites d'une arete
    public boolean isEdge(int x, int y){
        boolean ret = false;
        //Si les deux entiers sont des sommets du graphe
        if(isVertex(x) && isVertex(y))
        {
            //On cherche le sommet x
            for(int i = 1; i < AdjacencyListTable.length; i++)
            {
                if(this.AdjacencyListTable[i][0] == x)
                {
                    //On verifie que le sommet y est dans la liste d'adjacence du sommet x
                    for(int j = 1; j < AdjacencyListTable[i].length; j++)
                    {
                        if(this.AdjacencyListTable[i][j] == y)
                        {
                            ret =  true;
                        }
                    }
                }
            }
        }
        return ret;
    }

    // la methode degree renvoie le degre du sommet x de l'objet courrant
    // la case 0 contient x la suite du tableau contient les numeros de colonnes different de 0 
    public int degree(int x){
        return (this.AdjacencyListTable[x].length /*length-1*/);
    }

    //c)

    public void toMatrix ()
    {
        //Determination de la matrice d'adjacence à partir du tableau de listes d'adjacence
        for(int i = 1; i < this.AdjacencyListTable.length; i++)
        {
            this.AdjacencyMatrix[i] = GraphSimpleIO.computeAdjacencyMatrix(this.AdjacencyListTable[i][0], this.AdjacencyListTable);
        }
    }

    public void fromMatrix ()
    {
        //Determination du tableau de listes d'adjacence à partir de la matrice d'adjacence
        for(int i = 1; i < this.AdjacencyMatrix.length; i++)
        {
            this.AdjacencyListTable[i] = GraphSimpleIO.computeAdjacentyList(this.AdjacencyListTable[i][0], this.AdjacencyMatrix);
        }
    }

    // fonction qui lit le tableau de liste d'adjacence sur le flot d'entrée
    public void scanAdjavencyList()
    {
        // on verifie que le tableau de la liste d'adjacence est bien vide et initialisé
        if(this.isAdjacencyListTableEmpty(this.AdjacencyListTable))
        { 
            this.AdjacencyListTable = GraphSimpleIO.getgraph(this.AdjacencyListTable);
        }
    }
    
    //Complément de sujet 1
    //Fonction pour savoir si un tableau de listes d'adjacence n'est pas rempli
    public boolean isAdjacencyListTableEmpty(int[][] adjacencyListTable)
    {
        boolean ret = false;
        for(int i = 0; i < adjacencyListTable.length; i++)
        {
            if(adjacencyListTable[i].length <= 1)
            {
                ret = true;
            }
        } 
        return ret;
    }

    //Fonction pour savoir si une matrice d'adjacence n'est pas rempli
    public boolean isAdjacencyMatrixEmpty(int[][] adjacencyMatrix)
    {
        boolean ret = true;
        for(int i = 1; i < adjacencyMatrix.length; i++)
        {
            for(int j = 1; j < adjacencyMatrix.length; j++)
            {
                if(adjacencyMatrix[i][j] != 0 || adjacencyMatrix[i][j] != 1 )
                {
                    ret = false;
                }
            }
        } 
        return ret;
    }

    //Pour stocker la matrice d'adjacence voulue
    public void setAdjacencyMatrix(int[][] matrix)
    {
        this.AdjacencyMatrix = matrix;
        
        //Si le tableau de listes d'adjacence est vide, alors :
        if(!isAdjacencyListTableEmpty(this.AdjacencyListTable))
        {
            //Determination du tableau de listes d'adjacence à partir de la matrice d'adjacence
            fromMatrix();
        }
    }

    //On retourne la matrice d'adjacence de notre graphe
    public int[][] getAdjacencyMatrix()
    { 
        if(!isAdjacencyListTableEmpty(this.AdjacencyListTable) && isAdjacencyMatrixEmpty(this.AdjacencyMatrix))
        {
            //Determination de la matrice d'adjacence à partir du tableau de listes d'adjacence
            this.toMatrix();
        }
        //Si le tableau de listes d'adjacence et la matrice d'adjacence sont vide alors erreur
        else if(isAdjacencyListTableEmpty(this.AdjacencyListTable) && isAdjacencyMatrixEmpty(this.AdjacencyMatrix))
        {
            System.err.println("Tableau de listes d'adjacence et Matrice d'adjacence non initialisées\n");
        }
        //Renvoi la matrice d'adjacence
        return this.AdjacencyMatrix;
    }


    //On retourne le tableau de liste d'adjacence
    public int[][] getAdjacencyList()
    { 
        //Renvoi la matrice d'adjacence
        return this.AdjacencyListTable;
    }


    //Fonction main pour initialiser le tableau et executer le programme
    //Initialiser tableau listes adjacences à partir de n entrée par l'utilisateur
}