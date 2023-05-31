import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {


    public static class CirclePosition {
        public static void main(String[] args) {
            if (args.length < 2) {
                System.out.println("Необходимо указать два файла в качестве аргументов");
                return;
            }

            String circleFile = args[0];
            String pointsFile = args[1];

            try {
                BufferedReader circleReader = new BufferedReader(new FileReader(circleFile));
                BufferedReader pointsReader = new BufferedReader(new FileReader(pointsFile));

                // Чтение координат центра окружности
                String circleLine = circleReader.readLine();
                String[] circleCoords = circleLine.split(" ");
                float centerX = Float.parseFloat(circleCoords[0]);
                float centerY = Float.parseFloat(circleCoords[1]);

                // Чтение радиуса окружности
                String radiusLine = circleReader.readLine();
                float radius = Float.parseFloat(radiusLine);

                String pointLine;
                while ((pointLine = pointsReader.readLine()) != null) {
                    String[] pointCoords = pointLine.split(" ");
                    float pointX = Float.parseFloat(pointCoords[0]);
                    float pointY = Float.parseFloat(pointCoords[1]);

                    // Расчет расстояния между центром окружности и точкой
                    float distance = (float) Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));

                    // Определение положения точки относительно окружности
                    int position;
                    if (distance == radius) {
                        position = 0; // Точка лежит на окружности
                    } else if (distance < radius) {
                        position = 1; // Точка внутри окружности
                    } else {
                        position = 2; // Точка снаружи окружности
                    }

                    System.out.println(position);
                }

                circleReader.close();
                pointsReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
