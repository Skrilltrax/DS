from typing import List


def three_sum(self, nums: List[int]) -> List[List[int]]:
    length: int = len(nums)
    triplets: List[List[int]] = []

    # sort the array
    nums.sort()

    for i in range(length):
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        else:
            find_triplets_for_fixed(-nums[i], nums, i + 1, triplets)


def find_triplets_for_fixed(target, nums, left, triplets):
    right: int = len(nums) - 1

    while left < right: 
        current_sum: int = nums[left] + nums[right]

        if current_sum == target:
            triplets.append(-target)
            triplets.append(nums[left])
            triplets.append(nums[right])
            left += 1
            right -= 1

            while left < right and nums[left] == nums[left - 1]:
                left += 1

            while left < right and nums[right] == nums[right + 1]:
                right -= 1

        elif current_sum < target:
            left += 1
        elif current_sum > target:
            right -= 1
