package exceptions.chechedExceptions;

public class DinnerTableIsAlreadyPreparedException extends Exception {
    public DinnerTableIsAlreadyPreparedException(String message)
    {
        super(message);
        System.out.println("Оказалось, что стол был уже приготовлен...");
    }
}
