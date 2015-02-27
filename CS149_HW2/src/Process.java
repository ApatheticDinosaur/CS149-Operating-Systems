import java.util.Random;
/**
 * Created by Andy on 2/16/2015.
 */
public class Process {
    public String name;
    private float arrivaltime;
    private float runtime;
    private int priority;

    public Process(String n){
        name = n;
        Random r = new Random();
        arrivaltime = r.nextFloat() * 100;
        runtime = r.nextFloat() + (r.nextFloat() * 10);
        priority = r.nextInt(4) + 1;
    }

    public Process(String n, long seed){
        name = n;
        Random r = new Random(seed);
        arrivaltime = r.nextFloat() * 100;
        runtime = r.nextFloat() + (r.nextFloat() * 10);
        priority = r.nextInt(4) + 1;
    }

    public void setArrivalTime(float a) {
        arrivaltime = a;
    }

    public void setRunRime(float b) {
        runtime = b;
    }

    public void setPriority(int p) {
        priority = p;

    }

    public float getArrivalTime() {
        return arrivaltime;
    }

    public float getRunTime() {
        return runtime;
    }

    public float getPriority() {
        return priority;
    }
}