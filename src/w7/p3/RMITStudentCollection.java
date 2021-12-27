package w7.p3;

public class RMITStudentCollection {
    static class RMITStudent {
        String id;
        String major;
        String name;
        double GPA;

        RMITStudent(String id, String major, String name, double GPA) {
            this.id = id;
            this.major = major;
            this.name = name;
            this.GPA = GPA;
        }

        @Override
        public String toString() {
            return "RMITStudent{" +
                    "id='" + id + '\'' +
                    ", major='" + major + '\'' +
                    ", name='" + name + '\'' +
                    ", GPA=" + GPA +
                    '}';
        }
    }

    private static final int sizeHashTable = 13;
    private static final RMITStudent[] hashTable = new RMITStudent[sizeHashTable];
    private static int size = 0;

    private static int hashChar(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0' + 26;
        }
        return c - 'A';
    }

    private static int hashString(String s) {
        int hashTotal = 0;
        for (int i = 0; i < s.length(); i++) {
            hashTotal += hashChar(s.charAt(i));
        }
        return hashTotal % sizeHashTable;
    }

    private static boolean put(RMITStudent student) {
        if (size == sizeHashTable) return false;

        String id = student.id;
        int index = hashString(id);
        while (hashTable[index] != null) {
            if (hashTable[index].id.equals(id)) {
                return false;
            }
            index = (index + 1) % sizeHashTable;
        }
        hashTable[index] = student;
        size++;
        return true;
    }

    private static RMITStudent get(String id) {
        int index = hashString(id);
        while (hashTable[index] != null) {
            if (hashTable[index].id.equals(id)) {
                return hashTable[index];
            }
            index = (index + 1) % sizeHashTable;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Adding to the Hashtable - Linear probing");
        System.out.println(put(new RMITStudent("S123", "IT", "Tri", 82.00)));
        System.out.println(put(new RMITStudent("S456", "SE", "Tom", 70.50)));
        System.out.println(put(new RMITStudent("S789", "Business", "Alice", 85.50)));
        System.out.println(put(new RMITStudent("S213", "Music", "Bob", 79.50)));
        System.out.println(put(new RMITStudent("S231", "Psychology", "An", 65.50)));
        System.out.println(put(new RMITStudent("S123", "Aviation", "Teo", 90.00)));
        System.out.println(put(new RMITStudent("S312", "Security", "Winner", 80.50)));
        System.out.println(put(new RMITStudent("S312", "Marketing", "Loser", 71.50)));

        System.out.println("Retrieving from the Hashtable");
        System.out.println(get("S123"));
        System.out.println(get("S456"));
        System.out.println(get("S789"));
        System.out.println(get("S312"));
        System.out.println(get("S321"));
        System.out.println(get("S999"));
        System.out.println(get("S564"));
    }
}
