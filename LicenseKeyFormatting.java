class Solution {
    public String licenseKeyFormatting(String S, int k) {
        StringBuilder sb = new StringBuilder("");
        
        if(S.matches("^[-]*$"))
            return sb.toString();
        for(int i = 0;i <S.length();i++)
        {
            if(S.charAt(i)!='-')
                sb.append(String.valueOf(S.charAt(i)));
        }
        String str = sb.reverse().toString().toUpperCase();
        StringBuilder answer = new StringBuilder("");
        int numCharacters = 0;
        
        for(int i = 0;i<=str.length()-k;i+=k)
        {
            answer.append(str.substring(i,i+k));
            numCharacters+=k;
            answer.append("-");
        }
        // System.out.println("Number of characters = " + numCharacters);
        // System.out.println(answer);
            
        if(numCharacters<str.length())
        {
            answer.append(str.substring(numCharacters,str.length()));
        }
        else
            answer.deleteCharAt(answer.length()-1);
        return answer.reverse().toString();
    }
}