class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        leetcode: 4 findMedianSortedArrays
        O(m)
        """
        alist = []
        idx1, idx2 = 0,0

        while idx1 < len(nums1) and idx2 < len(nums2):
            if nums1[idx1] < nums2[idx2]:
                alist.append(nums1[idx1])
                idx1 += 1
            else:
                alist.append(nums2[idx2])
                idx2 += 1
        if idx1 == len(nums1):
            alist.extend(nums2[idx2:])
        else:
            alist.extend(num1[idx1:])

        length = len(alist)
        mid = length // 2
        sums = alist[mid] + alist[~mid]
        median = sums/2

        return median




S = Solution()
num1=[2,5,7]
num2=[1,4,6]
output = S.findMedianSortedArrays(num1,num2)

print(output)
