import java.util.ArrayList;
import java.util.List;

public class Task1 {



    public static class CircularArrayPath {
        public static List<Integer> findCircularPath(int n, int m) {
            List<Integer> path = new ArrayList<>();
            int currentIndex = 0;

            for (int i = 0; i < n; i++) {
                path.add(currentIndex + 1);
                currentIndex = (currentIndex + m) % n;
            }

            return path;
        }

        public static void main(String[] args) {
            int n = 5; // Размер массива
            int m = 3; // Длина интервала

            List<Integer> circularPath = findCircularPath(n, m);

            System.out.println("Круговой массив:");
            for (int num : circularPath) {
                System.out.print(num + " ");
            }
        }
    }
}
