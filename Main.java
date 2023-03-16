package CFT;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(final String[] args) {
        final List<Scanner> scanners = new ArrayList<>();
        try {
            final MergeSortRequest sortRequest = CommandLineParser.parse(args);
            for (final File file : sortRequest.getFiles()) {
                scanners.add(new Scanner(new FileInputStream(file)));
            }

            final Comparator<String> comparator;
            switch (sortRequest.getSortType()) {
                case INT:
                    comparator = (i1, i2) -> {
                        final int integer1 = Integer.parseInt(i1);
                        final int integer2 = Integer.parseInt(i2);
                        if (sortRequest.getIsAscending()) {
                            return Integer.compare(integer1, integer2);
                        } else {
                            return Integer.compare(integer2, integer1);
                        }
                    };
                    break;
                case STRING:
                    comparator = (i1, i2) -> {
                        if (sortRequest.getIsAscending()) {
                            return i1.compareTo(i2);
                        } else {
                            return i2.compareTo(i1);
                        }
                    };
                    break;
                default:
                    throw new IllegalArgumentException("Неподдерживаемый тип данных");
            }

            final MergeSorter stringMergeSorting = new MergeSorter();
            try (final FileOutputStream os = new FileOutputStream(sortRequest.getOutput())) {
                stringMergeSorting.sort(comparator, scanners, os);
            }

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Выполнение программы невозможно." + " " + e.getMessage());
        } finally {
            for (Scanner scanner : scanners) {
                scanner.close();
            }
        }
    }
}

