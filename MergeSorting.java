package CFT;

import java.io.OutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public interface MergeSorting {
    void sort(final Comparator<String> comparator, final List<Scanner> scanners, final OutputStream os);
}
