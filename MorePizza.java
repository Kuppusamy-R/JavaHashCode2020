import java.util.*;

public class MorePizza {
    public static void main(String[] args) {
        int maxSlice = 17;
		int pizzaToBuy = 4;
		int pizza[] = {2,5,6,8};
        int min,max,i,j,k;
        int temp[] = {};
		for(i = 0; i<pizza.length; i++){		    
            //temp = Arrays.copyOfRange(pizza, 0, pizzaToBuy);
            for(j = i; j<pizza.length; j++ ){
                if(i!=j){
                    //findNextCombinationDigit(pizza.length,pizzaToBuy,new int[]{i,j});
                    List<Integer> combinations = new ArrayList<Integer>();
                    combinations.add(i);
                    combinations.add(j);
                    //System.out.println("Starts..");
                    //System.out.println(combinations.toString());
                    //System.out.println("Calling..");
                    findNextCombinationDigits(pizza.length,pizzaToBuy,combinations);
                }
            }
            //System.out.println(Arrays.toString(temp));
        }        
    }

    public static void findNextCombinationDigit(int totalPizza, int maxCombination, int[] combinations ){
        System.out.println(combinations.toString());
        int lastCombinationDigit = combinations[combinations.length-1];
        for(int k = lastCombinationDigit; k<totalPizza; k++){
            if(k!=lastCombinationDigit){
                System.out.println(Arrays.toString(combinations)+","+k);
            }
        }
    }

    public static void findNextCombinationDigits(int totalPizza, int maxCombination, List<Integer> combinations ){
        //System.out.println(maxCombination+","+combinations.size());
        if(combinations.size() <= maxCombination){
            int lastCombinationDigit = combinations.get(combinations.size()-1);
            //System.out.println("Total: "+totalPizza);
            for(int k = lastCombinationDigit; k<totalPizza; k++){
                if(k!=lastCombinationDigit){
                    combinations.add(k);
                    //System.out.println("Last: "+lastCombinationDigit);
                    System.out.println(combinations.toString());
                    System.out.println("calling itself");
                    findNextCombinationDigits(totalPizza, maxCombination, combinations);
                    combinations.remove(combinations.size()-1);
                }
            }
        }else{
            System.out.println("Printing output");
            System.out.println(combinations.toString());
        }
    }

    int[] swap(int[] arr, int src, int des){
        int temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
        return arr;
    }
}

class Pizza {
    public Pizza previousOrderChoice;
    public int minSliceCount;
    public int maxSliceCount;
    public int Slice[];
}