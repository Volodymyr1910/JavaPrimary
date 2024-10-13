package MyMethods.array_methods;

public class ArrayMethods {

//// ------------------------------------- Searching in array  ----------------------------------------------

    //finding element, that's different from others; USEFULL when array have many equal elements
    //знаходить елемент який більше або менше інших елементів
    //якщо таких елементів не один - то повертає індекс першого знайденого зліва
    public static int findIndexOfAnotherElement (int  array []) {
        int hereYouAre = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                if (array[i] < array[i - 1]) {
                    hereYouAre = i-1;
                    i = array.length-1;
                }else{
                    hereYouAre = i;
                }//end else
            }//end if
        }//end for
        return hereYouAre;
    }// end findIndexOfAnotherElement

    //переносить всі не парні елементи одного масиву в інший *** число 0 відкидається ***
    //заповнює новий масив зліва на право
    //розмір нового масиву  =  кількості не парних елементів масиву-донора
    public static int[] tranferToNewArrayOnlyOddAutoSize (int[] array) {
        int[] temp = new int[howMuchOddNumbersInArray(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if ((array[i] % 2 > 0) & (array[i] > 0)) {
                temp[j] = array[i];
                j++;
            }//end if
        }//end for
        return temp;
    }// end tranferToNewArrayOnlyOddAutoSize

    //переносить всі парні елементи одного масиву в інший *** число 0 відкидається ***
    //заповнює новий масив зліва на право
    //розмір нового масиву  =  кількості парних елементів масиву-донора
    public static int[] tranferToNewArrayOnlyEvenAutoSize (int[] array) {
        int[] temp = new int[howMuchEvenNumbersInArray(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if ((array[i] % 2 == 0) & (array[i] > 0)) {
                temp[j] = array[i];
                j++;
            }//end if
        }//end for
        return temp;
    }// end tranferToNewArrayOnlyEvenAutoSize

    //Копіює всі позитивні елементи (ті, що більші за нуль) одного масиву і заносить їх в інший
    //індекси скопійованих елементів нового массиву такі самі як індекси цих елементів в старому масиві
    //розмір нового масиву має бути більший за розмір масиву-донора, або такий самий
    public static int[] copyToAnotherArrayOnlyPositive (int[] array, int newArrayLenght) {
        if (newArrayLenght < array.length) {
            newArrayLenght = array.length;
        }//end if
        int temp[] = new int[newArrayLenght];
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            if (array[i] > 0) {
                temp[j] = array[i];
            }//end if
        }//end for
        return temp;
    }//end copyToAnotherArrayOnlyPositive

    //переносить всі позитивні елементи (ті, що більші за нуль) одного масиву і заносить їх в інший
    //заповнює новий масив зліва на право
    //розмір нового масиву  =  кількості позитивних елементів масиву-донора
    public static int[] tranferToNewArrayOnlyPositiveAutoSize (int[] array) {
        int[] temp = new int[howMuchPositiveNumbersInArray(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] > 0) {
                temp[j] = array[i];
                j++;
            }//end if
        }//end for
        return temp;
    }// end tranferToNewArrayOnlyPositiveAutoSize

    // рахує скільки в масиві не парних елементів *** число 0 відкидається ***
    public static int howMuchOddNumbersInArray (int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2 > 0) & (array[i] > 0)) {
                count++;
            }//end if
        }//end for
        return count;
    }//end  howMuchOddNumbersInArray

    // рахує скільки в масиві парних елементів *** число 0 відкидається ***
    public static int howMuchEvenNumbersInArray (int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2 == 0) & (array[i] > 0)) {
                count++;
            }
        }//end for
        return count;
    }//end  howMuchEvenNumbersInArray

    // рахує скільки в масиві негативних елементів
    public static int howMuchNegativeNumbersInArray (int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
            }//end if
        }//end for
        return count;
    }//end  howMuchNegativeNumbersInArray

    // рахує скільки в масиві позитивних елементів
    public static int howMuchPositiveNumbersInArray (int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }//end if
        }//end for
        return count;
    }//end  howMuchPositiveNumbersInArray

    // рахує скільки в масиві нулів
    public static int howMuchZeroInArray (int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                count++;
            }//end if
        }//end for
        return count;
    }//end  howMuchZeroInArray

    //binary search works only with sortirated arrays from high to small
    //O(log(n))  returns index of founded element (if element absent - return "-1")
    public static int binarySearchFromHighToSmall (int[] array, int n) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == n) {
                return middleIndex;
            } else if (n > array[middleIndex]) {
                rightIndex = middleIndex - 1; // отбрасываем правую часть массива
            } else {// если условие не сработало, то искомое число в правой части и нужно отбросить левую часть массива
                leftIndex = middleIndex + 1;
            } //end else if
        }//end while  // index переменная принимающая результат метода binarySearch
        // index = (index > 0) ? index : -index-1; -> готовый ответ, индекс массива, куда ставить искомый элемент
        return -leftIndex - 1; // если элемент не найден, то результат метода покажет на какую позиуию нужно поставить элемент,
        //если захотим искомое число добавить в массив
    }//end binarySearchFromHighToSmall

    //binary search works only with sortirated arrays from low to big
    //O(log(n))  returns index of founded element (if element absent - return "-1")
    public static int binarySearchFromLowToBig (int[] array, int n) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == n) {
                return middleIndex;
            } else if (n < array[middleIndex]) {
                rightIndex = middleIndex - 1; // отбрасываем правую часть массива
            } else {// если условие не сработало, то искомое число в правой части и нужно отбросить левую часть массива
                leftIndex = middleIndex + 1;
            } //end else if
        }//end while // index переменная принимающая результат метода binarySearch
        // index = (index > 0) ? index : -index-1; -> готовый ответ, индекс массива, куда ставить искомый элемент
        return -leftIndex - 1; // если элемент не найден, то результат метода покажет на какую позиуию нужно поставить элемент,
        //если захотим искомое число добавить в массив
    }//end binarySearchFromLowToBig

    //O(n) - чем больше размер массива - тем дольше работает метод, т.к. перебирает каждое значение
    //возвращает индекс первого попавшегося в массиве искомого елемента (ИЩЕТ СПРАВА НАЛЕВО)
    //linear search, returns index of founded element (if element absent - return "-1")
    public static int linearSearchFromEndToStart (int[] array, int n) {
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] == n) {
                return i; // at this moment we go out from the method
            }//end if
        }//end for
        return -1;
    }//end linearSearchFromEndToStart

    //O(n) - чем больше размер массива - тем дольше работает метод, т.к. перебирает каждое значение
    //возвращает индекс первого попавшегося в массиве искомого елемента (ИЩЕТ СЛЕВА НАПРАВО)
    //linear search, returns index of founded element (if element absent - return "-1")
    public static int linearSearchFromStartToEnd (int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return i; // at this moment we go out from the method
            }//end if
        }//end for
        return -1;
    }//end linearSearchFromStartToEnd

    //finding min element in array
    public static int MinElementInAray (int [] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }//end if
        }//end for
        return min;
    }//MinElementInAray

    //finding max element in array
    public static int MaxElementInAray (int [] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }//end if
        }//end for
        return max;
    }//MaxElementInAray

    // ищем в массиве заданное число, а именно индекс его пятого повторения
    // метод находит индекс, на котором искомое число встречается пятый раз
    // если повторений в массиве искомого числа менее 5, то метод вернет последний индекс, где было найдено искомое число
    // если искомого числа нет, вернет -1
    public static int returnFifthIndexOfRepeatedElement (int[] array, int n) {
        int fifthIndex = -1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                fifthIndex = i;
                count++;
                if (count == 5) i = array.length-1;
            }//end if
        }//end for
        return fifthIndex;
    }//returnFifthIndexOfRepeatedElement

    // giving back number from array, which stay in array under selected index
    public static int returnNumberfromArrayUnderSelectedIndex (int[] array, int n) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == n) {
                temp = array[i];
            }//end if
        }//end for
        return temp;
    }//end returnNumberfromArrayUnderSelectedIndex

    //finding index of min element in array
    public static int indexOfMinElementInAray (int [] array) {
        int min = array[0];
        int indexOfMin = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexOfMin = i;
            }//end if
        }//end for
        return indexOfMin;
    }//indexOfMinElementInAray

    //finding index of max element in array
    public static int indexOfMaxElementInAray (int [] array) {
        int max = array[0];
        int indexOfMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexOfMax = i;
            }//end if
        }//end for
        return indexOfMax;
    }//indexOfMaxElementInAray

    // считает сколько искомых элементов есть в массиве
    public static int howMuchTimesFindElement (int[] array, int n) {
        int times = 0;
        int indexOfMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                times++;
            }//end if
        }//end for
        return times;
    }//end howMuchTimesFindElement

    //повертає true якщо в масиві є шукоме число
    public static boolean searchInArrayBoolean (int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return true;
            }//end if
        }//end for
        return false;
    }//end searchInArrayBoolean

