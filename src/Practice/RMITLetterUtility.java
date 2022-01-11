package Practice;

import java.util.ArrayList;

public class RMITLetterUtility {
    //    RMITLetterUtility() {
//        rmitLetterArrayList = new ArrayList<>();
//    }
    ArrayList<RMITLetter> rmitLetterArrayList;

    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'R', 'N', 'U', 'R', 'M', 'U', 'V'},
                {'X', 'L', 'N', 'U', 'T', 'M', 'J', 'C'},
                {'A', 'Q', 'N', 'H', 'I', 'U', 'V', 'H'},
                {'A', 'R', 'O', 'U', 'R', 'G', 'U', 'I'},
                {'B', 'R', 'N', 'L', 'R', 'M', 'U', 'T'}
        };
        RMITLetterUtility rmitLetterUtility = new RMITLetterUtility();
        rmitLetterUtility.rmitLetterArrayList = rmitLetterUtility.scan(arr);
        System.out.println(rmitLetterUtility.canConnect(rmitLetterUtility.rmitLetterArrayList.get(0), rmitLetterUtility.rmitLetterArrayList.get(1)));
        System.out.println(rmitLetterUtility.canConnect(rmitLetterUtility.rmitLetterArrayList.get(1), rmitLetterUtility.rmitLetterArrayList.get(2)));
        System.out.println(rmitLetterUtility.canFindRMIT());
    }

    public boolean canFindRMIT() {
        for (int i = 0; i < rmitLetterArrayList.size(); i++) {
            if (rmitLetterArrayList.get(i).letter == 'R') {
                for (int j = 0; j < rmitLetterArrayList.size(); j++) {
                    if (rmitLetterArrayList.get(j).letter == 'M') {
                        if (canConnect(rmitLetterArrayList.get(i), rmitLetterArrayList.get(j))) {
                            for (int k = 0; k < rmitLetterArrayList.size(); k++) {
                                if (rmitLetterArrayList.get(k).letter == 'I') {
                                    if (canConnect(rmitLetterArrayList.get(j), rmitLetterArrayList.get(k))) {
                                        for (int l = 0; l < rmitLetterArrayList.size(); l++) {
                                            if (rmitLetterArrayList.get(l).letter == 'T') {
                                                if (canConnect(rmitLetterArrayList.get(k), rmitLetterArrayList.get(l))) {
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public ArrayList<RMITLetter> scan(char[][] letters) {
        ArrayList<RMITLetter> rmitLetters = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                char letter = letters[i][j];
                if (letter == 'R' || letter == 'M' || letter == 'I' || letter == 'T') {
                    rmitLetters.add(new RMITLetter(letter, i, j));
                }
            }
        }
        return rmitLetters;
    }

    public boolean canConnect(RMITLetter l1, RMITLetter l2) {
        if (
                (l1.letter == 'R' && l2.letter == 'M') ||
                (l1.letter == 'M' && l2.letter == 'I') ||
                (l1.letter == 'I' && l2.letter == 'T')
        ) {
            int diffRow = l2.row - l1.row;
            int diffCol = l2.col - l1.col;
            int step = diffCol + diffRow;
            return step <= 4;
        } else {
            return false;
        }
    }


    static class RMITLetter {
        char letter;
        int row;
        int col;

        RMITLetter(char letter, int row, int col) {
            this.letter = letter;
            this.row = row;
            this.col = col;
        }
    }

}
