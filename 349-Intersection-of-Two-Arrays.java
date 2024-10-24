class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums3 = new int[Math.min(nums1.length, nums2.length)];
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    boolean exist = false;
                    for (int k = 0; k < count; k++) {
                        if (nums3[k] == nums1[i]) {
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        nums3[count++] = nums1[i];
                    }
                    break; 
                }
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = nums3[i];
        }
        return result;
    }
}
