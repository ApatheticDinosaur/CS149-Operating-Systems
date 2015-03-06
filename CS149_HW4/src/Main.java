import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Andy Wang
 * @author Kunal Palwankar
 * @author Julian Zabala
 * @author David Pham
 * The main to be run to start the simulation
 */
public class Main {
    public static void main(String [] args) {

        PagingAlgorithms p = new PagingAlgorithms();
        SwappingAlgorithms s = new SwappingAlgorithms();

        System.out.println("----------------------------------------First Fit----------------------------------------");
        double ffavg = 0;
        for(int a = 0; a < 5; a++) {
            ffavg += s.firstFit(createProcesses());
        }
        System.out.println("----------------------------------------Next Fit----------------------------------------");
        double nfavg = 0;
        for(int b = 0; b < 5; b++) {
            nfavg += s.nextFit(createProcesses());
        }
        System.out.println("----------------------------------------Best Fit----------------------------------------");
        double bfavg = 0;
        for(int c = 0; c < 5; c++) {
            bfavg += s.bestFit(createProcesses());
        }

        System.out.println("First fit average is " + ffavg / 5);
        System.out.println("Next fit average is " + nfavg / 5);
        System.out.println("Best fit average is " + bfavg / 5);
    }

    public static ArrayList<Process> createProcesses() {
        ArrayList<Process> processes = new ArrayList<Process>();
        int[] sizes = {5, 11, 17, 31};
        Random r = new Random();
        for (int i = 0; i < 150; i++) {
            int size = sizes[r.nextInt(4)];
            int duration = r.nextInt(5) + 1;
            System.out.println(duration);
            String name = Integer.toString(i);
            processes.add(new Process(size, duration, name));
        }
        return processes;
    }
}
