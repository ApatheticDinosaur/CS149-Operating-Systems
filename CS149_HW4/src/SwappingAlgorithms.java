import java.util.ArrayList;

/**
 * @author Andy Wang
 * @author Kunal Palwankar
 * @author Julian Zabala
 * @author David Pham
 * A swapping algorithms object that will be used to print the result of
 * each algorithm
 */
public class SwappingAlgorithms {

    private ArrayList memory = new ArrayList();

    public SwappingAlgorithms(){
        for(int i = 0; i < 100; i++) {
            memory.add(i, ".");
        }
    }

    public void firstFit(ArrayList<Process> proc) {
        int time = 0;
        ArrayList<Process> processes = proc;
        for(Process p : processes) { // for each process
            for (Process c : processes) {
                if(memory.contains(c.getName())) { //decrease duration for each process in memory
                    c.setDuration(c.getDuration() - 1);
                }
                if(c.getDuration() == 0) { //process is done, replace with .'s
                    for(int i = 0; i < memory.size(); i++) {
                        if(memory.get(i) == c.getName()) {
                            memory.set(i, ".");
                        }
                    }
                }
            }
            if (p.getDuration() == 0) {
                continue;
            }
            int size = p.getSize();
            int duration = p.getDuration();
            String name = p.getName();
            for (int i = 0; i < memory.size(); i++) { //find a spot for this process
                if(memory.get(i) == ".") { //found empty spot, check next couple of spots
                    boolean available = true;
                    for (int j = i; j < size + i; j++) { //check if all slots are free
                        if (memory.get(j) == null) { break; } //prevent index out of bound
                        if (memory.get(j) != "."){ //another process is in the way, this process can't fit
                            available = false;
                        }
                    }
                    if(available) {
                        for (int j = i; j < size + i; j++) {
                            memory.set(j, name);
                        }
                        System.out.println(memory.toString());
                        break;
                    }
                }
            }
        }
    }

    public void nextFit(ArrayList<Process> p) {
        ArrayList<Process> processes = p;
        //TODO: Add next fit algorithm here
    }

    public void bestFit(ArrayList<Process> p) {
        ArrayList<Process> processes = p;
        //TODO: Add best fit algorithm here
    }

}
