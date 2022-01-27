package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testPairFinder() {
        PairFinder pf = new PairFinder();
        int[] arr = {7, 1, 1, 1, 1, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        System.out.println(pf.findPairs(arr));
    }
}