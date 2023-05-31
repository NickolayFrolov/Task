import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task4 {

    public static class MinMoves {
        public static int minMoves(int[] nums) {
            int minMoves = 0;
            Arrays.sort(nums);
            int median = nums[nums.length / 2];

            for (int num : nums) {
                minMoves += Math.abs(num - median);
            }

            return minMoves;
        }

        public static void main(String[] args) {
            if (args.length < 1) {
                System.out.println("Необходимо указать имя файла в качестве аргумента");
                return;
            }

            String inputFile = args[0];

            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                String line;
                int[] nums = new int[100]; // Массив для хранения чисел
                int count = 0; // Количество чисел в массиве

                // Чтение чисел из файла
                while ((line = reader.readLine()) != null) {
                    int num = Integer.parseInt(line);
                    nums[count] = num;
                    count++;
                }

                int minMoves = minMoves(Arrays.copyOf(nums, count));
                System.out.println("Минимальное количество ходов: " + minMoves);

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
