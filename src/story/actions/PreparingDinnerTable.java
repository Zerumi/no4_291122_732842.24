package story.actions;

import entities.Entity;
import places.singlePlaces.DinnerTable;

public class PreparingDinnerTable extends Action {

    DinnerTable table;

    public PreparingDinnerTable(DinnerTable table, Entity who) {
        super("подготовка " + table.getName() + " к еде", who);
        this.table = table;
    }

    @Override
    public void invokeAction() {
        try {
            table.prepare(getActor());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
