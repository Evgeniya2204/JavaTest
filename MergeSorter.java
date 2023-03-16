package CFT;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MergeSorter implements MergeSorting {
    @Override
    public void sort(final Comparator<String> comparator, final List<Scanner> scanners, final OutputStream os) {

        List<String> dataFromFiles = new ArrayList<>();
        List<String> dataToSort = new ArrayList<>();
        int indexMin = 0;

        outer:
        for (int j = 0; j < scanners.size(); j++) {
            interior:
            while (scanners.get(j).hasNextLine()) {
                String string = scanners.get(j).nextLine();
                for (int i = 0; i < string.length(); i++) {
                    if (Character.isWhitespace(string.charAt(i))) {
                        continue interior;
                    }
                }
                dataFromFiles.add(string);
                dataToSort.add(dataFromFiles.get(dataFromFiles.size() - 1));
                continue outer;
            }
            if (!scanners.get(j).hasNextLine()) {
                scanners.remove(j);
                j--;
            }
        }

        try (PrintWriter writer = new PrintWriter(os)) {

            while (scanners.size() > 1) {
                dataToSort.sort(comparator);
                writer.println(dataToSort.get(0));

                for (int i = 0; i < dataFromFiles.size(); i++) {
                    if (dataToSort.get(0) == dataFromFiles.get(i)) {
                        indexMin = i;
                        break;
                    }
                }
                dataFromFiles.remove(indexMin);
                dataToSort.remove(0);

                outer:
                for (; ; ) {
                    if (scanners.get(indexMin).hasNextLine()) {
                        String nextLine = scanners.get(indexMin).nextLine();
                        for (int i = 0; i < nextLine.length(); i++) {
                            if (Character.isWhitespace(nextLine.charAt(i))) {
                                continue outer;
                            }
                        }
                        dataFromFiles.add(indexMin, nextLine);
                        dataToSort.add(dataFromFiles.get(indexMin));
                    } else {
                        scanners.remove(scanners.get(indexMin));
                        if (scanners.size() == 1) {
                            writer.println(dataToSort.get(0));
                        }
                    }
                    break;
                }
            }
            outer:
            while (scanners.get(0).hasNextLine()) {
                String nextLine = scanners.get(0).nextLine();
                for (int i = 0; i < nextLine.length(); i++) {
                    if (Character.isWhitespace(nextLine.charAt(i))) {
                        continue outer;
                    }
                }
                writer.println(nextLine);
            }
        }
    }
}
