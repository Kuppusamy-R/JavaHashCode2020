import java.util.*;

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
            System.out.println(Slice.toString()+"income");
            for(int i: Slice){
                this.Slice.add(i);
            }
            System.out.println(this.Slice.toString()+"constructor");
    
        }
    }

    class PizzaCombination {
        List<Integer> combination;
        PizzaCombination next;
        PizzaCombination(List<Integer> combination){
            this.combination = combination;
        }
    }

    public Pizza selectedPizza;
    public PizzaCombination selectedPizzaCombination;
    public static int minVal;
    public static int maxVal;
    public static List<Integer> combinationIndex;
    public void addPizzaCombination(List<Integer> combination){
        PizzaCombination newPizzaCombination = new PizzaCombination(combination);
        newPizzaCombination.next = selectedPizzaCombination;
        selectedPizzaCombination = newPizzaCombination;
    }

    public void addPizza(int minSliceCount, int maxSliceCount, List<Integer> Slice) 
    { 
        System.out.println(Slice.toString()+" add pizza");
        Pizza newPizza = new Pizza(minSliceCount, maxSliceCount,Slice); 
        newPizza.previousOrderChoice = selectedPizza; 
        selectedPizza = newPizza; 
    }
    public void printPizzaCombinationList(){
        PizzaCombination tempPizzaCombination = selectedPizzaCombination;
        while( tempPizzaCombination != null){
            System.out.println(tempPizzaCombination.combination.toString());
            tempPizzaCombination = tempPizzaCombination.next;
        }
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
    public static void main(String[] args) {
        MorePizza tempPizza= new MorePizza();
        
        //int maxSlice = 17;
        //int pizzaArray[] = {2,5,6,8};

        int maxSlice = 100;
        int pizzaArray[] = {4, 14, 15, 18, 29, 32, 36, 82, 95, 95};
        int max = 3;
        for(int pizzaToBuy = 1; pizzaToBuy <= max; pizzaToBuy++){
            int i;
        for(i = 0; i<pizzaArray.length; i++){		    
                List<Integer> combinations = new ArrayList<Integer>();
                combinations.add(i);
                findNextCombinationDigits(pizzaArray.length,pizzaToBuy,combinations,pizzaArray,tempPizza,maxSlice);
        }
        System.out.println("Min: "+minVal);
        System.out.println("Max: "+maxVal);
        System.out.println("Index: "+combinationIndex.toString());
        List<Integer> tempCombinationIndex = new ArrayList<Integer>();
        for(int index: combinationIndex){
            tempCombinationIndex.add(index);
        }
        System.out.println(tempCombinationIndex.toString()+"tempCom main");
        tempPizza.addPizza(minVal,maxVal,tempCombinationIndex);
        }
        System.out.println("Printing List..");
        tempPizza.printList();
    }

    public static void findNextCombinationDigits(int totalPizza, int maxCombination, List<Integer> combinations,int[] pizzaArray, MorePizza tempPizza, int maxSlice){
        if(combinations.size() == maxCombination){
            System.out.println(combinations.toString());
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

            //tempPizza.addPizzaCombination(combinations);
            //tempPizza.printPizzaCombinationList();

            //combinationList.add(combinations);
            //System.out.println(combinationList.toString());
            //return combinations;
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