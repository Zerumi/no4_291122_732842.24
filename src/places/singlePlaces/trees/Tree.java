package places.singlePlaces.trees;

import exceptions.uncheckedExceptions.TreeBrokenException;
import places.singlePlaces.ILookable;
import places.singlePlaces.SinglePlace;
import places.superPlaces.SuperPlace;

import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trunk trunk = (Trunk) o;
            return height == trunk.height && angleRotate == trunk.angleRotate;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, angleRotate);
        }
    }

    public class Crown implements ILookable
    {
        private String name;

        public Crown()
        {
            name = "крона дерева " + Tree.this.getName();
        }
        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Crown crown = (Crown) o;
            return Objects.equals(name, crown.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return getClass().getName() + "[" +
                    "name=" + name  +
                    ']';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Tree tree = (Tree) o;
        return Objects.equals(trunk, tree.trunk) && Objects.equals(crown, tree.crown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trunk, crown);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "trunk=" + trunk +
                ",crown=" + crown +
                ']';
    }
}
