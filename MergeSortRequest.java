package CFT;

import java.io.File;
import java.util.List;

public class MergeSortRequest {
    private final SortType sortType;
    private final boolean isAscending;
    private final List<File> files;
    private final File output;

    public MergeSortRequest(SortType sortType, boolean isAscending, List<File> files, File output) {
        this.sortType = sortType;
        this.isAscending = isAscending;
        this.files = files;
        this.output = output;
    }

    public SortType getSortType(){
        return sortType;
    }

    public List<File> getFiles(){
        return files;
    }

    public boolean getIsAscending(){
        return isAscending;
    }

    public File getOutput(){
        return output;
    }

    public static MergeSortRequest create(SortType sortType, boolean isAscending, List<File> files, File output) {
        return new MergeSortRequest(sortType, isAscending, files, output);
    }

}
