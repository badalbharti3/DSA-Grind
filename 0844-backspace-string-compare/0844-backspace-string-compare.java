class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        String ans1="", ans2="";
        for(int i=0; i<s.length(); i++){
            if(Character.isLowerCase(s.charAt(i))){
                st1.push(s.charAt(i));
            }
            else if(s.charAt(i) == '#'  ) {
                if(!st1.isEmpty()) st1.pop();
                else continue;
            }
        }
        for(int i=0; i<t.length(); i++){
            if(Character.isLowerCase(t.charAt(i))){
                st2.push(t.charAt(i));
            }
            else if(t.charAt(i) == '#' ) {
                if(!st2.isEmpty()) st2.pop();
                else continue;
            }
        }

        for(char c:st1){
            ans1+=c;
        }
        for(char c:st2){
            ans2+=c;
        }

        return ans1.equals(ans2);

    }
}