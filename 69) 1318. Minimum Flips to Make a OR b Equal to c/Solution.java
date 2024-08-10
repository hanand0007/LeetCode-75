class Solution {

    static int[] decToBinary(int n) {
        int[] binaryNum = new int[36];
        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        return binaryNum;
    }

    public int minFlips(int a, int b, int c) {
        int[] binA = decToBinary(a);
        int[] binB = decToBinary(b);
        int[] binC = decToBinary(c);
        int ans = 0;
        for (int i = 0; i < 36; i++) {
            if (binC[i] == 0) {
                if (binA[i] == 0 && binB[i] == 0) {
                    continue;
                } else if (binA[i] == 1 && binB[i] == 1) {
                    ans += 2;
                } else { // one is 1 and second is 0
                    ans += 1;
                }
            } else { // binC[i] == 1
                if (binA[i] == 0 && binB[i] == 0) {
                    ans += 1;
                } else {
                    continue;
                }
            }
        }
        return ans;
    }
}
