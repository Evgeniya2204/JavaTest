package CFT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {

    public static MergeSortRequest parse(final String[] args) throws IOException {
        boolean isAscending;
        SortType sortType;
        int nextArg;

        if (args.length == 0) {
            throw new IllegalArgumentException("Параметры программы не заданы");
        }
        if (args.length < 3) {
            throw new IllegalArgumentException("Некорректное количество параметров!");
        }
        if (("-d").equals(args[0])) {
            isAscending = false;
            if (("-s").equals(args[1])) {
                sortType = SortType.STRING;
            } else if (("-i").equals(args[1])) {
                sortType = SortType.INT;
            } else {
                throw new IllegalArgumentException("Некорректный ввод. Не указан тип данных (-s или -i)");
            }
            nextArg = 2;
        } else if (("-a").equals(args[0])) {
            isAscending = true;
            if (("-s").equals(args[1])) {
                sortType = SortType.STRING;
            } else if (("-i").equals(args[1])) {
                sortType = SortType.INT;
            } else {
                throw new IllegalArgumentException("Некорректный ввод. Не указан тип данных (-s или -i)");
            }
            nextArg = 2;
        } else if (("-s").equals(args[0])) {
            isAscending = true;
            sortType = SortType.STRING;
            nextArg = 1;
        } else if (("-i").equals(args[0])) {
            isAscending = true;
            sortType = SortType.INT;
            nextArg = 1;
        } else {
            throw new IllegalArgumentException("Некорректный ввод. Первым параметром должен быть указан режим сортировки или тип данных");
        }

        File outputFile = new File(args[nextArg]);
        if (!outputFile.canWrite()) {
            throw new IOException("Запись в файл запрещена");
        }
        nextArg++;
        if (args.length - nextArg < 1) {
            throw new IllegalArgumentException("Не указаны имена входных данных");
        }

        List<File> inputFiles = new ArrayList<>();

        for (int i = nextArg; i < args.length; i++) {
            File input = new File(args[nextArg]);
            try {
                if (!input.exists()) {
                    throw new FileNotFoundException("Файл не найден");
                }
                if (!input.canRead()) {
                    throw new IOException("Невозможно прочитать файл, отсутствуют права");
                }
                if (input.length() == 0) {
                    throw new IOException("Не удается получить элементы, файл " + input.getName() + " пуст");
                }
                inputFiles.add(input);
                nextArg++;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                nextArg++;
            }
        }
        return MergeSortRequest.create(sortType, isAscending, inputFiles, outputFile);
    }
}