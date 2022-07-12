import java.util.*;

public class Lesson implements Comparable<Lesson> {

    private int index;
    private List<Integer> dependencies;
    private boolean isTaken;

    public Lesson(int index, List<Integer> dependencies, boolean isTaken) {
        this.index = index;
        this.dependencies = dependencies;
        this.isTaken = isTaken;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Integer> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Integer> dependencies) {
        this.dependencies = dependencies;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    @Override
    public int compareTo(Lesson o) {
        return index - o.index;
    }
}