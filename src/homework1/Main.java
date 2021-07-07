package homework1;

public class Main {
    public static void main(String[] args) {
        //создаём яблони
        Apple tree1 = new Apple("Зелёная", 3);
        Apple tree2 = new Apple("Красная", 4);
        Apple tree3 = new Apple("Белая", 5);

        //создаём массив яблонь
        Apple[] trees = {tree1, tree2, tree3};

        //порог количества деревьев
        final int COUNT = 4;

        //итерируемся по массиву деревьев и выводим информацию о яблоне, подходящей под условие
        long start = System.nanoTime();//начало подсчёта времени выполнения алгоритма
        for (Apple tree:trees){
            if(tree.getCount() >= COUNT) {
                System.out.println(tree);
            }
        }
        long finish = System.nanoTime();//конец подсчёта времени
        long elapsed = finish - start;
        System.out.printf("Алгоритм затратил %d мс", elapsed / 1000000);
    }
}
