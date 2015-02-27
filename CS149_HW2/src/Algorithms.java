import java.util.*;
import java.lang.Math;

/**
 * Created by Andy on 2/16/2015.
 */
public class Algorithms {

    public Algorithms() {
    }

    public void srt(ArrayList<Process> a) {
        ArrayList<Process> processes = a;
        ArrayList<String> timeline = new ArrayList<String>();
        Collections.sort(processes, new Comparator<Process>() {
            public int compare(Process o1, Process o2) {
                if (o1.getRunTime() > o2.getRunTime()) {
                    return 1;
                } else if (o1.getRunTime() < o2.getRunTime()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (Process p : processes) {
            System.out.println(p.name);
        }
        int currentprocess = 0;
        for (int currenttime = 0; currenttime < 100; currenttime++) {
            if (processes.size() == currentprocess) {
                break;
            }
            Process current = processes.get(currentprocess);
            if (Math.ceil(current.getArrivalTime()) <= currenttime) {
                //running process
                int processtime;
                for (processtime = currenttime; processtime < currenttime + Math.ceil(current.getRunTime()); processtime++) {
                    timeline.add(processtime, current.name);
                }
                currentprocess++;
                currenttime += processtime - currenttime - 1;
            } else {
                //waiting for process
                timeline.add(currenttime, "~");
            }
        }
        System.out.println(timeline);
    }

    public void rr(ArrayList<Process> a) {
        ArrayList<Process> processes = a;
        ArrayList<String> timeline = new ArrayList<String>();
        Collections.sort(processes, new Comparator<Process>() {
            public int compare(Process o1, Process o2) {
                if (o1.getArrivalTime() > o2.getArrivalTime()) {
                    return 1;
                } else if (o1.getArrivalTime() < o2.getArrivalTime()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (Process p : processes) {
            System.out.println(p.name);
        }
        int currentprocess = 0;

        LinkedList<Process> active = new LinkedList<Process>();

        int check = 0;
        for (int currenttime = 0; currenttime < 100; currenttime++) {
            if (processes.size() == currentprocess) {
                break;
            }
            Process current = processes.get(currentprocess);
            if (Math.ceil(current.getArrivalTime()) <= currenttime) {
                //found process
                active.addLast(current);
                currentprocess++;
                while (active.size() != 0) {
                    if (processes.size() == currentprocess) {
                        break;
                    }
                    if(Math.ceil(processes.get(currentprocess).getArrivalTime()) == currenttime) { //next process arrived
                        active.addLast(processes.get(currentprocess));
                        currentprocess++;
                    }
                    else if (active.peekFirst().getRunTime() >= 0) { //if the process hasn't ended (runtime still above 0)
                        Process modified = active.removeFirst();
                        timeline.add(currenttime, modified.name);
                        modified.setRunRime(modified.getRunTime() - 1); //subtract 1 from process run time (ran for 1 quanta)
                        active.addLast(modified);
                        currenttime++;
                    }
                    else {
                        active.removeFirst();
                    }
                }
                currenttime--; // Syncing time
            } else {
                //waiting for process
                timeline.add(currenttime, "~");
            }
        }
        System.out.println(timeline);


    }
}
