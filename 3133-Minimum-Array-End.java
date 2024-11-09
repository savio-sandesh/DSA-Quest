class Solution {
    public long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }

        List<Integer> zeroPos = new ArrayList<>();
        int count = 0;
        int val = x;
        while (val > 0) {
            if ((val & 1) == 0) {
                zeroPos.add(count);
            }
            count++;
            val >>= 1;
        }

        int reqdBits = (int) Math.ceil(Math.log(n) / Math.log(2));

        for (int i = zeroPos.size(); i < reqdBits; ++i) {
            zeroPos.add(count++);
        }

        List<Integer> appendBits = getBin(n - 1);

        long ans = x;
        int pos = appendBits.size();
        while (pos-- > 0) {
            if (appendBits.get(pos) == 1) {
                ans += Math.pow(2, zeroPos.get(pos)) * appendBits.get(pos);
            }
        }

        return ans;
    }

    private List<Integer> getBin(int num) {
        List<Integer> bits = new ArrayList<>();
        while (num > 0) {
            bits.add(num % 2);
            num /= 2;
        }
        return bits;
    }
}
