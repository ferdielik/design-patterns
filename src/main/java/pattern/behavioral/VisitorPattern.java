package pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern
{
    public static void main(String[] args)
    {
        new VisitorPattern();
    }

    VisitorPattern()
    {
        Basket basket = new Basket();

        basket.addItem(new Computer(100));
        basket.addItem(new Phone(50, true));
        basket.addItem(new Phone(50, false));


        System.out.println("amount: " + basket.getAmount());
    }

    /**
     * Visitable element interface
     */
    interface Visitable
    {
        void accept(Visitor visitor);
    }

    /**
     * Concrete elements
     */
    class Computer implements Visitable
    {
        private double price;

        Computer(double price)
        {
            this.price = price;
        }

        @Override
        public void accept(Visitor visitor)
        {
            visitor.visit(this);
        }

        public double getPrice()
        {
            return price;
        }
    }

    class Phone implements Visitable
    {
        String model;
        double purePrice;
        boolean extras;

        Phone(double purePrice, boolean extras)
        {
            this.extras = extras;
            this.purePrice = purePrice;
        }

        //accept the visitor
        @Override
        public void accept(Visitor visitor)
        {
            visitor.visit(this);
        }

        public String getModel()
        {
            return model;
        }

        public double getPurePrice()
        {
            return purePrice;
        }

        public boolean isExtras()
        {
            return extras;
        }
    }

    interface Visitor
    {
        void visit(Computer book);

        void visit(Phone book);

    }

    class AmountVisitor implements Visitor
    {
        private double totalAmount;

        @Override
        public void visit(Computer computer)
        {
            // any special cases for computer
            totalAmount += computer.getPrice();
        }

        @Override
        public void visit(Phone phone)
        {
            // any special cases for phone
            totalAmount += phone.getPurePrice() * (phone.isExtras() ? 2 : 1);
        }

        public double getTotalAmount()
        {
            return totalAmount;
        }
    }

    class Basket
    {
        private List<Visitable> items = new ArrayList<>();

        double getAmount()
        {
            AmountVisitor visitor = new AmountVisitor();
            items.forEach(item -> item.accept(visitor));
            return visitor.getTotalAmount();

        }

        void addItem(Visitable item)
        {
            items.add(item);
        }
    }
}
