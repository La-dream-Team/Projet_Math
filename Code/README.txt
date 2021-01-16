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

IMPORTANT : Nous avons structure le projet et rangé le code dans le même ordre utilisé dans les sujets.

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

------------------------------------------------------------------------------------------------------------------