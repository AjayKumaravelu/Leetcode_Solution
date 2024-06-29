class Solution {
    public String reverseWords(String s) {
        String[] result = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for(int i = result.length - 1; i > 0 ; i--){
            reversed.append(result[i]).append(" ");
        } 
        if(result.length > 0){
            reversed.append(result[0]);
        }
        return reversed.toString();
    }

}








    //     //s = s.trim(); 
    //     //String[] result = s.trim().split("\\s+");
    //     int left = 0;
    //     int right = s.length() - 1;

    //     // We will create a temp string and ans string
    //     String temp = "";
    //     String ans = "";

    //     // We will iterate till last
    //     while (left <= right) {
    //         char ch = s.charAt(left);
    //         // if ch is not a space then we add the character to the temp
    //         if (ch != ' ') {
    //             temp += ch;
    //         } else {
    //             // If the answer is not empty
    //             if (!ans.equals("")) {
    //                 ans = temp + " " + ans;
    //             } else {
    //                 ans = temp;
    //             }
    //             temp = "";
    //         }
    //         left++;
    //     }

    //     // If it is the last element then we will do the below for
    //     if (!temp.equals("")) {
    //         if (!ans.equals("")) {
    //             ans = temp + " " + ans;
    //         } else {
    //             ans = temp;
    //         }
    //     }
    //     return ans;
    // }
//}