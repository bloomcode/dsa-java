import java.util.List;

/** Chapter 7.5 tests, one class per exercise. */

class Ex7_5_1Test {
    public static void run() {
        Check.eq(Ch7_5Backtracking.orderings(new int[] {1, 2, 3}),
                List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)));
        Check.eq(Ch7_5Backtracking.orderings(new int[0]), List.of(List.of()));
        Check.eq(Ch7_5Backtracking.orderings(new int[] {7}), List.of(List.of(7)));
        Check.eq(Ch7_5Backtracking.orderings(new int[] {1, 2, 3, 4, 5}).size(), 120);
    }
}

class Ex7_5_2Test {
    public static void run() {
        Check.eq(Ch7_5Backtracking.keypadLetters("23"), List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        Check.eq(Ch7_5Backtracking.keypadLetters(""), List.of());
        Check.eq(Ch7_5Backtracking.keypadLetters("7"), List.of("p", "q", "r", "s"));
        Check.eq(Ch7_5Backtracking.keypadLetters("79").size(), 16);
        Check.eq(Ch7_5Backtracking.keypadLetters("99").get(15), "zz");
    }
}

class Ex7_5_3Test {
    public static void run() {
        Check.eq(Ch7_5Backtracking.combinationsTo(new int[] {3, 4, 5}, 11), List.of(List.of(3, 3, 5), List.of(3, 4, 4)));
        Check.eq(Ch7_5Backtracking.combinationsTo(new int[] {2}, 1), List.of());
        Check.eq(Ch7_5Backtracking.combinationsTo(new int[] {1}, 3), List.of(List.of(1, 1, 1)));
        Check.eq(Ch7_5Backtracking.combinationsTo(new int[] {5, 2}, 7), List.of(List.of(2, 5)));
        Check.eq(Ch7_5Backtracking.combinationsTo(new int[] {1, 2}, 6).size(), 4);
    }
}

class Ex7_5_4Test {
    public static void run() {
        Check.eq(Ch7_5Backtracking.queenPlacements(4), 2);
        Check.eq(Ch7_5Backtracking.queenPlacements(1), 1);
        Check.eq(Ch7_5Backtracking.queenPlacements(2), 0);
        Check.eq(Ch7_5Backtracking.queenPlacements(3), 0);
        Check.eq(Ch7_5Backtracking.queenPlacements(5), 10);
        Check.eq(Ch7_5Backtracking.queenPlacements(6), 4);
        Check.eq(Ch7_5Backtracking.queenPlacements(8), 92);
    }
}

class Ex7_5_5Test {
    public static void run() {
        Check.eq(Ch7_5Backtracking.uniqueSubsets(new int[] {2, 1, 2}), List.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2)));
        Check.eq(Ch7_5Backtracking.uniqueSubsets(new int[0]), List.of(List.of()));
        Check.eq(Ch7_5Backtracking.uniqueSubsets(new int[] {3, 3}), List.of(List.of(), List.of(3), List.of(3, 3)));
        Check.eq(Ch7_5Backtracking.uniqueSubsets(new int[] {1, 2, 3}).size(), 8);
        Check.eq(Ch7_5Backtracking.uniqueSubsets(new int[] {1, 1, 2, 2}).size(), 9);
    }
}

class Ex7_5_6Test {
    public static void run() {
        Check.eq(Ch7_5Backtracking.addressSplits("101023"), List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"));
        Check.eq(Ch7_5Backtracking.addressSplits("0000"), List.of("0.0.0.0"));
        Check.eq(Ch7_5Backtracking.addressSplits("1111"), List.of("1.1.1.1"));
        Check.eq(Ch7_5Backtracking.addressSplits("123"), List.of());
        Check.eq(Ch7_5Backtracking.addressSplits("256256256256"), List.of());
        Check.eq(Ch7_5Backtracking.addressSplits("255255255255"), List.of("255.255.255.255"));
    }
}

class Ex7_5_7Test {
    public static void run() {
        int[][] full = new int[9][9], puzzle = new int[9][9];
        int blanks = 0;
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
                full[r][c] = (r * 3 + r / 3 + c) % 9 + 1;
                puzzle[r][c] = (r * 7 + c * 3) % 9 < 5 ? 0 : full[r][c];
                if (puzzle[r][c] == 0) blanks++;
            }
        int[][] given = new int[9][];
        for (int r = 0; r < 9; r++) given[r] = puzzle[r].clone();
        Check.eq(blanks, 45);
        Check.yes(Ch7_5Backtracking.solveSudoku(puzzle));
        Check.yes(solved(puzzle));
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) Check.yes(given[r][c] == 0 || given[r][c] == puzzle[r][c]);
        int[][] stuck = new int[9][9];
        for (int c = 0; c < 8; c++) stuck[0][c] = c + 1;
        stuck[1][8] = 9;
        int[][] before = new int[9][];
        for (int r = 0; r < 9; r++) before[r] = stuck[r].clone();
        Check.no(Ch7_5Backtracking.solveSudoku(stuck));
        Check.eq(stuck, before);
        int[][] empty = new int[9][9];
        Check.yes(Ch7_5Backtracking.solveSudoku(empty));
        Check.yes(solved(empty));
    }

    static boolean solved(int[][] b) {
        for (int i = 0; i < 9; i++) {
            int row = 0, col = 0, box = 0;
            for (int j = 0; j < 9; j++) {
                row |= 1 << b[i][j];
                col |= 1 << b[j][i];
                box |= 1 << b[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
            }
            if (row != 0x3FE || col != 0x3FE || box != 0x3FE) return false;
        }
        return true;
    }
}
