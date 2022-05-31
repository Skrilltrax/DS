from typing import List


def three_sum_smaller(arr: List[int], n: int, target: int):
    counter = 0
    arr.sort()

    for i in range(n):
        left = i + 1
        right = n - 1

        while left < right:
            sums = arr[i] + arr[left] + arr[right]

            if sums < target:
                # If the left and right indices are in range, then left and right - 1,2,3,4,... will also be in range
                counter += right - left
                left += 1
            else:
                right -= 1

    return counter
