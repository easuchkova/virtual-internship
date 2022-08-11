import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static <inputScream> void main(String[] args) {

        String fileName = "Задача ВС Java Сбер.csv";
        File file = new File(fileName);
        List<City> cities = new ArrayList<>();

        try (Scanner inputScream = new Scanner(file);) {
            inputScream.useDelimiter(System.getProperty("line.separator"));
            while (inputScream.hasNextLine()) {
                City city = parseCSVLine(inputScream.nextLine());
                cities.add(city);
//                System.out.println(city.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<City> comparator = new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        cities.sort(Comparator.comparing(City::getName, String.CASE_INSENSITIVE_ORDER));

        for (City city:cities) {
            System.out.println(city.toString());
            System.out.println();
        }

        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));

        for (City city:cities) {
            System.out.println(city.toString());
        }
    }

    private static City parseCSVLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");

        int id = scanner.nextInt();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation;

        if (scanner.hasNext())
            foundation = scanner.next();
        else
            foundation = "";

        return new City(id, name, region, district, population, foundation);
    }
}
