package entities.interfacesAnimateActions;

import things.unitions.ICanUniteable;
import things.unitions.Unition;

public interface IAttachable {
    Unition attach(ICanUniteable... things);
}
