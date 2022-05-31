from typing import List


def two_sum(numbers: List[int], target: int) -> List[int]:
    indices: List[int] = [-1, -1]
    left: int = 0
    right: int = len(numbers) - 1

    while left < right:
        sum: int = numbers[left] + numbers[right]

        if sum == target:
            indices[0] = left
            indices[1] = right
            return indices
        elif sum < target:
            left = left + 1
        else:
            right = right + 1

    return indices
