import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GridProcessorService {

    public List<String> bomberman(int n, List<String> grid) {
        if (n == 1) {
            return grid;
        }

        if (n % 2 == 0) {
            return grid.stream().map(word -> word.replace('.', 'O')).collect(Collectors.toList());
        }

        List<String> threeSecondsGrid = new ArrayList<>(grid);
        threeSecondsGrid = processGrid(threeSecondsGrid);

        List<String> fiveSecondsGrid = new ArrayList<>(threeSecondsGrid);
        fiveSecondsGrid = processGrid(fiveSecondsGrid);

        if (n == 3 || n % 4 == 3) {
            return threeSecondsGrid;
        } else {
            return fiveSecondsGrid;
        }
    }

    public List<String> processGrid(List<String> list) {

        List<String> grid = new ArrayList<>(list);

        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid.get(i).length(); j++) {
                if(grid.get(i).charAt(j) == 'O') {
                    if(i != 0 && grid.get(i - 1).charAt(j) != 'O') {
                        String modifiedString = grid.get(i - 1).substring(0, j)
                            + 'X'
                            + grid.get(i - 1).substring(j + 1);
                        grid.set(i - 1, modifiedString);
                    }

                    if(i != grid.size() - 1 && grid.get(i + 1).charAt(j) != 'O') {
                        String modifiedString = grid.get(i + 1).substring(0, j)
                            + 'X'
                            + grid.get(i + 1).substring(j + 1);
                        grid.set(i + 1, modifiedString);
                    }


                    grid.set(i, replaceCharAtIndex(grid.get(i), j - 1, 'X'));
                    grid.set(i, replaceCharAtIndex(grid.get(i), j + 1, 'X'));
                }
            }
        }

        grid = grid.stream().map(word -> word.replace('X', 'O')).collect(Collectors.toList());
        grid = grid.stream().map(word -> word.replace('O', 'X')).collect(Collectors.toList());
        grid = grid.stream().map(word -> word.replace('.', 'O')).collect(Collectors.toList());
        return grid.stream().map(word -> word.replace('X', '.')).collect(Collectors.toList());
    }

    public static String replaceCharAtIndex(String str, int index, char newChar) {
        if (!(index < 0 || index >= str.length())) {
            if(str.charAt(index) != 'O') {
                return str.substring(0, index) + newChar + str.substring(index + 1);
            }
        }
        return str;
    }
}