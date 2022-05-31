from typing import List, Tuple


def three_sum_closest(nums: List[int], target: int):
    closest = float('inf')
    result: Tuple = ()
    nums.sort()

    for index, num in enumerate(nums):
        left: int = index + 1
        right: int = len(nums) - 1

        while left < right:
            sum_value: int = num + nums[left] + nums[right]

            if abs(target - sum_value) < abs(target - closest):
                closest = sum_value
                result = (num, nums[left], nums[right])

            if sum_value > target:
                right -= 1
            else:
                left += 1

    return closest
