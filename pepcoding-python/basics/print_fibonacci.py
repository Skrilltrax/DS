class Solution:
    def print_fibonacci(self, n: int) -> int:
        zero: int = 0
        first: int = 1
        count: int = 2

        if n == 0:
            return zero
        elif n == 1:
            return first
        else:
            while count != n:
                second: int = zero + first
                zero = first
                first = second

                count += 1

        return zero + first
