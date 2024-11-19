package Day16.string_builder;

public class StringBuilderApplication {

    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder("Java");
        System.out.println(sb);

        sb.append("_").append("v.21");
        System.out.println(sb);

        sb.reverse(); //разворот строки задом наперед
        System.out.println(sb);

        //вставка в нужное место
        StringBuilder sbNew = new StringBuilder("Hello");
        sbNew.insert(5, "!"); //указывает индекс, куда поствить
        System.out.println(sbNew);

        sbNew.append(true);
        System.out.println(sbNew);


}//end main



}//end class
