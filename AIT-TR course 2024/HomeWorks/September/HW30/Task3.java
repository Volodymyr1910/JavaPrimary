package HW30;

import array_methods.ArrayMethods_String;

//Задание 3 (*). Дано предложение: "В 1800-х годах, в те времена, когда не было еще ни железных, ни шоссейных дорог, ни газового,
// ни стеаринового света, ни пружинных низких диванов, ни мебели без лаку, ни разочарованных юношей со стеклышками, ни либеральных философов-женщин,
// ни милых дам-камелий, которых так много развелось в наше время, – в те наивные времена, когда из Москвы, выезжая в Петербург в повозке или карете,
// брали с собой целую кухню домашнего приготовления, ехали восемь суток по мягкой, пыльной или грязной дороге и верили в пожарские котлеты,
// в валдайские колокольчики и бублики, – когда в длинные осенние вечера нагорали сальные свечи, освещая семейные кружки из двадцати и тридцати человек,
// на балах в канделябры вставлялись восковые и спермацетовые свечи, когда мебель ставили симметрично,
// когда наши отцы были еще молоды не одним отсутствием морщин и седых волос, а стрелялись за женщин и из другого угла комнаты бросались поднимать нечаянно и
// не нечаянно уроненные платочки, наши матери носили коротенькие талии и огромные рукава и решали семейные дела выниманием билетиков,
// когда прелестные дамы-камелии прятались от дневного света, – в наивные времена масонских лож, мартинистов, тугендбунда, во времена Милорадовичей,
// Давыдовых, Пушкиных, – в губернском городе К. был съезд помещиков, и кончались дворянские выборы.";
//
//Напишите метод, который отвечает на вопрос сколько слов в этом предложении. Обратите внимание, что тире не является словом.
// Подсчитайте, сколько букв (не символов!) в этом предложении.
public class Task3 {
    public static void main(String[] args) {

        String str = "В 1800-х годах, в те времена, когда не было еще ни железных, ни шоссейных дорог, ни газового, ни стеаринового света, ни пружинных низких диванов, ни мебели без лаку, ни разочарованных юношей со стеклышками, ни либеральных философов-женщин, ни милых дам-камелий, которых так много развелось в наше время, – в те наивные времена, когда из Москвы, выезжая в Петербург в повозке или карете, брали с собой целую кухню домашнего приготовления, ехали восемь суток по мягкой, пыльной или грязной дороге и верили в пожарские котлеты, в валдайские колокольчики и бублики, – когда в длинные осенние вечера нагорали сальные свечи, освещая семейные кружки из двадцати и тридцати человек, на балах в канделябры вставлялись восковые и спермацетовые свечи, когда мебель ставили симметрично, когда наши отцы были еще молоды не одним отсутствием морщин и седых волос, а стрелялись за женщин и из другого угла комнаты бросались поднимать нечаянно и не нечаянно уроненные платочки, наши матери носили коротенькие талии и огромные рукава и решали семейные дела выниманием билетиков, когда прелестные дамы-камелии прятались от дневного света, – в наивные времена масонских лож, мартинистов, тугендбунда, во времена Милорадовичей, Давыдовых, Пушкиных, – в губернском городе К. был съезд помещиков, и кончались дворянские выборы.";
        // убираем запятые, точки, междусловные тире
        String withoutKomma = str.replace(",","");
        String withoutKommaNotInWordsDash = withoutKomma.replace(" – "," ");
        System.out.println(withoutKommaNotInWordsDash);
        String withoutKommaNotInWordsDashPoint = withoutKommaNotInWordsDash.replace(".","");
        System.out.println(withoutKommaNotInWordsDashPoint);

        //определяем строку в массив пословно
         String howMuchWordsInSentenceArray [] = withoutKommaNotInWordsDashPoint.split(" ");
        ArrayMethods_String.printArrayString(howMuchWordsInSentenceArray);

        // длина массива - это количество слов
        int howMuchWordsInSentence = howMuchWordsInSentenceArray.length;


        //убираем внутрисловные тире, цифры, и пробелы
        String withoutAllDashKommaPoint = withoutKommaNotInWordsDashPoint.replace("-","");
        String withoutAllDashKommaPointNumbers1 = withoutAllDashKommaPoint.replace("1","");
        String withoutAllDashKommaPointNumbers18 = withoutAllDashKommaPointNumbers1.replace("8","");
        String withoutAllDashKommaPointAllNumbers = withoutAllDashKommaPointNumbers18.replace("0","");
        String withoutAllDashKommaPointAllNumbersSpace = withoutAllDashKommaPointAllNumbers.replace(" ","");
        System.out.println("-----------test---------");

        // длина строки - это количество букв
        int howMuchLettersInSentence = withoutAllDashKommaPointAllNumbersSpace.length();

        System.out.println("We have " + howMuchWordsInSentence + " words, and " + howMuchLettersInSentence + " letters in our sentence." );
    }//end main
}//end class
