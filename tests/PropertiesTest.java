import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;
/**
 * Created by John on 11/9/2015.
 */
public class PropertiesTest {

    //this helper function creates random arrays to sort
    public ArrayList<int[]> createRandomArrays(){
        Random rand = new Random();
        ArrayList<int[]> listOfArrays = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            int len = rand.nextInt(1000);//make an array of up to 1000 values
            int[] arrToAdd = new int[len];
            for (int z = 0; z < len; z ++){
                arrToAdd[z] = rand.nextInt(1000);
            }
            listOfArrays.add(arrToAdd);
        }

        return listOfArrays;
    }

    //this tests that every subsequent value in the list is an increment of the previous
    @Test
    public void testPropertyIncrements(){
        ArrayList<int[]> randomArrays;
        randomArrays = createRandomArrays();
        int invalidArrayCount = 0;
        for(int[] array : randomArrays){

            Properties.badInterviewSort(array);
            int prev = array[0];
            for(int i = 0; i < array.length; i++){
                if(prev > array[i]){
                    invalidArrayCount++;
                }
            }

        }
        assertEquals(invalidArrayCount, 0);
    }

    //this tests that the sort maintains the length of each list
    @Test
    public void testPropertyLength(){
        ArrayList<int[]> randomArrays;
        randomArrays = createRandomArrays();
        int invalidArrayCount = 0;
        for(int[] array : randomArrays){
            int prevSize = array.length;
            Properties.badInterviewSort(array);
            int postSize = array.length;

            if(prevSize != postSize){
                invalidArrayCount ++;
            }

        }
        assertEquals(invalidArrayCount, 0);

    }

    //This tests that the sort maintains the same quantity of each number in the list
    @Test
    public void testPropertySameAmountOfEachNumber(){
        ArrayList<int[]> randomArrays;
        randomArrays = createRandomArrays();
        int invalidArrayCount = 0;
        for(int[] array : randomArrays){
            HashMap<Integer, Integer> prevCount= new HashMap<>();

            for(int i = 0; i < array.length; i++){
                if(prevCount.containsKey(i)){
                    prevCount.put(i, prevCount.get(i) + 1);
                }
                prevCount.put(i, 1);
            }

            Properties.badInterviewSort(array);
            HashMap<Integer, Integer> postCount= new HashMap<>();

            for(int i = 0; i < array.length; i++){
                if(postCount.containsKey(i)){
                    postCount.put(i, postCount.get(i)+1);
                }
                postCount.put(i, 1);
            }

            if(!prevCount.equals(postCount)){
                invalidArrayCount++;
            }

        }
        assertEquals(invalidArrayCount, 0);
    }
}