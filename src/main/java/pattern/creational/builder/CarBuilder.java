package pattern.creational.builder;

class CarBuilder
{
    private Car car;

    public CarBuilder()
    {
        this.car = new Car();
    }

    public CarBuilder setEngineCapacity(String engineCapacity)
    {
        car.setEngineCapacity(engineCapacity);
        return this;
    }

    public CarBuilder setBrand(String brand)
    {
        car.setBrand(brand);
        return this;
    }

    public CarBuilder setType(String type)
    {
        car.setType(type);
        return this;
    }

    public CarBuilder setAcceleration(String acceleration)
    {
        car.setAcceleration(acceleration);
        return this;
    }

    public CarBuilder setFuelCapacity(String fuelCapacity)
    {
        car.setFuelCapacity(fuelCapacity);
        return this;
    }

    public Car build()
    {
        return car;
    }
}