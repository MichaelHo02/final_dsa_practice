package w7.p2;

public class Hashing {
    private static final int sizeHashTable = 13;
    private static final String[] hashTable = new String[sizeHashTable];
    private static int size = 0;

    private static int hashChar(char c) {
        return c - 'A';
    }

    private static int hashString(String s) {
        int hashTotal = 0;
        for (int i = 0; i < s.length(); i++) {
            hashTotal += hashChar(s.charAt(i));
        }
        return hashTotal % sizeHashTable;
    }

    private static boolean put(String s) {
        if (size == sizeHashTable) return false;

        int index = hashString(s);
        while (hashTable[index] != null) {
            if (hashTable[index].equals(s)) {
                return false;
            }
            index = (index + 1) % sizeHashTable;
        }
        hashTable[index] = s;
        size++;
        return true;
    }

    private static boolean get(String s) {
        int index = hashString(s);
        while (hashTable[index] != null) {
            if (hashTable[index].equals(s)) {
                return true;
            }
            index = (index + 1) % sizeHashTable;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(put("A"));
        System.out.println(put("B"));
        System.out.println(put("C"));
        System.out.println(put("ABC"));
        System.out.println(put("D"));
        System.out.println(put("E"));
        System.out.println(put("F"));
        System.out.println(put("DEF"));
        System.out.println(put("CBA"));
        System.out.println(put("XYZ"));
        System.out.println(put("BAC"));
        System.out.println(get("A"));
        System.out.println(get("BCA"));
    }
}
