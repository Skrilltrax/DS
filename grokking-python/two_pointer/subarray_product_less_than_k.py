from typing import List


def subarray_product_less_than_k(nums: List[int], k: int) -> int:
    left: int = 0
    result: int = 0
    product: int = 1

    for right, val in enumerate(nums):
        product *= val

        while product >= k and left <= right:
            product /= nums[left]
            left += 1

        result += (right - left + 1)

    return result