//// ------------------------------------- Sorting array ----------------------------------------------------

    //selection sort
    public static void selectionSort ( int array []){
        for (int i = 0; i < array.length; i++) {
            int minElement = array[i];
            int count = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minElement){
                    minElement = array[j];
                    count = j;
                }//end if
            }//for
            if(minElement < array[i]) {
                int temp = array[i];
                array[i] = minElement;
                array[count] = temp;
            }
        }//end for
    }// end selectionSort

    //bublesort сортирует по убыванию и ВОЗВРАЩАЕТ МАССИВ
    //- упорядоченные элементы выключаются из цикла
    public static int[] bubleSortFromHighToSmallWithReturn (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    int temp = array[j];  //if(array[j] < array[j + 1]) изменение знака влияет на сортировку по возрастанию или по убыванию
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
        return array;
    }//end bubleSortFromHighToSmallWithReturn

    //bublesort сортирует по возрастанию и ВОЗВРАЩАЕТ МАССИВ
    //- сравниваем всегда 2 соседних элемента, переставляем их местами, если они расположены не в порядке возрастания
    //- цикл должен идти слева направо
    //- упорядоченные элементы выключаются из цикла
    public static int[] bubleSortFromLowToBigWithReturn (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    int temp = array[j];  //if(array[j] < array[j + 1]) изменение знака влияет на сортировку по возрастанию или по убыванию
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
        return array;
    }//end bubleSortFromLowToBigWithReturn

    //bublesort сортирует по убыванию
    //- упорядоченные элементы выключаются из цикла
    public static void bubleSortFromHighToSmall (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    int temp = array[j];  //if(array[j] < array[j + 1]) изменение знака влияет на сортировку по возрастанию или по убыванию
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
    }//end bubleSortFromHighToSmall

    //bublesort сортирует по возрастанию
    //- сравниваем всегда 2 соседних элемента, переставляем их местами, если они расположены не в порядке возрастания
    //- цикл должен идти слева направо
    //- упорядоченные элементы выключаются из цикла
    public static void bubleSortFromLowToBig (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
    }//end bubleSortFromLowToBig

