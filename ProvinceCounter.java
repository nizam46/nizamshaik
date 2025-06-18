import java.util.Scanner;

public class ProvinceCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the total number of cities:");
        int cityCount = input.nextInt();

        int[][] connectionMap = new int[cityCount][cityCount];
        System.out.println("Enter the adjacency matrix (each row space-separated):");
        input.nextLine();

        for (int row = 0; row < cityCount; row++) {
            String[] connections = input.nextLine().split(" ");
            for (int col = 0; col < cityCount; col++) {
                connectionMap[row][col] = Integer.parseInt(connections[col]);
            }
        }

        System.out.println("Total provinces found: " + countProvinces(connectionMap));

        input.close();
    }

    public static int countProvinces(int[][] connectionMap) {
        int totalCities = connectionMap.length;
        boolean[] explored = new boolean[totalCities];
        int provinceCount = 0;

        for (int city = 0; city < totalCities; city++) {
            if (!explored[city]) {
                provinceCount++;
                exploreDFS(city, connectionMap, explored);
            }
        }
        return provinceCount;
    }

    private static void exploreDFS(int currentCity, int[][] map, boolean[] explored) {
        explored[currentCity] = true;
        for (int neighbor = 0; neighbor < map.length; neighbor++) {
            if (map[currentCity][neighbor] == 1 && !explored[neighbor]) {
                exploreDFS(neighbor, map, explored);
            }
        }
    }
}
