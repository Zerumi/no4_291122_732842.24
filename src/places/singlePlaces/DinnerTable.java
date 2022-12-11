package places.singlePlaces;

import entities.Entity;
import exceptions.chechedExceptions.TableIsAlreadyPreparedException;

import java.util.Objects;

public class DinnerTable extends Table {
    private boolean isPrepared;

    public DinnerTable(String name) {
        super(name);
        isPrepared = false;
    }

    public boolean isPrepared() {
        return isPrepared;
    }

    public void prepare(Entity preparator) {
        try {
            if (isPrepared())
            {
                throw new TableIsAlreadyPreparedException("Стол уже приготовлен для трапезы!");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        isPrepared = true;
        System.out.println(getName() + " подготовлен к еде, благодаря " + preparator.getName() + "!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DinnerTable that = (DinnerTable) o;
        return isPrepared == that.isPrepared;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isPrepared);
    }

    @Override
    public String toString() {
        return  getClass().getName() + "[" +
                "isPrepared=" + isPrepared +
                ']';
    }
}
