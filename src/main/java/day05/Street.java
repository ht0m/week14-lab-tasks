package day05;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Street {

    private static final String SEPARATOR = " ";

    Map<String, List<Integer>> streetView = new HashMap<>();

    public void readFile() {
        Path path = Path.of("src/main/resources/streets.txt");

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String[] fields = scanner.nextLine().split(SEPARATOR);
                String key = fields[0];
                int newValue = Integer.parseInt(fields[1]) % 2 == 0 ? 0 : 1;
                putToMap(key, newValue);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }

        transformValuesToHouseNumbers();

    }

    private void transformValuesToHouseNumbers() {
        for (Map.Entry<String, List<Integer>> actual : streetView.entrySet()) {
            HouseNumber houseNumber = new HouseNumber();
            for (int i = 0; i < actual.getValue().size(); i++) {
                switch (actual.getValue().get(i)) {
                    case 0:
                        actual.getValue().set(i, houseNumber.getEven());
                        break;
                    case 1:
                        actual.getValue().set(i, houseNumber.getOdd());
                }
            }
        }


//        for (Map.Entry<String, List<Integer>> actual : streetView.entrySet()) {
//            int even = 2;
//            int odd = 1;
//            for (int i = 0; i < actual.getValue().size(); i++) {
//                if (actual.getValue().get(i) == 0) {
//                    actual.getValue().set(i, even);
//                    even += 2;
//                } else {
//                    actual.getValue().set(i, odd);
//                    odd += 2;
//                }
//            }
//        }
        System.out.println(streetView);
    }

    private void putToMap(String key, int newValue) {
        List<Integer> actual = streetView.get(key);
        if (actual == null) {
            actual = new ArrayList<>();
            streetView.put(key, actual);
        }
        actual.add(newValue);
    }
}



