
/**
 * Write a description of Part2 here.
 * Program to find the number of times stringa is present in stringb.
 */
public class Part2 {
    public int howMany(String stringa, String stringb) {
        int count = 0;
        int startIndex = stringb.indexOf(stringa);
        if(startIndex == -1) {
            return count;
        }
        while(true) {
           startIndex = stringb.indexOf(stringa,startIndex+stringa.length());
           count++;
           if(startIndex == -1) {
               break;
            }
        }
        return count;
    }

    public void testHowMany() {
        System.out.println(howMany("AAA","manAAAvi"));
    }
}
