class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        num = 0
        while True:
            if nums[num] == -1:
                return num
            temp = nums[num]
            nums[num] = -1
            num = temp
