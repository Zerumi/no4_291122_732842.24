package things;

public class SugarStorage extends Thing implements IDestroyable {

    public SugarStorage(String name) {
        super(name);
    }

    @Override
    public void destroy() {
        System.out.println(getName() + " выпала на поверхность и разбилась. Такова была ее судьба(.");
    }
}
