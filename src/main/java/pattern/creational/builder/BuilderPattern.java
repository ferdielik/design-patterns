package pattern.creational.builder;

/** @wikipedia
 The intent of the Builder design pattern is to separate the construction of a complex object from its representation. By doing so the same construction process can create different representations. [2]
 */
public class BuilderPattern {

    public static void main(String[] args) {
        new BuilderPattern().run();
    }

    void run() {

        Car car = new CarBuilder().setBrand("Audi")
                .setAcceleration("6,3 second")
                .setFuelCapacity("75 liter")
                .setType("SUV")
                .setEngineCapacity("2967 cc")
                .build();


        System.out.println("Builded " + car.toString());
    }
}

