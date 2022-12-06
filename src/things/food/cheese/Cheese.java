package things.food.cheese;

import things.food.Food;

public class Cheese extends Food {
    public Cheese(String name)
    {
        super(name);
    }

    public CheesePiece getPiece()
    {
        System.out.println("От сыра отрезали кусочек");
        return new CheesePiece("ломтик сыра");
    }
}
