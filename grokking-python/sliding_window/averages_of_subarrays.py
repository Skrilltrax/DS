from typing import List


def averages_of_subarrays(k: int, arr: List[int]) -> List[float]:
    # We don't need to save window_start in a variable, but instead we can calculate it as (window_end - k + 1)
    result: List[float] = []
    window_start: int = 0
    window_sum: float = 0.0

    for window_end in range(len(arr)):
        window_sum += arr[window_end]  # Add the next element

        if window_end >= k - 1:  # Slide the window if the window_size has reached the value 'k'
            result.append(window_sum / k)
            window_sum -= arr[window_start]
            window_start += 1

    return result
