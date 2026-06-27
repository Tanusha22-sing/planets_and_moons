/* FEEDBACK REFLECTION AND IMPROVEMENT: In both my programs, I've tried to break the lines of code into
multiple lines. As mentioned in my coursework 1 feedback, I merged many of the lines into one single line
This makes it hard to read and work with. An example of this is when I programmed the getter methods; I ensured
the return lines came after the method was stated on a new, separate line. Another improvement that I have made based on
previous feedback is the names I give my constants in moon.java. I was told in coursework 1 not to use the direct
translation of the value held in the constant as the name, e.g. I used SQUARE_ONE = 1 for the square numbers in
subtract a square. Hence, I have carefully chosen appropriate names to ensure minimal confusion for the user.
Therefore, with this feedback and improvements, I believe I was able to construct more organised programs. */

// A program to represent a planet having different moons
import java.util.ArrayList;

public class Planet {
    private String name;
    private int correctionFactor;
    private ArrayList<Moon> moons;

    public Planet(String name, int correctionFactor) {
        this.name = name;
        this.correctionFactor = correctionFactor;
        this.moons = new ArrayList<>();
    }

    public void addMoon(String name, double distance) {
        Moon newMoon = new Moon(name, distance, correctionFactor);
        moons.add(newMoon);
    }

    public void addMoon(String name, double distance, double mass, double diameter) {
        Moon newMoon = new Moon(name, distance, correctionFactor, mass, diameter);
        moons.add(newMoon);
    }

    public Moon getMoonByName(String moonName) {
        for (Moon m : moons) {
            if (m.getName().equals(moonName)) {
                return m;
            }
        }
        return null;
    }
    // returns closest moon to planet
    public Moon closest() {
        if (moons.isEmpty()) {
            return null;
        }

        Moon closest = moons.get(0);
        for (Moon m : moons) {
            if (m.getDistance() < closest.getDistance()) {
                closest = m;
            }
        }
        return closest;
    }
    // returns furthest moon to planet
    public Moon furthest() {
        if (moons.isEmpty()) {
            return null;
        }

        Moon furthest = moons.get(0);
        for (Moon m : moons) {
            if (m.getDistance() > furthest.getDistance()) {
                furthest = m;
            }
        }
        return furthest;
    }

    public String toString() {
        String result = "Planet " + name + " has moons:\n";

        for (Moon m : moons) {
            long roundedDistance = Math.round(m.getDistance());
            String roundedPeriod = String.format("%.2f", m.getOrbitalPeriod());

            if (m.getDiameter() > 0) {
                long roundedDiameter = Math.round(m.getDiameter());
                String roundedMass = String.format("%.2f", m.getMass());
                String roundedDensity = String.format("%.2f", m.getDensity());
                String composition = m.getComposition();

                result += m.getName() + " is " + roundedDistance
                        + " km from it's planet, orbits in " + roundedPeriod
                        + " days, has a mass of " + roundedMass
                        + " * 10e15 kg, a diameter of " + roundedDiameter
                        + " km, and a density of " + roundedDensity
                        + " g/cm^2 - it is probably " + composition + "\n";
            } else {
                result += m.getName() + " is " + roundedDistance
                        + " km from its planet, and orbits in "
                        + roundedPeriod + " days\n";
            }
        }

        return result;
    }
}
