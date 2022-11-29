package places.singlePlaces;

import entities.Entity;
import places.singlePlaces.interfaces.IDinnerTable;

public class DinnerTable extends Table implements IDinnerTable {
    private boolean isPrepared;

    public DinnerTable(String name) {
        super(name);
        isPrepared = false;
    }

    @Override
    public boolean isPrepared() {
        return isPrepared;
    }

    @Override
    public void prepare(Entity preparator) {
        try {
            IDinnerTable.super.prepare(preparator);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        isPrepared = true;
        System.out.println(getName() + " подготовлен к еде, благодаря " + preparator.getName() + "!");
    }
}
