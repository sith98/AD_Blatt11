import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

enum Color {
    WHITE, GREY, BLACK
}

public class Aufgabe2 {
    private static boolean[][] matrix = Arrays.stream(new String[]{
        "011000100",
        "000100000",
        "100110000",
        "000000100",
        "100001001",
        "001110010",
        "000000010",
        "000100001",
        "000001000"
    }).map(row -> {
        boolean[] bRow = new boolean[row.length()];
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == '1') {
                bRow[i] = true;
            }
        }
        return bRow;
    }).toArray(boolean[][]::new);

    private static void breadthFirst(int startVertex) {
        Color[] colors = new Color[matrix[0].length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.WHITE;
        }

        colors[startVertex] = Color.GREY;
        Queue<Integer> queue = new ArrayDeque<>(matrix[0].length);

        queue.add(startVertex);

        while (queue.size() > 0) {
            int vertex = queue.remove();
            for (int j = 0; j < matrix[vertex].length; j++) {
                if (matrix[vertex][j]) {
                    if (colors[j] == Color.WHITE) {
                        colors[j] = Color.GREY;
                        queue.add(j);
                    }
                }
            }
            colors[vertex] = Color.BLACK;
            System.out.println(vertex);
        }
    }

    private static void depthFirst(int startVertex) {
        Color[] colors = new Color[matrix[0].length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.WHITE;
        }

        _depthFirst(startVertex, colors);
    }

    private static void _depthFirst(int vertex, Color[] colors) {
        System.out.println(vertex);
        colors[vertex] = Color.GREY;
        for (int j = 0; j < matrix[vertex].length; j++) {
            if (matrix[vertex][j]) {
                if (colors[j] == Color.WHITE) {
                    _depthFirst(j, colors);
                }
            }
        }
        colors[vertex] = Color.BLACK;
    }

    public static void main(String[] args) {
        breadthFirst(0);
        System.out.println();
        depthFirst(0);
    }
}
