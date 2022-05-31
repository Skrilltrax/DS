from typing import List


def sorted_squares(self, nums: List[int]) -> List[int]:
    length: int = len(nums)
    left: int = 0
    right: int = length - 1
    result: List[int] = [0] * length
    counter: int = length - 1

    while left <= right:
        l_num: int = nums[left] ** 2
        r_num: int = nums[right] ** 2

        if l_num >= r_num:
            result[counter] = l_num
            left += 1
        else:
            result[counter] = r_num
            right -= 1

        counter -= 1

    return result
