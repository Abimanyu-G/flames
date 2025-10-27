
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class flames{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner mc = new Scanner(System.in);
        System.out.println("Enter the Name one: ");
        String name1 = sc.nextLine();
        System.out.println("Enter the Name two: ");
        String name2 = mc.nextLine();
        

        //removing the empty space and convert to lower case for efficiency
        String n1 = name1.replaceAll(" ", "").toLowerCase();
        String n2 = name2.replaceAll(" ", "").toLowerCase();
        
        //traversing a name input
        for(int i = 0; i<n1.length();i++){
            char c = n1.charAt(i);  //inputing each letter to a character
            int index = n2.indexOf(c); //getting the index of the letter if the same is in second name too

            if(index != -1){ //if found
            //removing the character/letter from both strings 
                n1 = n1.substring(0, i) + n1.substring(i+1);
                n2 = n2.substring(0, index) + n2.substring(index + 1);
                i--;  //adjusting the index to left since a letter will be gone
            }
        }

        String combined = n1+n2;
        int count = combined.length();
        
        //adding flames to a list
        List<String> flames = new ArrayList<>(
                Arrays.asList("Friends", "Love", "Affection", "Marriage", "Enemies", "Siblings")
        );
        
        //looping
        while(flames.size() >1){

            //split index that would point the flames to remove
             int splitIndex = (count % flames.size())-1;
 
             if(splitIndex >=0){
            
                ArrayList<String> newList = new ArrayList<>();
                
                //adds the flames word that are right to the removed flames
                for(int i = splitIndex+1; i<flames.size();i++){
                    newList.add(flames.get(i));
                }
                
                //adds the flames that are left to it
                for(int i =0; i<splitIndex; i++){
                  newList.add(flames.get(i));
                  
                }
                //new list will be worked on in furthering of the loop
                flames = newList;
             }

             //if modulo is 0 it removes the last flames and continues
             else{
              flames.remove(flames.size()-1);
             }
        }
        
        //workd untill only one word left and thats the result
        String result = flames.get(0);

        System.out.println("Your Relationship is " + result);

    }
}