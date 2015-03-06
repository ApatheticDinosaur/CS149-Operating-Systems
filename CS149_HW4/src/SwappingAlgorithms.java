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

    public void resetMemory() {
        for(int i = 0; i < 100; i++) {
            memory.set(i, ".");
        }
    }

    public int firstFit(ArrayList<Process> proc) {
        resetMemory();
        ArrayList<Process> processes = proc;
        for (int time = 0; time < 60; time++) {
        for(Process p : processes) { // for each process
            if (p.getDuration() == 0 || memory.contains(p.getName())) {
                continue;
            }
            int size = p.getSize();
            int duration = p.getDuration();
            String name = p.getName();
            for (int i = 0; i < memory.size(); i++) { //find a spot for this process
                if(memory.get(i) == ".") { //found empty spot, check next couple of spots
                    boolean available = true;
                    for (int j = i; j < size + i; j++) { //check if all slots are free
                        if (j == memory.size()) {
                            available = false;
                            break;
                        } //prevent index out of bound
                        if (memory.get(j) != "."){ //another process is in the way, this process can't fit
                            available = false;
                        }
                    }
                    if(available) {
                        for (int j = i; j < size + i; j++) {
                            memory.set(j, name);
                        }
                        System.out.println("Process " + name + " has entered memory, its duration is " + duration + " and size is " + size);
                        for (int k = 0; k < memory.size(); k++) {
                            System.out.print(memory.get(k));
                        }
                        System.out.print("\n");
                        break;
                    }
                }
            }
        }
        for (Process c : processes) {
            if(memory.contains(c.getName())) { //decrease duration for each process in memory
                c.setDuration(c.getDuration() - 1);
            }
            if(c.getDuration() == 0 && memory.contains(c.getName())) { //process is done, replace with .'s
                for(int i = 0; i < memory.size(); i++) {
                    if(memory.get(i) == c.getName()) {
                        memory.set(i, ".");
                    }
                }
                System.out.println("Process " + c.getName() + " has left memory");
            }
        }
        }
        int numfinished = 0;
        for (Process h: processes) {
            if (h.getDuration() == 0) {
                numfinished++;
            }
        }
        return numfinished;
    }

    public int nextFit(ArrayList<Process> proc) {
        resetMemory();
        int position = 0;
        ArrayList<Process> processes = proc;
        for (int time = 0; time < 60; time++) {
            for (Process c : processes) {
                if(memory.contains(c.getName())) { //decrease duration for each process in memory
                    c.setDuration(c.getDuration() - 1);
                }
                if(c.getDuration() == 0 && memory.contains(c.getName())) { //process is done, replace with .'s
                    for(int i = 0; i < memory.size(); i++) {
                        if(memory.get(i) == c.getName()) {
                            memory.set(i, ".");
                        }
                    }
                    System.out.println("Process " + c.getName() + " has left memory");
                }
            }
            for(Process p : processes) { // for each process
                if (p.getDuration() == 0 || memory.contains(p.getName())) {
                    continue;
                }
                int size = p.getSize();
                int duration = p.getDuration();
                String name = p.getName();
                for (int i = position; i < memory.size(); i++) { //find a spot for this process
                    if(memory.get(i) == ".") { //found empty spot, check next couple of spots
                        boolean available = true;
                        for (int j = i; j < size + i; j++) { //check if all slots are free
                            if (j == memory.size()) {
                                available = false;
                                position = 0;
                                break;
                            } //prevent index out of bound
                            if (memory.get(j) != "."){ //another process is in the way, this process can't fit
                                available = false;
                            }
                        }
                        if(available) {
                            for (int j = i; j < size + i; j++) {
                                memory.set(j, name);
                            }
                            System.out.println("Process " + name + " has entered memory, its duration is " + duration + " and size is " + size);
                            for (int k = 0; k < memory.size(); k++) {
                                System.out.print(memory.get(k));
                            }
                            System.out.print("\n");
                            break;
                        }
                    }
                }
            }
        }
        int numfinished = 0;
        for (Process h: processes) {
            if (h.getDuration() == 0) {
                numfinished++;
            }
        }
        return numfinished;
    }

    public int bestFit(ArrayList<Process> proc) {
        resetMemory();
        ArrayList<Process> processes = proc;
        for (int time = 0; time < 60; time++) {
            for(Process p : processes) { // for each process
                if (p.getDuration() == 0 || memory.contains(p.getName())) {
                    continue;
                }
                int size = p.getSize();
                int duration = p.getDuration();
                String name = p.getName();
                for (int i = 0; i < memory.size(); i++) { //find a spot for this process
                    if(memory.get(i) == ".") { //found empty spot, check next couple of spots
                        boolean available = true;
                        for (int j = i; j < size + i; j++) { //check if all slots are free
                            if (j == memory.size()) {
                                available = false;
                                break;
                            } //prevent index out of bound
                            if (memory.get(j) != "."){ //another process is in the way, this process can't fit
                                available = false;
                            }
                        }
                        if(available) {
                            for (int j = i; j < size + i; j++) {
                                memory.set(j, name);
                            }
                            System.out.println("Process " + name + " has entered memory, its duration is " + duration + " and size is " + size);
                            for (int k = 0; k < memory.size(); k++) {
                                System.out.print(memory.get(k));
                            }
                            System.out.print("\n");
                            break;
                        }
                    }
                }
            }
            for (Process c : processes) {
                if(memory.contains(c.getName())) { //decrease duration for each process in memory
                    c.setDuration(c.getDuration() - 1);
                }
                if(c.getDuration() == 0 && memory.contains(c.getName())) { //process is done, replace with .'s
                    for(int i = 0; i < memory.size(); i++) {
                        if(memory.get(i) == c.getName()) {
                            memory.set(i, ".");
                        }
                    }
                    System.out.println("Process " + c.getName() + " has left memory");
                }
            }
        }
        int numfinished = 0;
        for (Process h: processes) {
            if (h.getDuration() == 0) {
                numfinished++;
            }
        }
        return numfinished;
    }

}
