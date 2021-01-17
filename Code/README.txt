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



TP2
Exercice 2 
h )
je ne comprend pas pourquoi avoir un constructeur sachant 
qu'il y a que des methodes static dans la class graphSimpleIO.

---------------------------------------------------------------------------------------------------------------

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
 Une fois exécuté le fichier, nous demandons à l'utilisateur d'entrer initialement un entier compris entre 0 et 2 :
  - Le 0 correspond à la sortie du programme.
  - Le 1 correspond à entrer le graphe à traiter sous forme de matrice d'adjacence.
  - Le 2 correspond à entrer le graphe à traiter sous forme de tableau de listes d'adjacence.
 Une fois que cela est fait, l'utilisateur devra entrer l'ordre du graphe voulu. 
 Puis il devra entrer le graphe sous la forme choisie précédemment.
 Finalement, une fois que l'utilisateur a fini d’entrer toutes ces données, nous demandons à l’utilisateur d’entrer 
 le traitement qu’il veut exercer sur le graphe (parcours en largeur ou test de connexité) :
  - S’il entre X, nous exécutons l’algorithme de parcours en largeur du graphe à partir du sommet voulu par l’utilisateur.
  - S’il entre Y, nous vérifions juste si le graphe entré correspond avec un graphe connexe ou pas et nous afficherons le résultat.  

------------------------------------------------------------------------------------------------------------------