/**
 * Created by Andy on 2/26/2015.
 */
public class Process {

    private int size;
    private int duration;
    private String name;

    public Process(int size, int duration, String name) {
        this.size = size;
        this.duration = duration;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
