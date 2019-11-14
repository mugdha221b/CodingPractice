class MinimumDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        
        int[] s1 = A.clone();
        int[] s2 = B.clone();
        Arrays.sort(s1);
        Arrays.sort(s2);
        if(s1.length!=0 && s1[0] == s1[s1.length-1])
            return 0;
        if(s2.length!=0 && s2[0] == s2[s2.length-1])
            return 0;

        
        
        int[] arr1 = new int[7];
        int[] arr2 = new int[7];
        
        Arrays.fill(arr1,0);
        Arrays.fill(arr2,0);
        
        int n = A.length;
        for(int i = 0;i<n;i++)
        {
            int a = A[i];
            int b = B[i];
            
            arr1[a]++;
            arr2[b]++;
        }
        
        int flag = 0;
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for(int i = 0;i<arr1.length;i++)
        {
            if(arr1[i]+arr2[i]>=n)
            {
                flag = 1;
                candidates.add(i);
            }
        }
        if(flag == 0)
            return -1;
        
        
        
        ArrayList<Integer> values = new ArrayList<Integer>();
        //check for each candidate
        for(int can : candidates)
        {
            int c1= 0;
            int c2 = 0;
            int count1 = 0;
            int count2 = 0;
            System.out.println("Candidate = " + can);
            for(int i = 0;i<n;i++)
            {
                if(A[i] == can)
                    {
                    c1++;}
                else
                {
                    if(B[i] == can)
                       {
                        count1++;}
                }
                if(B[i] == can)
                    {
                    c2++;}
                else
                {
                    if(A[i] == can)
                       {
                        count2++;}
                }
                
                
            }

            if( (c1+count1) == n || (c2+ count2) == n)
            {
                values.add(Math.min(count1,count2));
            }
        }
        Collections.sort(values);
        if(values.size() == 0)
            return -1;
        return values.get(0);
 
            
        
    }
}