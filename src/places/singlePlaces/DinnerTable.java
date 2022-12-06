package places.singlePlaces;

import entities.Entity;
import exceptions.chechedExceptions.DinnerTableIsAlreadyPreparedException;

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
                throw new DinnerTableIsAlreadyPreparedException("Стол уже приготовлен для трапезы!");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        isPrepared = true;
        System.out.println(getName() + " подготовлен к еде, благодаря " + preparator.getName() + "!");
    }
}
