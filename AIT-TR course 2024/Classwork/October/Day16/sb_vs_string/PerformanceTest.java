package Day16.sb_vs_string;
// 100 000 раз сказать "Meow"
// String versus StringBuilder
public class PerformanceTest {
    private static  final int N_ITERATION = 100_000;
    private static final String WORD = "Meow";


    public static void main(String[] args) {

        System.out.println("----------String----------");
        long t1 = System.currentTimeMillis(); // включаем секундомер
        String str = "";
        for (int i = 0; i < N_ITERATION; i++) {
            str = str + WORD;
            //System.out.println(WORD);
        }//end for
        long t2 = System.currentTimeMillis(); // выключаем секундомер
        System.out.println("Time String = " + (t2 - t1));

        System.out.println("----------StringBuilder----------");
         t1 = System.currentTimeMillis(); // включаем секундомер
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < N_ITERATION; i++) {
            sb = sb.append(WORD);
        }//end for
        t2 = System.currentTimeMillis(); // выключаем секундомер
        System.out.println("Time String Builder = " + (t2 - t1));

    }//end main



}//end main