//// ------------------------------------- Copy or transfer array with CHANGING ARRAY TYPE ------------------

    // make copy elements from one INT ARRAY to another DOUBLE ARRAY
    // розмір нового масиву такий самий як розмір масиву-донора
    public static double[] copyArrayWithChangeIntToDoubleAutoSize (int[] arrayFrom) {
        int u = 0;
        double arrayTo [] = new double[arrayFrom.length];
        for (int i = 0; i < arrayFrom.length; i++) {
            arrayTo[u] = arrayFrom[i];
            u++;
        }
        return arrayTo;
    }//end copyArrayWithChangeIntToDoubleAutoSize

//// ------------------------------------- Copy or transfer array -------------------------------------------

    // метод що розвертає дані в масиві навпаки int[1,2,3] -> int[3,2,1]
    // если размер arrayFrom больше - будет error
    //если размер arrayTo больше -  в нем останутся пустые ячейки или ячейки с его "родными" елементами
    public static int[] transferFromOneArrayToAnotherWithTurnAround (int[] arrayFrom, int[] arrayTo) {
        int u = 0;
        for (int t = arrayFrom.length - 1; t >= 0; t--) {
            arrayTo[u] = arrayFrom[t];
            u++;
        }//end for
        //System.out.println();
        return arrayTo;
    }//end transferFromOneArrayToAnotherWithTurnAround

    //reverseArray
    //step 2 of 2 reverse array
    public static void reverseArray (int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            swap(array, i, j);
        }//end for
    }// end reverseArray

    //step 1 of 2 - method swap вспомагательный метод для метода reverseArray
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }//end swap

    // копіює масив з можливістю вибрати довжину нового масиву
    public static int[] copyOfArray (int[] array, int newLenght) {
        int[] newArray = new int[newLenght];
        int u = 0;
        for (int i = 0; i < array.length; i++) {
            newArray[u] = array[i];
            u++;
        }
        return newArray;
    }//end copyOfArray

