class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n & (-n)) == n;
    }
}
