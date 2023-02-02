import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Output the same when
        // Just rise
        // Only fall
        // No rise No Fall
        // If rise then fall -> 2 parts only
        // If fall then rise -> keep falling
        try (var s = new Scanner(new File("input.txt"));) {
            int n = Integer.parseInt(s.nextLine());

            for (int i=0 ; i<n ; i++) {
                var num = s.nextLine().toCharArray();
                boolean equal = true;
                boolean riseOnly = true;
                boolean fallOnly = true;
                int fallIndex = 0;
                for (int j=1 ; j < num.length ; j++ ) {
                    if (num[j] < num[j-1]) {
                        fallIndex = j;
                        break;
                    }
                }

                if (fallIndex != 0 ){
                    for (int j=fallIndex+1 ; j<num.length; j++) {
                        num[j] = num[fallIndex];
                    }
                }

                System.out.println(String.copyValueOf(num));
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}