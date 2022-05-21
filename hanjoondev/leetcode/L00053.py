from time import perf_counter_ns as ns


class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        max_ = nums[0]
        cur = 0
        for n in nums:
            cur = cur + n if cur >= 0 else n
            max_ = max(max_, cur)
        return max_


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([-2, 1, -3, 4, -1, 2, 1, -5, 4], 6),
        ([1], 1),
        ([5, 4, -1, 7, 8], 23)
    )
    s = Solution()
    for numbers, expected in tests:
        print(f'maxSubArray({numbers}) returned', end=' ')
        if (result := s.maxSubArray(numbers)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.maxSubArray(numbers)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
