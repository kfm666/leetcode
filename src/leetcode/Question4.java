package leetcode;

public class Question4 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{100001};
        int[] nums2 = new int[]{100000};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] merge = new int[nums1.length+nums2.length];
            int i = 0,j=0;
            int count = 0;
            while (i<nums1.length || j < nums2.length){
                if(i<nums1.length && j < nums2.length && i == 0 && j == 0){
                    if(nums1[i] < nums2[j]){
                        merge[count++] = nums1[i++];
                    }else{
                        merge[count++] = nums2[j++];
                    }
                }else if(nums1.length == 0 && nums2.length != 0){
                    merge[count++] = nums2[j++];
                }else if(nums2.length == 0 && nums1.length != 0){
                    merge[count++] = nums1[i++];
                }else if(nums1.length == 0 && nums2.length == 0){
                    return 0.0;
                }
                if(i<nums1.length && merge[count-1] <= nums1[i]){
                    if(j<nums2.length && nums1[i] <= nums2[j]){
                        merge[count++] = nums1[i++];
                    }else if(j<nums2.length && nums2[j] <= nums1[i]){
                        merge[count++] = nums2[j++];
                    }else{
                        merge[count++] = nums1[i++];
                    }

                }
                if(j<nums2.length&&merge[count-1] <= nums2[j]){
                    if(i<nums1.length && nums2[j] <= nums1[i]){
                        merge[count++] = nums2[j++];
                    }else if(i < nums1.length && nums1[i] <= nums2[j]){
                        merge[count++] = nums1[i++];
                    }else {
                        merge[count++] = nums2[j++];
                    }

                }
                if(count == (nums1.length + nums2.length)/2+1){
                    break;
                }
            }
            if((nums1.length + nums2.length)%2 != 0){
                return merge[(nums1.length + nums2.length)/2];
            }else{
                return (merge[(nums1.length + nums2.length)/2] + merge[(nums1.length + nums2.length)/2-1])/2.0;
            }
        }
    }
}

