//  3. Try enable and disable JIT and checkout the results (Write a bubble sort program to sort 10000 numbers with and without JIT!)

import java.util.Random;

public class BubbleSort
{
    public static void main(String[] args)
    {

        Random rgen = new Random();  // Random number generator
        int[] nums = new int[10000];  //array to store 10000 random integers (1-10,000)

        //--- Initialize the array to the ints 1-10,000
        for (int i=0; i<nums.length; i++) {
            nums[i] = i;
        }

        //--- Shuffle by exchanging each element randomly
        for (int i=0; i<nums.length; i++) {
            int randomPosition = rgen.nextInt(nums.length);
            int temp = nums[i];
            nums[i] = nums[randomPosition];
            nums[randomPosition] = temp;
        }

        //Print results
        for (int i = 0; i < nums.length; i++){
        System.out.println(nums[i]);
        System.out.println("\n");
    }
}
}