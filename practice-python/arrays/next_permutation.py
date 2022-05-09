from typing import List


# noinspection PyMethodMayBeStatic
class Solution:
    def next_permutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        length: int = len(nums)
        last_idx: int = length - 1
        reverse_found: bool = False

        for i in range(last_idx, 0, -1):
            if nums[i - 1] < nums[i]:
                # Set reverse found to be true
                reverse_found = True

                # Swap the lesser number with the number just greater than it in the remaining array
                greater_element_index: int = self.find_greater_element_index(i - 1, nums)
                # Swap the items at i-1 and greater_element_index
                nums[i - 1], nums[greater_element_index] = nums[greater_element_index], nums[i - 1]

                # reverse the remaining list
                nums[i:length] = nums[i:length].reverse()
                break

        if not reverse_found:
            nums = nums.reverse()

        return nums

    def find_greater_element_index(self, index: int, nums: List[int]) -> int:
        for i in range(len(nums) - 1, index, -1):
            if nums[i] > nums[index]:
                return i