//// ------------------------------------- Other operations with array  -------------------------------------




//// ------------------------------------- Total and Average of array  --------------------------------------

    // возвращает сумму всех элементов массива, которые имеют четные индексы
    public static int sumArrayElementsWithEvenIndexes (int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if(i % 2 == 0) {
                res += array[i];
            }//end if
        }//end for
        return res;
    }//sumArrayElementsWithEvenIndexes

    // возвращает сумму всех элементов массива, которые имеют нечетные индексы
    public static int sumArrayElementsWithOddIndexes (int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if(i % 2 > 0) {
                res += array[i];
            }//end if
        }//end for
        return res;
    }//sumArrayElementsWithOddIndexes

    // возвращает сумму всех элементов массива
    public static int sumArray (int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = res + array[i];
        }
        return res;
    }//end sumArray

//// ------------------------------------- Print array ------------------------------------------------------

    //печатает массив
    public static void printArray (int[] array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            n++;
            if (n < array.length) {
                System.out.print("; ");
            }//end if
        }//end for
        System.out.println();
        System.out.println("------------------------------");
    }//end printArray

//// ------------------------------------- Fill array -------------------------------------------------------

    //fill array numbers in range from a to b, ARRAY is GROWING and ARRAY EVEN a
    // a - left border, b - right border, n - automaticaly max (make it as big, as it can be)
    // a must be > 0; if a = b -> array will have only one element
    public static int[] fillGrowingArrayFromAtoBAutoSize (int a, int b) {
        int n = b / a;
        int[] array = new int[n];
        array[0] = a;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + a;
            //array[i] = array[i-1] + array[i];
        }//end for
        return array;
    }//end fillGrowingArrayFromAtoBAutoSize

    //fill array numbers in range from a with election step ARRAY is GROWING
    // a - left border, n - quantity (array size), step - difference between i and i+1
    // if a = step -> all array elements will be even to step
    public static int[] fillGrowingArrayFromAwithElectionStep (int a, int n, int step) {
        int[] array = new int[n];
        array[0] = a;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + step;
        }//end for
        return array;
    }//end fillArrayFromAwithElectionStep

    //fill array, where all ellement are equal
    // n - quantity (array size), element - all numbers in array
    public static int[] fillArrayAllElementsAreEqual (int n, int step) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + step;
        }//end for
        return array;
    }//end fillArrayAllElementsAreEqual

    //fill array random numbers without repetitions
    // a - left border, b - right border, n - quantity (array size)
    // number n can't be higher than right border
    public static int[] fillArrayRandomWithoutRepetitions (int a, int b, int n) {
        int array[] = new int[n];
        for (int i = 0; i < array.length; i++) {
            int temp = (int) (Math.random() * (b - a + 1) + a);
            if (ArrayMethods.searchInArrayBoolean(array, temp) == true) {
                while (ArrayMethods.searchInArrayBoolean(array, temp) == true) {
                    temp = (int) (Math.random() * (b - a + 1) + a);
                    ArrayMethods.searchInArrayBoolean(array, temp);
                }//end while
            }//end if
            array[i] = temp;
        }//end for
        return array;
    }//end fillArrayWithoutRepetitions

    //fill array random numbers
    // a - left border, b - right border, n - quantity (array size)
    public static int[] fillArrayRandom (int a, int b, int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (b - a + 1) + a);
        }//end for
        return array;
    }//end fillArrayRandom


}//end class
