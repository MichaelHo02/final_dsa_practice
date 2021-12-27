package W8.p2;

public class StringMatch {
    private static int match(String word, String pattern) {
        for (int startIndex = 0; startIndex < word.length() - pattern.length() + 1; startIndex++) {
            if (word.charAt(startIndex) == pattern.charAt(0)) {
                boolean valid = true;
                for (int i = 1; i < pattern.length(); i++) {
                    if (word.charAt(startIndex + i) != pattern.charAt(i)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    return startIndex;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(match("ABC", "B"));  // 1
        System.out.println(match("ABC", "D"));  // -1
        System.out.println(match("Hello", "He"));  // 0
        System.out.println(match("Hello", "lo"));  // 3
        System.out.println(match("Hello", "hello"));  // -1
        System.out.println(match("AABBCC", "ABC"));  // -1
        System.out.println(match("AABBCC", "AABBCCD"));  // -1
    }
}
