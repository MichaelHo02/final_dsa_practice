package Practice;

import java.util.ArrayList;
import java.util.List;

public class ExerciseManagement {

    ArrayList<FitnessExercise> collection;

    ExerciseManagement() {
        collection = new ArrayList<>();
    }

    public static void main(String[] args) {
        FitnessExercise e1 = new FitnessExercise("Swimming", 30, 100);  // duration is given before fitness
        FitnessExercise e2 = new FitnessExercise("Football", 45, 120);
        FitnessExercise e3 = new FitnessExercise("Table tennis", 60, 150);
        ExerciseManagement mgmt = new ExerciseManagement();
        mgmt.add(e1);
        mgmt.add(e2);
        mgmt.add(e3);
        List<FitnessExercise> list1 = new ArrayList<>();
        list1.add(e1);
        list1.add(e2);
        List<FitnessExercise> list2 = new ArrayList<>();
        list2.add(e1);
        list2.add(e3);
        System.out.println(mgmt.exercises(list1));  // return "Swimming, Football"
        System.out.println(mgmt.exercises(list2));  // return "Swimming, Table Tennis"
        System.out.println(mgmt.exercises(mgmt.optimalExercises(120)));  // You can do either Swimming or Football in 120 minutes, but doing Football gives you more fitness, so you should return a list containing Football
        System.out.println(mgmt.exercises(mgmt.optimalExercises(250)));  // Doing Swimming and Table Tennis brings you 90, which is the highest in 250 minutes, so you should return a list containing Swimming and Table Tennis
    }

    public List<FitnessExercise> optimalExercises(int N) {
        int n = collection.size();
        int[][] V = new int[n + 1][N + 1];
        boolean[][] taken = new boolean[n + 1][N + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= N; j++) {
                V[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {
                if (collection.get(i - 1).duration > j) {
                    V[i][j] = V[i - 1][j];
                    continue;
                }
                if (V[i - 1][j - collection.get(i - 1).duration] + collection.get(i - 1).fitness > V[i - 1][j]) {
                    V[i][j] = V[i - 1][j - collection.get(i - 1).duration] + collection.get(i - 1).fitness;
                    taken[i][j] = true;
                } else {
                    V[i][j] = V[i - 1][j];
                }
            }
        }
        List<FitnessExercise> result = new ArrayList<>();
        int capacity = N;
        int last = n;
        while (capacity > 0 && last > 0) {
            if (taken[last][capacity]) {
                result.add(collection.get(last - 1));
                capacity -= collection.get(last - 1).duration;
            }
            last--;
        }
        return result;
    }

    public String exercises(List<FitnessExercise> exercises) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < exercises.size(); i++) {
            for (int j = 0; j < collection.size(); j++) {
                if (exercises.get(i).name.compareTo(collection.get(j).name) == 0) {
                    if (s.length() == 0) {
                        s.append(exercises.get(i).name);
                    } else {
                        s.append(", ").append(exercises.get(i).name);
                    }
                }
            }
        }
        return s.toString();
    }

    public void add(FitnessExercise ex) {
        collection.add(ex);
    }

    static class FitnessExercise {
        String name;
        int duration;
        int fitness;

        FitnessExercise(String name, int duration, int fitness) {
            this.name = name;
            this.duration = duration;
            this.fitness = fitness;
        }
    }

}
