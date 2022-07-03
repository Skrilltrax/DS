import math
from typing import List


class Solution:
    def count_primes(self, n: int) -> int:
        prime_count: int = 0

        for i in range(2, n):
            if self.is_prime_root_faster(i):
                prime_count += 1

        return prime_count

    def count_primes_sieve_eratosthenes(self, n: int) -> int:
        prime_count: int = 0
        sieve: List[int] = [True] * n

        for i in range(2, n):
            if not sieve[i]:
                continue
            else:
                prime_count += 1
                for j in range(i, n, i):
                    sieve[j] = False

        return prime_count

    def count_primes_sieve_eratosthenes_optimized(self, n: int) -> int:
        prime_count: int = 0
        sieve: List[int] = [True] * n
        i: int = 2

        # We can find if n is prime by looking till sqrt(n). So here, for our highest number (i.e n) we are only
        # marking all the numbers till sqrt(n). For example, if we take number 49, it has to have a prime factor till 7,
        # or it won't have any prime factors. So for the sieve we just need to mark the factors of 2-7.
        while (i * i) <= n:
            print(f"i: {i}")
            if sieve[i]:
                # This works because, we will encounter any new multiple after the square of i. For example,
                # if we are marking all the multiples of 5. We will only find new number after 25 (inclusive),
                # because all the other multiples [5 (5 * 1), 10 (5 * 2), 15 (5 * 3), 20 (5 * 4)] are already marked by
                # [1, 2, 3, 4] respectively.
                i_square: int = i * i
                for j in range(i_square, n, i):
                    sieve[j] = False

            i += 1

        for index in range(2, n):
            if sieve[index]:
                prime_count += 1

        return prime_count

    @staticmethod
    def is_prime(number: int) -> bool:
        range_end: int = (number // 2) + 1
        for i in range(2, range_end):
            if (number % i) == 0:
                return False
        return True

    @staticmethod
    def is_prime_root(number: int) -> bool:
        range_end: int = int(math.sqrt(number)) + 1
        for i in range(2, range_end):
            if (number % i) == 0:
                return False
        return True

    @staticmethod
    def is_prime_root_faster(number: int) -> bool:
        i: int = 2
        while i * i <= number:
            if (number % i) == 0:
                return False
            i += 1
        return True
