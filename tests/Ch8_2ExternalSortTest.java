import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/** Chapter 8.2 tests, one class per exercise. */

final class Ch8_2ExternalSortTest {
    private Ch8_2ExternalSortTest() {}

    static int[] randomTenK() {
        int[] a = new int[10_000];
        Random re = new Random(2);
        for (int i = 0; i < a.length; i++) a[i] = re.nextInt(1_000_000);
        return a;
    }

    static int[] sorted(int[] a) {
        int[] s = a.clone();
        Arrays.sort(s);
        return s;
    }
}

class Ex8_2_1Test {
    public static void run() {
        Check.eq(Ch8_2ExternalSort.makeRuns(new int[]{5, 1, 9, 3, 7, 2, 8}, 3).stream().map(Arrays::toString).toList(),
                List.of("[1, 5, 9]", "[2, 3, 7]", "[8]"));
        Check.eq(Ch8_2ExternalSort.makeRuns(new int[]{}, 3).size(), 0);
    }
}

class Ex8_2_2Test {
    public static void run() {
        Ch8_2ExternalSort.Sorted s2 = Ch8_2ExternalSort.twoWaySort(IntStream.range(0, 16).map(i -> 16 - i).toArray(), 2);
        Check.eq(s2.data(), IntStream.rangeClosed(1, 16).toArray());
        Check.eq(s2.passes(), 4);
        int[] tenK = Ch8_2ExternalSortTest.randomTenK();
        Ch8_2ExternalSort.Sorted tw = Ch8_2ExternalSort.twoWaySort(tenK, 100);
        Check.eq(tw.data(), Ch8_2ExternalSortTest.sorted(tenK));
        Check.eq(tw.passes(), 8);
        Check.eq(Ch8_2ExternalSort.twoWaySort(new int[]{}, 4).data(), new int[]{});
    }
}

class Ex8_2_3Test {
    public static void run() {
        Check.eq(Ch8_2ExternalSort.kWayMerge(List.of(new int[]{1, 4, 9}, new int[]{2, 3}, new int[]{0, 10})),
                new int[]{0, 1, 2, 3, 4, 9, 10});
        Check.eq(Ch8_2ExternalSort.kWayMerge(List.of()), new int[]{});
    }
}

class Ex8_2_4Test {
    public static void run() {
        int[] tenK = Ch8_2ExternalSortTest.randomTenK();
        Ch8_2ExternalSort.Sorted mw = Ch8_2ExternalSort.multiwaySort(tenK, 100, 10);
        Check.eq(mw.data(), Ch8_2ExternalSortTest.sorted(tenK));
        Check.eq(mw.passes(), 4);
    }
}

class Ex8_2_5Test {
    public static void run() {
        Check.eq(Ch8_2ExternalSort.passesTwoWay(10_000, 100), 8);
        Check.eq(Ch8_2ExternalSort.passesMultiway(10_000, 100, 10), 4);
        Check.eq(Ch8_2ExternalSort.passesTwoWay(16, 2), 4);
    }
}

class Ex8_2_6Test {
    public static void run() {
        Check.eq(Ch8_2ExternalSort.externalSortIos(10_000, 100, 10), 8000L);
    }
}

class Ex8_2_7Test {
    public static void run() {
        try {
            Path src = Files.createTempFile("src", ".txt"), dst = Files.createTempFile("dst", ".txt");
            try {
                List<Integer> nums = new ArrayList<>(IntStream.range(0, 1000).boxed().toList());
                Collections.shuffle(nums, new Random(6));
                Files.write(src, nums.stream().map(String::valueOf).toList());
                Check.eq(Ch8_2ExternalSort.sortFile(src, dst, 100), 10);
                Check.eq(Files.readAllLines(dst).stream().map(Integer::parseInt).toList(), IntStream.range(0, 1000).boxed().toList());
            } finally {
                Files.deleteIfExists(src);
                Files.deleteIfExists(dst);
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
