import java.util.ArrayList;
/**
 * Created by Andy on 2/16/2015.
 */
public class main {
    public static void main(String [] args) {

        ArrayList<Process> processes = new ArrayList<Process>();

        //Populate the arraylist
        for(int i = 0; i < 5; i++) {
            String s = "p" + String.valueOf(i);
            Process a = new Process(s);
            processes.add(a);
            System.out.println("Name: " + a.name + " Arrival Time: " + a.getArrivalTime() + " Run Time: " + a.getRunTime() + " Priority: " + a.getPriority());
        }

        Algorithms a = new Algorithms();
        a.rr(processes);

    }
}
