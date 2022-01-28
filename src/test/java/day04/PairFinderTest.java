package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testPairFinder() {
        PairFinder pf = new PairFinder();
        int[] arr = {5,1,4,5};
        System.out.println(pf.findPairs(arr));
    }
}