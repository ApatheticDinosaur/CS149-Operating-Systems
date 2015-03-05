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

    ArrayList<Process> processes;

    public static void main(String [] args) {

        int[] sizes = {5, 11, 17, 31};
        ArrayList<Process> processes = new ArrayList<Process>();
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            int size = sizes[r.nextInt(3)];
            int duration = r.nextInt(4) + 1;
            processes.add(new Process(size, duration));
        }

        for (Process p : processes) {
            System.out.println("Duration: " + p.getDuration() + " Size: " + p.getSize());
        }
    }
}
