from typing import List


def remove_duplicates(nums: List[int]) -> int:
    for i in reversed(range(len(nums))):
        if nums[i + 1] == nums[i]:
            nums.pop(i + 1)

    return len(nums)
