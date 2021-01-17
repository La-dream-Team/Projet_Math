exemple 
1 0 0
0 1 0
0 0 1

Matrice d'adjacence :
Elle est representé par un tableau de tableau de taille 4x4.

0 0 0 0 
0 1 0 0
0 0 1 0
0 0 0 1

Liste d'adjacence :
La première dimenssion est de 4 mais la seconde est de taille variable
......
1 1
2 2
2 3


--------------------------------------------------------------------------------------------------------------------------------------

Fait par RUCHER Thibault et RODRIGUEZ Daniel

Structure du projet 

IMPORTANT : Nous avons structuré le projet et rangé le code dans le même ordre utilisé dans les sujets.

Dossier BFS (ou Breadth-first search) :
 Partie dedié à l'algorithme de parcours en largeur d'un graphe. Dedans ce dossier on trouve 3 fichiers :
  - Le fichier BFS, où on trouve l'algorithme de parcours en largeur et ses variations.
  - Le fichier color, où on trouve le type énuméré "color" dont nous avons besoin dans le fichier BFS.
  - Le fichier QueueBounded (Récupéré depuis UPdago), où on trouve le structure QueueBounded qui 
    représente le file d'attente utilisé dans le fichier BFS.

Dossier graph :
 Partie graph (GrapheSimple et GrapheSimpleIO) : Code qui nous permet de traiter la matrice d'adjacence 
 et le tableau de listes d'adjacences d'un graphe en fonction de ce que l'utilisateur entre.

Dossier test : 
 Partie dedié à la vérification du fonctionemment de notre algorithme/code. Dedans ce dossier on trouve 2
 fichiers :
  - Le fichier main, utilisé pour tester le fichier BFS à l'aide des fichiers contenus dans le dossier graph.
  - Le fichier TestFile01, utilisé pour tester le fichier GrapheSimple à l'aide du fichier GrapheSimpleIO.

Utilisation du programme

 Pour vérifier le fonctionnement du code nous avons créé un petit programme de test dans le dossier "test" appelé "main".
 Pour 
 Nous demandons à l’utilisateur d'entrer l’ordre du graphe qu’il veut traiter. 
 Une fois que cela est fait, l’utilisateur devra rentrer le graphe sous forme de tableau de liste d’adjacence
 (chaque ligne du tableau entré devra finir par 0).

 Finalement, une fois que nous avons récupéré toutes les données entrées par l’utilisateur, nous exécutons l’algorithme 
 de parcours en largeur à partir du sommet 1 du graphe pour savoir si nous sommes en train de traiter un graphe connexe ou pas. 
 Ensuite, nous affichons le résultat du test de connexité et seulement si le graphe qu’on traite n’est pas connexe, nous réalisons
 un algorithme pour trouver les composantes connexes du graphe et nous les affichons.

---------------------------------------------------------------------------------------------------------------------------------------
