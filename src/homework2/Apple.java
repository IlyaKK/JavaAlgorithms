package homework2;

public class Apple{
    private final String name;//создаём ссылочную переменную
    protected int count;//создаём переменную примитивного типа

    //конструктор для создания объекта яблони
    public Apple(String name, int count) {
        this.name = name;
        this.count = count;
    }

    //метод отображения данных
    @Override
    public String toString() {
        return "Яблоня{" +
                "Название='" + name + '\'' +
                ", Количество=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }
}
