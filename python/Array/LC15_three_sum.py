def threeSum(arr):
    rtn = []
    arr.sort()
    for i in range(len(arr)-1):
        if i >= 1 and arr[i] == arr[i-1]:
            continue
        target = 0-arr[i]
        l = i+1
        r = len(arr)-1
        while(l < r):

            if arr[l] + arr[r] > target:
                r -= 1
            elif arr[l] + arr[r] < target:
                l += 1
            else:
                rtn.append([arr[i], arr[r], arr[l]])
                while(l < r and arr[l] == arr[l+1]):
                    l += 1
                while(l < r and arr[r] == arr[r-1]):
                    r -= 1
                r -= 1
                l += 1
    return rtn


if __name__ == "__main__":
    arr = [-3, 1, -5, -1, 0, -1, 3, -4, 1, 2, -1, -1, -4, -4]
    print(threeSum(arr))

