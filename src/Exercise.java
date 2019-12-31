import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise {

    public static int digital_root(int n) {
        List<Integer> listInt = new ArrayList<Integer>();

        while(n> 0){
            listInt.add(n % 10);
            n = n / 10;
        }
        int sum = 0;
        for(Integer i : listInt){
            sum += i;
        }

        int count = 0;
        int numberDigit = sum;
        while(numberDigit  > 0){
            numberDigit /= 10;
            count++;
        }

        if(count == 1){
            return  sum;
        }

        return digital_root(sum);

    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        int result [] = new int [elements.length];
        Map<Integer, Integer> listElements = new HashMap<>();
        for(int i = 0; i < elements.length; i++){
            if(!listElements.containsKey(elements[i])){
                listElements.put(elements[i], 1);
            } else {
                Integer count = listElements.get(elements[i]);
                listElements.replace(elements[i], count++);
            }
        }
        return null;
    }

    public static int persistence(long n) {
        int numberOfDigit = String.valueOf(n).length();
        System.out.println(numberOfDigit);

        int count = 0;

        int number = (int) (long) n;
        while (numberOfDigit > 1){
            List<Integer> listInt = separatedigit(number);
            number = 1;
            for(int i = 0; i < listInt.size(); i++){
                number *= listInt.get(i);
            }

            count++;
            numberOfDigit = String.valueOf(number).length();

        }

       return count;
    }

    public static List<Integer> separatedigit (long n){
        List<Integer> listInt = new ArrayList<>();
        int number = (int) (long) n;
        while(number > 0){
            listInt.add((int) (long) number % 10);
            number = number /10;
        }
        return  listInt;
    }

    public static int persistenceSolution(long n) {
        long m, r =n;
        if(r/10 == 0){
            return 0;
        }

        return 0;
    }

    public static String encrypt(final String text, final int n) {
        if (n <= 0 ){
            return  text;
        }
        int iterate = 1;
        String result = concateString(text);

        if(n > 1){
            while (iterate < n ){
                result = concateString(result);
                iterate++;
            }
        }


        return result;
    }

    public static String concateString(String str){
        char [] textInChar = str.toCharArray();
        int time = 1;

        String result = "";
        for(int i = 0; i < textInChar.length; i++){
            if(i % 2 != 0){
                result += textInChar[i];
            }
        }

        for(int i = 0; i < textInChar.length; i++){
            if(i % 2 == 0){
                result += textInChar[i];
            }
        }
        return  result;
    }
    public static String decrypt(final String encryptedText, final int n) {


        if (n <= 0 ){
            return  encryptedText;
        }
        int iterate = 1;
        String result = concate2(encryptedText);

        if(n > 1){
            while (iterate < n ){
                result = concate2(result);
                iterate++;
            }
        }

        return result;
    }

    public static String concate2(String text){
        char [] textInChar = new char[text.length()];
        int j = 0;
        for(int i =0; i < textInChar.length; i++){
            if(i % 2 != 0){

                textInChar[i] = text.charAt(j);
                j++;
            }
        }

        for(int i =0; i < textInChar.length; i++) {
            if (i % 2 == 0) {
                textInChar[i] = text.charAt(j);
                j++;
            }
        }

        String result = new String(textInChar);

        return result;
    }

}
