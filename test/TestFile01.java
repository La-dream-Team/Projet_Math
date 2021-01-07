package test ;
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException ;
import graph.GraphSimple ;
import graph.GraphSimpleIO ;
import graph.MiscellaneousInput ;
import graph.MiscellaneousOutput ;


public class TestFile01 {
    private static void Usage () {
        System.out.println ("Usage: ") ;
        System.out.println (" ** " + TestFile01.class.getName()) ;
        System.out.println (" Everything read from stdin") ;
        System.out.println (" ** " + TestFile01.class.getName()+ " <filename>") ;
        System.out.println (" Graph read from <filename>, " + "questions asked on stdin") ;
    }

    public static void main (String[] arg) {
        Sanner stdin, file ;
        if (arg.length <= 1) {
            stdin = new Scanner (System.in) ;
            if (arg.length == 0) {
                file = stdin ;
            }
            else {
                try {
                    file = new Scanner (new File (arg[0])) ;
                }
                catch (FileNotFoundException e) {
                    System.err.println ("File \"" + arg[0℄ + "\" not found") ;
                    return ;
                }
            }
        }
        else { // arg.length > 1
            Usage () ; return ;
        }
        int n = MiscellaneousInput.getInteger (file) ;
        GraphSimple graph = GraphSimpleIO.getGraphAmatrix (file, n) ;
        System.out.print("Give a vertex: ") ;
        int x = MiscellaneousInput.getInteger() ;
        while (x != 0) {
            MiscellaneousOutput.printlnIntegers (graph.getAdjacencyList (x)) ;
            System.out.print("Give a vertex: ") ;
            x = MiscellaneousInput.getInteger() ;
        }
    }
}
