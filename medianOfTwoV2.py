class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        leetcode4: median of two sorted array
        O(log(min(m,n)))
        using binarySearch
        cut2 = half - cut1
        condition:
            1. nums1[cut1-1] < num2[cut2]
            2. nums1[cut1] > num2[cut2 - 1]
        """
        m = len(nums1) # len of shorter array
        n = len(nums2)
        if n < m:
            # make sure nums1 is shorter than nums2
            return(self.findMedianSortedArrays(nums2,nums1))
        if m == 0:
            if n % 2 == 0:
                return (nums2[(n//2 - 1)]+nums2[n//2])/2
            else:
                return(nums2[n//2])

        half = (m + n) // 2
        Min = 0
        Max = m
        while(Min <= Max):
            cut1 = (Max + Min) // 2
            cut2 = half - cut1
            if cut1 > 0 and nums1[cut1 - 1] > nums2[cut2] :
                # first if cut1 > 0,then if nums[cut1 - 1]> nums2[cut2]
                Max = cut1 - 1

            elif cut1 < m and nums1[cut1] < nums2[cut2 - 1] :
                Min = cut1 + 1
            else:
                if cut1 == 0:
                    left = nums2[cut2-1]
                elif cut2 == 0:
                    left = nums1[cut1-1]
                else:
                    left = max(nums1[cut1-1],nums2[cut2-1])
                if cut1 == m:
                    right = nums2[cut2]
                elif cut2 == n:
                    right = nums1[cut1]
                else:
                    right = min(nums1[cut1],nums2[cut2])
                if (m+n)%2 == 0:
                    return(left + right)/2
                else:
                    return right
