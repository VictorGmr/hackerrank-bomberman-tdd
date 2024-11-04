import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GridProcessorServiceTest {

    private GridProcessorService service;

    @Before
    public void init() {
        service = new GridProcessorService();
    }

    @Test
    public void shouldCallBombermanPassingStringListAndIterationNumber() {
        String grid = "";
        service.bomberman(1, List.of(grid));
    }

    @Test
    public void shouldReturnStringList_whenCallingBomberman() {
        String grid = "";
        List<String> result = new ArrayList<>();
        result = service.bomberman(1, List.of(grid));
    }

    @Test
    public void shouldReturnResultingGrid_whenBombermanIsCalled() {

        int n = 3;

        List<String> grid = List.of(
            "...",
            ".O.",
            "..."
        );

        List<String> expectedResult = List.of(
            "O.O",
            "...",
            "O.O"
        );

        List<String> result = service.bomberman(n, grid);
        assertEquals(expectedResult, result);

    }

    @Test
    public void shouldReturnResultingGrid_whenBombermanIsCalledIn2Seconds() {

        int n = 2;

        List<String> grid = List.of(
            "...",
            ".O.",
            "..."
        );

        List<String> expectedResult = List.of(
            "OOO",
            "OOO",
            "OOO"
        );

        List<String> result = service.bomberman(n, grid);
        assertEquals(expectedResult, result);

    }

    @Test
    public void shouldReturnResultingGrid_whenBombermanIsCalledIn5Seconds() {

        int n = 5;

        List<String> grid = List.of(
            "...",
            ".O.",
            "..."
        );

        List<String> expectedResult = List.of(
            "...",
            ".O.",
            "..."
        );

        List<String> result = service.bomberman(n, grid);
        assertEquals(expectedResult, result);

    }

    @Test
    public void shouldReturnResultingGrid_whenBombermanIsCalledWithNModuleOf4Being3() {

        int n = 7;

        List<String> grid = List.of(
            "...",
            ".O.",
            "..."
        );

        List<String> expectedResult = List.of(
            "O.O",
            "...",
            "O.O"
        );

        List<String> result = service.bomberman(n, grid);
        assertEquals(expectedResult, result);

    }

}