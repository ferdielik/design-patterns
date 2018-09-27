package pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern
{
    ObserverPattern()
    {
        Cargo cargo = new Cargo();
        new Tracker(cargo, "Sender");
        new Tracker(cargo, "Receiver");
        new Tracker(cargo, "Cargo Firm");


        cargo.setState(CargoState.CARGOED);
        cargo.setState(CargoState.ON_THE_ROAD);
        cargo.setState(CargoState.DELIVERED);
    }

    public static void main(String[] args)
    {
        new ObserverPattern();
    }

    enum CargoState
    {
        CARGOED("Cargoed"),
        ON_THE_ROAD("Cargo on the road"),
        DELIVERED("Cargo delivered");

        String message;

        CargoState(String message)
        {
            this.message = message;
        }

        public String getMessage()
        {
            return message;
        }
    }

    class Cargo
    {
        private CargoState state;
        private List<CargoTracker> observers = new ArrayList<>();

        CargoState getState()
        {
            return state;
        }

        void setState(CargoState state)
        {
            this.state = state;
            notifyObservers();
        }

        void register(CargoTracker tracker)
        {
            observers.add(tracker);
        }

        private void notifyObservers()
        {
            observers.forEach(observer -> observer.update());
        }
    }

    abstract class CargoTracker
    {
        Cargo cargo;

        abstract void update();
    }

    class Tracker extends CargoTracker
    {
        String name;

        Tracker(Cargo cargo, String name)
        {
            cargo.register(this);
            this.cargo = cargo;
            this.name = name;
        }

        @Override
        void update()
        {
            System.out.println(name + ", your cargo state: " + cargo.getState().getMessage());
        }
    }
}