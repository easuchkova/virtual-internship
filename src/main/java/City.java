public class City {
    public int id;
    public String name;
    public String region;
    public String district;
    public int population;
    public String foundation;

    public City(int id, String name, String region, String district, int population, String foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }
}