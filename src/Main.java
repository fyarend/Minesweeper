import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matris satır sayısını giriniz: ");
        int m = scanner.nextInt();
        System.out.print("Matris sütun sayısını giriniz: ");
        int n = scanner.nextInt();

        char[][] matrix = generateRandomMatrix(m, n);

         printMatrix(matrix);
        /*char[][] matrix = {
                {'*', '*', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '*', '.', '.', '.'},

        };*/
        char[][] result = countAdjacentMines(matrix);
        for (char[] row : result) {
            System.out.println(new String(row));
        }

    }

    public static char[][] generateRandomMatrix(int m, int n) {
        char[][] matrix = new char[m][n];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int randomNumber = random.nextInt(2); // 0 veya 1
                matrix[i][j] = (randomNumber == 0) ? '*' : '.'; //  * veya . atama rastgele olarak
            }
        }

        return matrix;


    }

    public static void printMatrix(char[][] matrix) {
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static char[][] countAdjacentMines(char[][] field) {
        int rows = field.length;
        int cols = field[0].length;
        char[][] result = new char[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (field[x][y] == '*') {
                    result[x][y] = '*';
                } else {
                    int count = countMinesAround(field, x, y);
                    result[x][y] = (char) (count + '0');
                }
            }
        }
        return result;
    }

    private static boolean isValidCoord(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private static int countMinesAround(char[][] field, int x, int y) {
        int count = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int rows = field.length;
        int cols = field[0].length;

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isValidCoord(newX, newY, rows, cols) && field[newX][newY] == '*') {
                count++;
            }
        }

        return count;
    }

}


