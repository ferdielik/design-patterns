package pattern.behavioral;

public class StatePattern
{
    StatePattern()
    {
        Power playerContext = new Power(new Off()); // power off
        playerContext.press(); // power on
        playerContext.press(); // power off
        playerContext.press();
    }

    public static void main(String[] args)
    {
        new StatePattern();
    }

    private interface State
    {
        void press(Power context);
    }

    public class Power
    {
        private State state;

        private Power(State state)
        {
            this.state = state;
        }

        public void press()
        {
            state.press(this);
        }

        public State getState()
        {
            return state;
        }

        public void setState(State state)
        {
            this.state = state;
        }
    }

    public class On implements State
    {
        public void press(Power context)
        {
            context.setState(new Off());
            System.out.println("power on");
        }
    }

    public class Off implements State
    {
        public void press(Power context)
        {
            context.setState(new On());
            System.out.println("power off");
        }
    }
}
