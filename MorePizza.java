import java.util.*;
import java.io.*;

public class MorePizza {
    class Pizza {
        Pizza previousOrderChoice;
        int minSliceCount;
        int maxSliceCount;
        List<Integer> Slice;
    
        Pizza(int minSliceCount,int maxSliceCount,List<Integer> Slice){
            this.minSliceCount = minSliceCount;
            this.maxSliceCount = maxSliceCount;
            this.Slice = new ArrayList<Integer>();
            for(int i: Slice){
                this.Slice.add(i);
            }
        }
    }

    public Pizza selectedPizza;
    public static int minVal;
    public static int maxVal;
    public static List<Integer> combinationIndex;
    public void addPizza(int minSliceCount, int maxSliceCount, List<Integer> Slice) 
    { 
        Pizza newPizza = new Pizza(minSliceCount, maxSliceCount,Slice); 
        newPizza.previousOrderChoice = selectedPizza; 
        selectedPizza = newPizza; 
    }
    public void printList() 
    { 
        Pizza tempPizza = selectedPizza; 
        while (tempPizza != null) 
        { 
            System.out.println("Min: "+tempPizza.minSliceCount); 
            System.out.println("Max: "+tempPizza.maxSliceCount);
            System.out.println("Slice: "+tempPizza.Slice.toString());
            tempPizza = tempPizza.previousOrderChoice;
        } 
    }

    public void printLast(){
        Pizza tempPizza = selectedPizza;
        System.out.println(tempPizza.Slice.size());
        int index = 1;
        for(int i: tempPizza.Slice){
            if(index == tempPizza.Slice.size()){
                System.out.print(i);
            }else{
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        int maxSlice = 17;
        int max = 4;
        int pizzaArray[] = {2, 5, 6, 8};
        MorePizza tempPizza = new MorePizza();
        
        for(int pizzaToBuy = 1; pizzaToBuy <= max; pizzaToBuy++){
            int i;
        for(i = 0; i<pizzaArray.length; i++){		    
                List<Integer> combinations = new ArrayList<Integer>();
                combinations.add(i);
                findNextCombinationDigits(pizzaArray.length,pizzaToBuy,combinations,pizzaArray,tempPizza,maxSlice);
        }
        List<Integer> tempCombinationIndex = new ArrayList<Integer>();
        for(int index1: combinationIndex){
            tempCombinationIndex.add(index1);
        }
        tempPizza.addPizza(minVal,maxVal,tempCombinationIndex);
        }
        //tempPizza.printList();
        tempPizza.printLast();
    }

    public static void findNextCombinationDigits(int totalPizza, int maxCombination, List<Integer> combinations,int[] pizzaArray, MorePizza tempPizza, int maxSlice){
        if(combinations.size() == maxCombination){
            int sum = 0;
            for(int index : combinations){
                sum+= pizzaArray[index];
            }
            if(minVal==0){
                minVal = sum;
            }else{
                if(minVal > sum){
                    minVal = sum;
                }
            }
            if(maxVal==0){
                if(sum<maxSlice){
                    maxVal = sum;
                    combinationIndex = new ArrayList<Integer>();
                    for(int i: combinations){
                        combinationIndex.add(i);
                    }
                }
            }else{
                if(maxVal < sum && sum <= maxSlice){
                    maxVal = sum;
                    combinationIndex = new ArrayList<Integer>();
                    for(int i: combinations){
                        combinationIndex.add(i);
                    }
                }
            }
        }
        if(combinations.size() <= maxCombination && maxCombination <= totalPizza){
            int lastCombinationDigit = combinations.get(combinations.size()-1);
            for(int k = lastCombinationDigit; k<totalPizza; k++){
                if(k!=lastCombinationDigit){
                    combinations.add(k);
                    findNextCombinationDigits(totalPizza, maxCombination, combinations,pizzaArray,tempPizza,maxSlice);
                    combinations.remove(combinations.size()-1);
                }
            }
        }
    }
}