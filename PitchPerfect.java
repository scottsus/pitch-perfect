import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PitchPerfect {
    public static void main(String[] args) {
        int numTeams = 6;
        List<String> names, topics;
        try {
            File namesFile = new File("./RhoClass.txt");
            BufferedReader namesBr = new BufferedReader(new FileReader(namesFile));
            int N = Integer.valueOf(namesBr.readLine());
            names = new LinkedList<>();
            for (int i = 0; i < N; i++)
                names.add(namesBr.readLine());
            namesBr.close();

            File topicsFile = new File("./Topics.txt");
            BufferedReader topicsBr = new BufferedReader(new FileReader(topicsFile));
            int M = Integer.valueOf(topicsBr.readLine());
            topics = new LinkedList<>();
            for (int i = 0; i < M; i++)
                topics.add(topicsBr.readLine());
            topicsBr.close();
        } catch (IOException ioe) {
            System.out.println("Unable to open file: " + ioe.toString());
            return;
        }
        Collections.shuffle(names);
        Collections.shuffle(topics);
        for (int i = 0; i < numTeams; i++) {
            String l1 = names.remove(0),
                    l2 = names.remove(0),
                    r1 = names.remove(0),
                    r2 = names.remove(0);
            String topic = topics.remove(0);
            String[] parts = topic.split(",");
            String t1 = parts[0], t2 = parts[1];
            log(i, l1, l2, r1, r2, t1, t2);
        }
        System.out.println("\nMay the best PITCHERS win!");
        System.out.println("\nExtra topics:");
        while (!topics.isEmpty()) {
            String topic = topics.remove(0);
            String[] parts = topic.split(",");
            String t1 = parts[0], t2 = parts[1];
            System.out.println(t1 + " vs " + t2);
        }
    }

    public static void log(int round, String l1, String l2, String r1, String r2, String t1, String t2) {
        try {
            System.out.println("Round " + (round + 1));
            TimeUnit.SECONDS.sleep(1);
            System.out.print("(");
            System.out.print(l1);
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" and ");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(l2);
            System.out.print(")");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" VERSUS ");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("(");
            System.out.print(r1);
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" and ");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(r2);
            System.out.print(") ");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(t1);
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" is better than ");
            System.out.print(t2);
            System.out.println("!!!");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            System.out.println(ie.toString());
        }
    }
}
