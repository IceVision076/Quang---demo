package test;

import java.util.Random;

/**
 *
 * @author quang
 */
public class test {
    public static void main(String[] args) {
        for (int i = 0; i <100; i++) {
            randomString();
            
        }
    }
    
    public static void randomString() {
 
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 7;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
        int randomLimitedInt = leftLimit + (int) 
          (random.nextFloat() * (rightLimit - leftLimit + 1));
        buffer.append((char) randomLimitedInt);
    }
    String generatedString = buffer.toString();
    System.out.println(generatedString);
}
}
