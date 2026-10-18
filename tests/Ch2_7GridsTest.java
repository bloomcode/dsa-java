import java.util.List;

/** Chapter 2.7 tests, one class per exercise. */

class Ex2_7_1Test {
    public static void run() {
        Check.eq(Ch2_7Grids.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}}), new int[][] {{1, 4}, {2, 5}, {3, 6}});
        Check.eq(Ch2_7Grids.transpose(new int[][] {{7}}), new int[][] {{7}});
        Check.eq(Ch2_7Grids.transpose(new int[0][]), new int[0][]);
        Check.eq(Ch2_7Grids.transpose(new int[][] {{1}, {2}}), new int[][] {{1, 2}});
    }
}

class Ex2_7_2Test {
    public static void run() {
        Check.eq(Ch2_7Grids.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), List.of(1, 2, 3, 6, 9, 8, 7, 4, 5));
        Check.eq(Ch2_7Grids.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}}), List.of(1, 2, 3, 6, 5, 4));
        Check.eq(Ch2_7Grids.spiralOrder(new int[][] {{1, 2}, {3, 4}, {5, 6}}), List.of(1, 2, 4, 6, 5, 3));
        Check.eq(Ch2_7Grids.spiralOrder(new int[][] {{1, 2, 3, 4}}), List.of(1, 2, 3, 4));
        Check.eq(Ch2_7Grids.spiralOrder(new int[][] {{1}, {2}, {3}}), List.of(1, 2, 3));
        Check.eq(Ch2_7Grids.spiralOrder(new int[0][]), List.of());
    }
}

class Ex2_7_3Test {
    public static void run() {
        int[][] grid = {{1, 4, 7, 11}, {2, 5, 8, 12}, {3, 6, 9, 16}, {10, 13, 14, 17}};
        Check.eq(Ch2_7Grids.findInSortedGrid(grid, 9), new int[] {2, 2});
        Check.eq(Ch2_7Grids.findInSortedGrid(grid, 15), new int[] {-1, -1});
        Check.eq(Ch2_7Grids.findInSortedGrid(grid, 1), new int[] {0, 0});
        Check.eq(Ch2_7Grids.findInSortedGrid(grid, 17), new int[] {3, 3});
        Check.eq(Ch2_7Grids.findInSortedGrid(grid, 10), new int[] {3, 0});
        Check.eq(Ch2_7Grids.findInSortedGrid(new int[0][], 3), new int[] {-1, -1});
    }
}

class Ex2_7_4Test {
    public static void run() {
        Check.eq(Ch2_7Grids.zigzagOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), List.of(1, 2, 4, 7, 5, 3, 6, 8, 9));
        Check.eq(Ch2_7Grids.zigzagOrder(new int[][] {{1, 2, 3}, {4, 5, 6}}), List.of(1, 2, 4, 5, 3, 6));
        Check.eq(Ch2_7Grids.zigzagOrder(new int[][] {{1}, {2}, {3}}), List.of(1, 2, 3));
        Check.eq(Ch2_7Grids.zigzagOrder(new int[][] {{1, 2, 3}}), List.of(1, 2, 3));
        Check.eq(Ch2_7Grids.zigzagOrder(new int[0][]), List.of());
    }
}

class Ex2_7_5Test {
    public static void run() {
        int[][] grid = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        Check.yes(Ch2_7Grids.zeroRowsCols(grid) == grid);
        Check.eq(grid, new int[][] {{1, 0, 3}, {0, 0, 0}, {7, 0, 9}});
        Check.eq(Ch2_7Grids.zeroRowsCols(new int[][] {{0, 1}, {1, 1}}), new int[][] {{0, 0}, {0, 1}});
        Check.eq(Ch2_7Grids.zeroRowsCols(new int[][] {{1, 1}, {1, 1}}), new int[][] {{1, 1}, {1, 1}});
        Check.eq(Ch2_7Grids.zeroRowsCols(new int[][] {{5, 0, 7}}), new int[][] {{0, 0, 0}});
        Check.eq(Ch2_7Grids.zeroRowsCols(new int[][] {{1, 2}, {3, 4}, {0, 6}}), new int[][] {{0, 2}, {0, 4}, {0, 0}});
    }
}

class Ex2_7_6Test {
    public static void run() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Check.yes(Ch2_7Grids.rotateClockwise(grid) == grid);
        Check.eq(grid, new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
        Check.eq(Ch2_7Grids.rotateClockwise(new int[][] {{1, 2}, {3, 4}}), new int[][] {{3, 1}, {4, 2}});
        Check.eq(Ch2_7Grids.rotateClockwise(new int[][] {{5}}), new int[][] {{5}});
        Check.eq(Ch2_7Grids.rotateClockwise(new int[0][]), new int[0][]);
    }
}

class Ex2_7_7Test {
    public static void run() {
        int[][] full = new int[9][9];
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) full[r][c] = (r * 3 + r / 3 + c) % 9 + 1;
        Check.yes(Ch2_7Grids.validBoard(board()));
        Check.yes(Ch2_7Grids.validBoard(full));
        Check.yes(Ch2_7Grids.validBoard(board(0, 0, 5, 4, 4, 5)));
        Check.no(Ch2_7Grids.validBoard(board(0, 0, 5, 1, 1, 5)));
        Check.no(Ch2_7Grids.validBoard(board(0, 4, 3, 8, 4, 3)));
        Check.no(Ch2_7Grids.validBoard(board(4, 0, 7, 4, 8, 7)));
        full[8][8] = full[8][7];
        Check.no(Ch2_7Grids.validBoard(full));
    }

    static int[][] board(int... cells) {
        int[][] b = new int[9][9];
        for (int i = 0; i < cells.length; i += 3) b[cells[i]][cells[i + 1]] = cells[i + 2];
        return b;
    }
}
