package recursion.subsetstring;
public class SkipCharacter {
    public static void main(String[] args) {
        String str = "baccad";
        char letter = 'a';

//        String output = removeSpecifiedLetter(str, letter);
        String output = singleFunc(str, letter);
        System.out.println(output);
    }

    private static String singleFunc(String str, char letter) {

        if(str.isEmpty()) return str;

        if(str.charAt(0) != letter) {
            return str.charAt(0) + singleFunc(str.substring(1), letter);
        }
        return singleFunc(str.substring(1), letter);
    }
    private static String removeSpecifiedLetter(String str, char letter) {
        StringBuilder sb = new StringBuilder();
        return fun(str, letter, sb, 0);
    }

    private static String fun(String str, char letter, StringBuilder sb, int i) {

        if(i == str.length()) return sb.toString();

        if(str.charAt(i) != letter) {
            sb.append(str.charAt(i));
        }
        return fun(str, letter, sb, i+1);
    }
}
