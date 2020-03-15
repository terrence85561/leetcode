def threeSumSmaller(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return 0
        rtn = 0
        nums.sort()
        for i in range(len(nums)-1):
            t = target - nums[i]
            l = i+1
            r = len(nums)-1
            while(l < r):
                if nums[l] + nums[r] > t:
                    r -= 1
                elif nums[l] + nums[r] == t:
                    r -= 1
                else:
                    rtn += r-l
                    l += 1
        return rtn
