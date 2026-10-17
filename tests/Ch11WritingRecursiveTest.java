import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Chapter 11 tests, one class per exercise. */
class Ex11_1Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.doubleInPlace(new int[]{1, 2, 3}, 0), new int[]{2, 4, 6});
    }
}

class Ex11_2Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.reverse("abcde"), "edcba");
        Check.eq(Ch11WritingRecursive.reverse(""), "");
    }
}

class Ex11_3Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.countX("axbxcxd", 0), 3);
        Check.eq(Ch11WritingRecursive.countX("", 0), 0);
    }
}

class Ex11_4Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.totalChars(List.of("ab", "c", "def", "ghij")), 10);
    }
}

class Ex11_5Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.selectEvens(List.of(1, 2, 3, 4, 5, 6)), List.of(2, 4, 6));
    }
}

class Ex11_6Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.triangular(7), 28L);
        Check.eq(Ch11WritingRecursive.triangular(1), 1L);
    }
}

class Ex11_7Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.indexOfX("abcdefghijklmnopqrstuvwxyz", 0), 23);
        Check.eq(Ch11WritingRecursive.indexOfX("abc", 0), -1);
    }
}

class Ex11_8Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.staircase(3), 4L);
        Check.eq(Ch11WritingRecursive.staircase(5), 13L);
    }
}

class Ex11_9Test {
    public static void run() {
        List<String> an = Ch11WritingRecursive.anagrams("abc");
        Check.eq(new HashSet<>(an), Set.of("abc", "bac", "bca", "acb", "cab", "cba"));
        Check.eq(an.size(), 6);
        Check.eq(Ch11WritingRecursive.anagrams("abcdef").size(), 720);
    }
}

class Ex11_10Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.uniquePaths(3, 7), 28L);
    }
}

class Ex11_11Test {
    public static void run() {
        Check.eq(Ch11WritingRecursive.subsets(List.of(1, 2)), List.of(List.of(), List.of(2), List.of(1), List.of(1, 2)));
        Check.eq(Ch11WritingRecursive.subsets(List.of(1, 2, 3, 4)).size(), 16);
    }
}
