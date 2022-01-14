package W10.p2;

public class TopologicalSort {
    public static void main(String[] args) {
        int[] res = sort(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        });
        for (int re : res) {
            System.out.println(re);
        }
    }

    static int[] sort(int[][] courses) {
        int n = courses.length;
        int[] result = new int[n];
        int location = 0;
        while (location < n) {
            boolean found = false;
            for (int currentCourse = 0; currentCourse < n; currentCourse++) {
                if (allZero(courses, currentCourse)) {
                    for (int remainingCourse = 0; remainingCourse < n; remainingCourse++) {
                        if (currentCourse == remainingCourse) {
                            continue;
                        }
                        if (courses[remainingCourse][currentCourse] == 1) {
                            courses[remainingCourse][currentCourse] = 0;
                        }
                    }
                    result[location++] = currentCourse;
                    courses[currentCourse][0] = -1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Courses are mutually dependent!");
                return new int[]{};
            }
        }
        return result;
    }

    private static boolean allZero(int[][] courses, int i) {
        for (int j = 0; j < courses[i].length; j++) {
            if (courses[i][j] != 0) {
                return false;
            }
        }
        return true;
    }
}
