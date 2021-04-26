package HackerRank;
import java.util.*;

/*
HackerRank, Hash Tables:  Ransom Note

Given the words in the magazine and the words in the ransom note, print Yes if you can replicate the ransom note exactly
using whole words from the magazine; otherwise, print No


Put all words in note in table
    increment value for repeated entries
Iterate through and check those words against magazine, removing them from note if contained and value is == 1
If note table is empty, return yes
If no, return no

*/

public class ransomNote {



    static void checkMagazine(String[] magazine, String[] note) {

        String currentWord;
        Hashtable<String, Integer> noteHashTable = new Hashtable<>(note.length*2, .75f);
        

        //String Key = the word
        //Int value = how many times encountered

        for(int i = 0; i < note.length; i++){
            currentWord = note[i];
            if(noteHashTable.containsKey(currentWord)){
                noteHashTable.replace(currentWord, noteHashTable.get(currentWord) + 1);
            }
            else
                noteHashTable.put(currentWord, 1);    
            
        }


        //iterate through magazine[]
        //remove words from note table as they are processed 
        for(int i = 0; i < magazine.length; i++){
            currentWord = magazine[i];
            if(noteHashTable.containsKey(currentWord) && noteHashTable.get(currentWord) == 1){
                noteHashTable.remove(currentWord);
            }
            else if(!noteHashTable.containsKey(currentWord)){
                continue;
            }

            else{

                
                noteHashTable.replace(currentWord, noteHashTable.get(currentWord) - 1);
                
            }
            
        }

        if(noteHashTable.isEmpty()){
            System.out.println("Yes");
        }
        else   
            System.out.println("No");

    }



    public static void main(String[] args){

        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};

        checkMagazine(magazine, note);
    }


}
