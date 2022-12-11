package exceptions.chechedExceptions;

public class TableIsAlreadyPreparedException extends Exception {
    public TableIsAlreadyPreparedException(String message)
    {
        super(message);
        System.out.println("Оказалось, что стол был уже приготовлен...");
    }
}
