import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;
/**
 * Created by John on 11/9/2015.
 */
public class PropertiesTest {


    public ArrayList<ArrayList<Integer>> createRandomArrays(){
        Random rand = new Random();
        ArrayList<ArrayList<Integer>> listOfArrays = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            int len = rand.nextInt(1000);//make an array of up to 1000 values
            ArrayList<Integer> arrToAdd = new ArrayList<>();
            for (int z = 0; z < len; z ++){
                arrToAdd.add(rand.nextInt(1000));
            }
            listOfArrays.add(arrToAdd);
        }

        return listOfArrays;
    }

    @Test
    public void testPropertyIncrements(){
        ArrayList<ArrayList<Integer>> randomArrays;
        randomArrays = createRandomArrays();
        int invalidArrayCount = 0;
        for(ArrayList<Integer> array : randomArrays){

            Properties.badInterviewSort(array);
            int prev = array.get(0);
            for(int i = 0; i < array.size(); i++){
                if(prev > array.get(i)){
                    invalidArrayCount++;
                }
            }

        }
        assertEquals(invalidArrayCount, 0);
    }

    @Test
    public void testPropertyLength(){
        ArrayList<ArrayList<Integer>> randomArrays;
        randomArrays = createRandomArrays();
        int invalidArrayCount = 0;
        for(ArrayList<Integer> array : randomArrays){
            int prevSize = array.size();
            Properties.badInterviewSort(array);
            int postSize = array.size();

            if(prevSize != postSize){
                invalidArrayCount ++;
            }

        }
        assertEquals(invalidArrayCount, 0);

    }

    @Test
    public void testPropertySameAmountOfEachNumber(){
        ArrayList<ArrayList<Integer>> randomArrays;
        randomArrays = createRandomArrays();
        int invalidArrayCount = 0;
        for(ArrayList<Integer> array : randomArrays){
            HashMap<Integer, Integer> prevCount= new HashMap<>();

            for(int i = 0; i < array.size(); i++){
                if(prevCount.containsKey(i)){
                    prevCount.put(i, prevCount.get(i) + 1);
                }
                prevCount.put(i, 1);
            }

            Properties.badInterviewSort(array);
            HashMap<Integer, Integer> postCount= new HashMap<>();

            for(int i = 0; i < array.size(); i++){
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