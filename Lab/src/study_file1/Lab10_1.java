package study_file1;

enum TrafficSignal {
    RED("stop"), YELLOW("cation"), GREEN("go");

    private final String meaning;

    TrafficSignal(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }
}
public class Lab10_1 {

    public static void main(String[] args) {
        for(TrafficSignal ts : TrafficSignal.values()){
            System.out.println(ts.getMeaning());
        }

    }
}
