package story.actions;

import entities.Entity;
import places.singlePlaces.interfaces.IDinnerTable;

public class PreparingDinnerTable extends Action {

    IDinnerTable table;

    public PreparingDinnerTable(IDinnerTable table, Entity who) {
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
