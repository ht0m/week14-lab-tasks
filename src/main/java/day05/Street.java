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
                if (streetView.get(key) == null) {
                    streetView.put(key, new ArrayList());
                }
                streetView.get(key).add(newValue);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }

        for (Map.Entry<String, List<Integer>> actual : streetView.entrySet()) {
            int even = 2;
            int odd = 1;
            for (int i = 0; i < actual.getValue().size(); i++) {
                if (actual.getValue().get(i) == 0) {
                    actual.getValue().set(i, even);
                    even += 2;
                } else {
                    actual.getValue().set(i, odd);
                    odd += 2;
                }
            }
        }

        System.out.println(streetView);
    }
}



