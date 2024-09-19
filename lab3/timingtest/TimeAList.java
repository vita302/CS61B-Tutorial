package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        /**
         * Stopwatch class-- provided the time in a period .
         */
        AList<Integer>  Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        //AList<Double> opCount = new AList<Double>();

        int MAX_COUNT = 128000;
        for (int j = 1000 ; j <= MAX_COUNT ; j *= 2)
        {
            AList<Integer> test = new AList<Integer>();
            Ns.addLast(j);
            Stopwatch sw = new Stopwatch();
            for (int i = 0 ; i < j ; i ++) test.addLast(i);
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        };
        printTimingTable( Ns,  times,  Ns);
    }
}
