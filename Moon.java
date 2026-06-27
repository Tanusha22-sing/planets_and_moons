
// A program to represent a Moon orbiting a planet
public class Moon {

    // Constants which are used for the calculations
    private static final double FOUR_THIRDS = 4.0 / 3.0;
    private static final double MASS_TO_GRAMS = 1e18;
    private static final double KM3_TO_CM3 = 1e15;
    private static final double LOW_DENSITY_THRESHOLD = 0.95;
    private static final double HIGH_DENSITY_THRESHOLD = 2.5;
    private static final int CUBE_POWER = 3;

    private String name;
    private double distance;
    private int correctionFactor;
    private double mass;
    private double diameter;


    public Moon(String name, double distance, int correctionFactor) {
        this.name = name;
        this.distance = distance;
        this.correctionFactor = correctionFactor;
        this.mass = 0;
        this.diameter = 0;
    }

    public Moon(String name, double distance, int correctionFactor, double mass, double diameter) {
        this.name = name;
        this.distance = distance;
        this.correctionFactor = correctionFactor;
        this.mass = mass;
        this.diameter = diameter;
    }
    // Getter methods
    public String getName() {
        return name;
    }
    // Calculates distance
    public double getDistance() {
        return distance;
    }

    public double getCorrection() {
        return correctionFactor;
    }

    public double getMass() {
        return mass;
    }

    public double getDiameter() {
        return diameter;
    }
    // Calculates orbital period
    public double getOrbitalPeriod() {
        return (Math.sqrt(distance) * distance) / correctionFactor;
    }
    // Calculates density
    public double getDensity() {
        if (diameter == 0) {
            return 0;
        }

        double radius = diameter / 2.0;
        double volume = FOUR_THIRDS * Math.PI * Math.pow(radius, CUBE_POWER);

        double massInGrams = mass * MASS_TO_GRAMS;
        double volumeInCm3 = volume * KM3_TO_CM3;

        return massInGrams / volumeInCm3;
    }
    // Based on density, the composition is calculated
    public String getComposition() {
        double density = getDensity();

        if (density == 0) {
            return "";
        }

        if (density < LOW_DENSITY_THRESHOLD) {
            return "mostly ice";
        } else if (density > HIGH_DENSITY_THRESHOLD) {
            return "mostly rock";
        } else {
            return "a mixture of rock and ice";
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Moon other = (Moon) object;
        return this.name.equals(other.name)
                && Double.compare(this.distance, other.distance) == 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + (int) distance;
    }
}
