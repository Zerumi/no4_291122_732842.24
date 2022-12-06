package places.singlePlaces.trees;

import exceptions.uncheckedExceptions.TreeBrokenException;
import places.singlePlaces.ILookable;
import places.singlePlaces.SinglePlace;
import places.superPlaces.SuperPlace;

public class Tree extends SinglePlace {

    private final Trunk trunk;
    private final Crown crown;

    {
        trunk = new Trunk(120);
        crown = new Crown();
    }
    public Tree(String name) {
        super(name);
    }

    public Tree(String name, SuperPlace location) {
        super(name, location);
    }

    public Tree(String name, SuperPlace location, int height) {
        super(name, location);
        trunk.height = height;
    }

    public Crown getCrown()
    {
        return crown;
    }

    public Trunk getTrunk()
    {
        return trunk;
    }

    public class Trunk
    {
        private int height;
        private int angleRotate;

        {
            angleRotate = 0;
        }

        public int getAngleRotate()
        {
            return angleRotate;
        }

        public int getHeight() {
            return height;
        }

        public Trunk(int height)
        {
            this.height = height;
        }

        public void curve(int angle)
        {
            this.angleRotate += angle;
            System.out.println(Tree.this.getName() + " наклонилось на " + angle + " градусов.");
            double chanceToBreak = angleRotate * 0.00555555;
            if (Math.random() > 1 - chanceToBreak)
            {
                throw new TreeBrokenException("ДЕРЕВО НЕ ВЫДЕРЖАЛО НАКЛОНА И СЛОМАЛОСЬ :(");
            }
        }
    }

    public class Crown implements ILookable
    {
        @Override
        public String getName() {
            return "крона дерева " + Tree.this.getName();
        }
    }
}
