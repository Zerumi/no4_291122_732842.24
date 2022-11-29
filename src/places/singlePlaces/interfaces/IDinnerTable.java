package places.singlePlaces.interfaces;

import entities.Entity;
import exceptions.chechedExceptions.DinnerTableIsAlreadyPreparedException;

public interface IDinnerTable {

    String getName();
    boolean isPrepared();

    default void prepare(Entity preparator) throws DinnerTableIsAlreadyPreparedException {
        if (isPrepared())
        {
            throw new DinnerTableIsAlreadyPreparedException("Стол уже приготовлен для трапезы!");
        }
    }
}
