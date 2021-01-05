
package Code;

public class GraphSimple{
    // TP2
    // exercice 3

    // a)
    // cet attribut est le tableau de liste d'adjacence 
    private int[][] AdjacencyMatrix;
    private int[][] AdjacencyListTable; //Il faut l'initialiser

    public GraphSimple(int n)
    {
        this.AdjacencyListTable = new int[n+1][1]; //N sommets et 0 aretes (new int[n+1][])
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

    /*//Fonction qui renvoi la ligne de la matrice par rapport à un sommet x
    public static int[] getMatrixLine(int x, int[][] matrix)
    {
        int index = 0;
        for(int i = 1; i < matrix.length; i++)
        {
            if(x == matrix[i][0])
            {
                index = i;
                break;
            }
        }
        
        return matrix[index]; 
    }*/

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

    /*//Fonction pour calculer une liste d'adjacence à partir d'une ligne de la matrice d'adjacence
    public static int[] getAdjacencyListFromMatrix (int x, int[][] matrix)
    {
        
        int len = matrix.length-1; 
        int[] line = getMatrixLine(x, matrix);
        int [] ret;

        // variables pour compteur les adjacences de la ligne
        int compteur = 0;
        int [] tab = new int[len];
        tab[0] = x;
        for(int j=1; j<= len ; j++){
            if(line[j] == 1)
            {
                tab[compteur] = i;
                compteur ++;
            }
        }
        
        //On cree un tableau de la bonne taille
        // le compteur est égale au nombre d'élément de la ligne
        // ajoute 2 case pour le numero de ligne qui est dans la case 0  
        ret = new int[compteur+1];

        for(int i=0; i<(compteur+1); i++){
            ret[i] = tab[i];
        }

        return ret; 
    }

    //Fonction pour calculer une ligne de la matrice d'adjacence à partir d'une liste d'adjacence 
    public static int[] getMatrixFromAdjacencyList(int x, int[][] matrix)
    {
        
        int len = matrix.length-1; 
        int[] line = getMatrixLine(x, matrix);
        int [] ret = new int[n+1];

        //initialiser la ligne de la matrice 
        ret[0] = x;
        for(int i = 1; i < len; i++)
        {
            ret[i] = 0;        
        }
        
        //On parcour la liste d'adjacence du sommet x pour trouver les sommets adjacents à celui ci
        for(int j=1; j<= len ; j++){
            if(line[j] != 0)
            {
                //On met à 1 les sommets adjacents à notre sommet x 
                ret[line[j]] = 1;
            }
        }
        return ret; 
    }*/

    public boolean isAdjacencyListTableEmpty(int[][] adjacencyListTable)
    {
        boolean ret = false;
        for(int i = 0; i < this.AdjacencyListTable.length; i++)
        {
            if(this.AdjacencyListTable[i].length <= 1)
            {
                ret = true;
            }
        } 
        return ret;
    }

    //Pour stocker la matrice d'adjacence voulue
    public void setAdjacencyMatrix(int[][] matrix)
    {
        this.AdjacencyMatrix = matrix;
        
        //Si le tableau de listes d'adjacence est vide, alors :
        if(isAdjacencyListTableEmpty(this.AdjacencyListTable))
        {
            //Determination du tableau de listes d'adjacence à partir de la matrice d'adjacence
            for(int i = 1; i < this.AdjacencyMatrix.length; i++)
            {
                this.AdjacencyListTable[i] = getAdjacencyListFromMatrix(this.AdjacencyListTable[i][0], this.AdjacencyMatrix);
            }
        }
    }

    //On retourne la matrice d'adjacence de notre graphe
    public int[][] getAdjacencyListMatrix()
    {
        //Si la matrice d'adjacence est vide, alors:
        this.AdjacencyMatrix = new int[n+1][n+1];
        //Determination de la matrice d'adjacence à partir du tableau de listes d'adjacence
        for(int i = 1; i < this.AdjacencyListTable.length; i++)
        {
            this.AdjacencyMatrix[i] = getMatrixFromAdjacencyList(this.AdjacencyListTable[i][0], this.AdjacencyListTable);
        }
        return this.AdjacencyMatrix;
    }

    //Fonction main pour initialiser le tableau et executer le programme
    //Initialiser tableau listes adjacences à partir de n entrée par l'utilisateur
}