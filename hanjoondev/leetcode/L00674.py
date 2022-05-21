from time import perf_counter_ns as ns


class Solution:
    def findLengthOfLCIS(self, nums: list[int]) -> int:
        if (length := len(nums)) <= 1:
            return length
        ans = cur = 1
        for i in range(1, length):
            cur += 1 if nums[i] > nums[i - 1] else -cur + 1
            ans = max(ans, cur)
        return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([1, 3, 5, 4, 7], 3),
        ([2, 2, 2, 2, 2], 1)
    )
    s = Solution()
    for numbers, expected in tests:
        print(f'findLengthOfLCIS({numbers}) returned', end=' ')
        if (result := s.findLengthOfLCIS(numbers)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.findLengthOfLCIS(numbers)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
