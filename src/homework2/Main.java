package homework2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    final static int COUNT = 8;
    public static void main(String[] args) {
        //Задание 1
        String[] varieties = {"Зелёная", "Красная", "Белая"};//создаём массив видов яблонь

        int[] counts = new int[COUNT];//создаём массив количества яблок на дереве

        //заполняем массив рандомными значениями
        for (int i = 0; i < COUNT; i++){
            counts[i] = (int)(Math.random() * 10) + 1;
        }

        //создаём сад
        Apple[] garden = new Apple[5];
        for(int i = 0; i < garden.length; i++) {
            garden[i] = new Apple(varieties[(int)(Math.random() * varieties.length)], counts[(int)(Math.random() * counts.length)]);
        }

        long a = System.nanoTime();//начало подсчёта времени выполнения алгоритма
        System.out.println("Созданный сад " + Arrays.toString(garden));//посмотрим на получившиеся сад
        long b = System.nanoTime();//конец подсчёта времени
        long c = b - a;
        System.out.printf("%nМетод для печатания массива затратил %d мс", c / 1000000);

        //создадим ещё один сад, пересадив несколько деревьев
        long a1 = System.nanoTime();//начало подсчёта времени выполнения алгоритма
        Apple[] newGarden = Arrays.copyOf(garden, garden.length);
        long b1 = System.nanoTime();//конец подсчёта времени
        long c1 = b1 - a1;
        System.out.printf("%nМетод для копирования массива затратил %d нс%n", c1);
        System.out.println("Новый сад " + Arrays.toString(newGarden));

        //сравним два массива
        long a2 = System.nanoTime();//начало подсчёта времени выполнения алгоритма
        System.out.println("Равны ли два массива " + Arrays.equals(garden, newGarden));
        long b2 = System.nanoTime();//конец подсчёта времени
        long c2 = b2 - a2;
        System.out.printf("Метод для сравнения двух массивов затратил %d мс", c2 / 1000000);

        //отсортируем сад по количеству деревьев
        long a3 = System.nanoTime();//начало подсчёта времени выполнения алгоритма
        Arrays.sort(garden, Comparator.comparingInt(Apple::getCount));
        long b3 = System.nanoTime();//конец подсчёта времени
        long c3 = b3 - a3;
        System.out.printf("%nМетод для сортировки массива затратил %d мс%n", c3 / 1000000);
        System.out.println("Сортированный сад " + Arrays.toString(garden));

        //Задание2
        //линейный поиск(поиск в саду деревьев с количеством яблок равном 8)
        System.out.printf("%nЛинейный поиск%n");
        long a4 = System.nanoTime();//начало подсчёта времени выполнения алгоритма
        for (Apple tree:newGarden){
            if(tree.getCount() == 8){
                System.out.printf("Количество яблок равное 8 на: %s%n", tree);
                break;
            }
        }
        long b4 = System.nanoTime();//конец подсчёта времени
        long c4 = b4 - a4;
        System.out.printf("Время линейного поиска %d нс%n%n", c4);

        //двоичный поиск
        System.out.println("Двоичный поиск");
        long a5 = System.nanoTime();//начало подсчёта времени выполнения алгоритма
        binarySearch(garden, 8);
        long b5 = System.nanoTime();//конец подсчёта времени
        long c5 = b5 - a5;
        System.out.printf("Время двоичного поиска %d нс%n%n", c5);
        /*
        Двоичный поиск быстрее линейного. При линейном поиске 75600 нс, а при двоичном 69600 нс. Но, если в массиве нет указанного элемента,
        то двоичный поиск затратит больше времени, пытаясь найти элемент. Также, скорость зависит от индекса элемента в массиве.
         */

        //Задание3.
        int[] massive = new int[400];
        for (int i = 0; i < massive.length; i++){
            massive[i] = (int)(Math.random()*43);
        }

        int[] newMassive = Arrays.copyOf(massive, massive.length);
        long a6 = System.nanoTime();
        Arrays.sort(massive);
        System.out.println("Время сортировки методом sort 400 элементов " + (System.nanoTime() - a6) + " нс");

        //Задание4.
        //сортировка пузырьком
        long a7 = System.nanoTime();
        SortMethods methodSort = new SortMethods(newMassive);
        methodSort.bubbleSort();
        int[] newSortedMassiveBubbleSort = Arrays.copyOf(methodSort.getA(), methodSort.getA().length);
        System.out.println("Время сортировки методом пузырька 400 элементов " + (System.nanoTime() - a7) + " нс");
        //Время сортировки метод пузырька больше, чем методом sort из библиотеки Arrays.

        //Задание5.
        //сортировка методом выбора
        long a8 = System.nanoTime();
        SortMethods methodSort1 = new SortMethods(newMassive);
        methodSort1.selectionMethod();
        int[] newSortedMassiveSelectionSort = Arrays.copyOf(methodSort1.getA(), methodSort1.getA().length);
        System.out.println("Время сортировки методом выбора 400 элементов " + (System.nanoTime() - a8) + " нс");
        /*
        Время сортировки методом выбора меньше, чем методом пузырька, но всё ещё больше, чем встроенным в библиотеку
        Arrays метода sort.
        */

        //Задание6.
        //сортировка методом вставки
        long a9 = System.nanoTime();
        SortMethods methodSort2 = new SortMethods(newMassive);
        methodSort2.insertMethod();
        int[] newSortedMassiveInsertSort = Arrays.copyOf(methodSort2.getA(), methodSort2.getA().length);
        System.out.println("Время сортировки методом вставки 400 элементов " + (System.nanoTime() - a9) + " нс");
        /*
        Сортировка методом вставки - лучшая из элементарных методов, но метод sort в библиотеке Arrays по прежнему
        имеет лучшие показатели по времени.
         */
    }

    public static void binarySearch(Apple[] arr, int key){
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex)/2;

            if(arr[middleIndex].getCount() == key){
                System.out.println("Количество яблок равное 8 на:" + arr[middleIndex]);
                return;
            }else if(arr[middleIndex].getCount() < key){
                firstIndex = middleIndex + 1;
            }else if(arr[middleIndex].getCount() > key){
                lastIndex = middleIndex - 1;
            }
        }
        System.out.println("Нет таких деревьев");
    }
}
