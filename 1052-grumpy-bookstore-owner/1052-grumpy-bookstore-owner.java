class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int totalSum = 0;
        for(int i=0; i<n; i++){
           if(grumpy[i] == 0){
            totalSum += customers[i];
           }
        }

        int maxU = 0;
        int curUnS = 0;
        for(int i=0; i<minutes; i++){
            if(grumpy[i] == 1){
                curUnS += customers[i];
            }
        }

        maxU = curUnS;
        int i=0, j = minutes;
        while(j<n){
            if(grumpy[j] == 1){
                curUnS +=customers[j];
            }
            if(grumpy[i] == 1){
                curUnS -= customers[i];
            }
            i++;
            j++;
            maxU = Math.max(maxU, curUnS);
        }

        return maxU+totalSum;
    }
}