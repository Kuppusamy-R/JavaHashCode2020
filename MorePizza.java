import java.util.*;

public class MorePizza {
    class Pizza {
        Pizza previousOrderChoice;
        int minSliceCount;
        int maxSliceCount;
        int Slice[];
    
        Pizza(int minSliceCount,int maxSliceCount,int[] Slice){
            this.minSliceCount = minSliceCount;
            this.maxSliceCount = maxSliceCount;
            this.Slice = Slice;
    
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
    public void addPizzaCombination(List<Integer> combination){
        PizzaCombination newPizzaCombination = new PizzaCombination(combination);
        newPizzaCombination.next = selectedPizzaCombination;
        selectedPizzaCombination = newPizzaCombination;
    }

    public void addPizza(int minSliceCount, int maxSliceCount, int[] Slice) 
    { 
        Pizza newPizza = new Pizza(minSliceCount, maxSliceCount, Slice); 
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
            tempPizza = tempPizza.previousOrderChoice;
        } 
    }
    public static void main(String[] args) {
        MorePizza tempPizza= new MorePizza();
        int pizza[] = {2,5,6,7,8,9,0};
        tempPizza.addPizza(1,2,pizza);
        tempPizza.addPizza(2,2,pizza);
        tempPizza.printList();
        System.out.println();
        
        int maxSlice = 17;
        int pizzaArray[] = {2,5,6,7,8,9,0};
		int pizzaToBuy = 3;
		
        int i;
        for(i = 0; i<pizzaArray.length; i++){		    
                List<Integer> combinations = new ArrayList<Integer>();
                combinations.add(i);
                findNextCombinationDigits(pizzaArray.length,pizzaToBuy,combinations,pizzaArray,tempPizza);
        }
        System.out.println("Printing Combinations...");
        //tempPizza.printPizzaCombinationList();

        // for(List<Integer> temp : combinationList){
        //     System.out.println(temp.toString());
        // }
    }

    public static void findNextCombinationDigits(int totalPizza, int maxCombination, List<Integer> combinations,int[] pizzaArray, MorePizza tempPizza){
        if(combinations.size() == maxCombination){
            System.out.println(combinations.toString());
            tempPizza.addPizzaCombination(combinations);
            tempPizza.printPizzaCombinationList();
            //combinationList.add(combinations);
            //System.out.println(combinationList.toString());
            //return combinations;
        }
        if(combinations.size() <= maxCombination && maxCombination <= totalPizza){
            int lastCombinationDigit = combinations.get(combinations.size()-1);
            for(int k = lastCombinationDigit; k<totalPizza; k++){
                if(k!=lastCombinationDigit){
                    combinations.add(k);
                    findNextCombinationDigits(totalPizza, maxCombination, combinations,pizzaArray,tempPizza);
                    combinations.remove(combinations.size()-1);
                }
            }
        }
    }
}