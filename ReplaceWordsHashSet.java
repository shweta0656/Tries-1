/*
TC: O((N*l) + (M*(l^2)))
To put all the words in the Set from Dictionary: N*l
To check for the shortest version for each and every word when there are M number of words: M*(l^2)
(l^2): l square because we are going over each word and form substrings

SC: O(N*l + M*l)

The set that stores the dictionary requires O(N*l) space. The data structure that stores the words in the
sentence uses O(M*l) space.
*/

import java.util.HashSet;
import java.util.List;

class ReplaceWordsHashSet {
    public String replaceWords(List<String> dictionary, String sentence)
    {
        HashSet<String> set = new HashSet<>(dictionary); //O(N*l)
        StringBuilder result = new StringBuilder();

        //splitting the sentence
        String[] splitArr = sentence.split(" ");
        for(int i=0; i< splitArr.length; i++)
        {
            if(i>0) result.append(" ");

            //To check if we are breaking out the below for loop or all characters have been finished or visited
            boolean flag = false;

            //Taking the word in split array and iterating on it
            String word = splitArr[i];
            for(int j=0; j<word.length(); j++) //O(l)
            {
                String subStr = word.substring(0, j+1); //O(l)
                if(set.contains(subStr)) {
                    result.append(subStr);
                    flag = true;
                    break;
                }
            }

            /*
            If we break the loop meaning the shortest version has been appended in the result,
            if we do not break the loop and coming out of the loop naturally then flag will be false
            */
            if(!flag) {
                result.append(word);
            }
        }

        return result.toString();
    }
}