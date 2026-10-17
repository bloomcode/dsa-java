import java.util.List;

/** Chapter 7 tests, one class per exercise. */
class Ex7_1Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.meanOfEvens(new int[]{1, 2, 3, 4, 6}), 4.0);
        Check.eq(Ch07EverydayBigO.meanOfEvens(new int[]{1, 3}), null);
    }
}

class Ex7_2Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.twoLetterWords(new char[]{'a', 'b', 'c'}), List.of("ab", "ac", "ba", "bc", "ca", "cb"));
    }
}

class Ex7_3Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.threeLetterWords(new char[]{'a', 'b', 'c'}),
                List.of("abc", "acb", "bac", "bca", "cab", "cba"));
    }
}

class Ex7_4Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.sample(new int[]{1, 2, 3, 4, 5}), new int[]{1, 3, 5});
    }
}

class Ex7_5Test {
    public static void run() {
        Check.near(Ch07EverydayBigO.averageCelsius(new double[]{32, 212}), 50.0, 1e-9);
    }
}

class Ex7_6Test {
    public static void run() {
        List<String> labels = Ch07EverydayBigO.clothingLabels(List.of("Shirt"));
        Check.eq(labels.size(), 5);
        Check.eq(labels.get(0), "Shirt Size: 1");
        Check.eq(labels.get(4), "Shirt Size: 5");
    }
}

class Ex7_7Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.countOnes(new int[][]{{0, 1, 1}, {1, 0}, {1, 1, 1, 0}}), 6);
    }
}

class Ex7_8Test {
    public static void run() {
        Check.yes(Ch07EverydayBigO.isPalindrome("racecar"));
        Check.no(Ch07EverydayBigO.isPalindrome("kayaks"));
        Check.yes(Ch07EverydayBigO.isPalindrome(""));
    }
}

class Ex7_9Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.pairProducts(new int[]{1, 2, 3, 4}), List.of(2L, 3L, 4L, 6L, 8L, 12L));
    }
}

class Ex7_10Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.crossProducts(new int[]{1, 2}, new int[]{10, 100, 1000}),
                List.of(10L, 100L, 1000L, 20L, 200L, 2000L));
    }
}

class Ex7_11Test {
    public static void run() {
        Check.eq(Ch07EverydayBigO.allPasswords(2, "ab"), List.of("aa", "ab", "ba", "bb"));
        Check.eq(Ch07EverydayBigO.allPasswords(3, "abcdefghijklmnopqrstuvwxyz").size(), 17576);
    }
}
