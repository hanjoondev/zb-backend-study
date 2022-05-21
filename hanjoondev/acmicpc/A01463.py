from sys import stdin


def solution(n: int) -> int:
    dp = [0] * (n + 1)
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + 1
        if not i % 2 and (tmp := dp[i // 2] + 1) < dp[i]:
            dp[i] = tmp
        if not i % 3 and (tmp := dp[i // 3] + 1) < dp[i]:
            dp[i] = tmp
    return dp[n]


def reader():
    n = int(stdin.readline())
    print(solution(n))


if __name__ == '__main__':
    reader()
