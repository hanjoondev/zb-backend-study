import sys

def input():
    return sys.stdin.readline().rstrip()

def solution():
    n, k = map(int, input().split())
    backpack = [list(map(int,input().split())) for _ in range(n)]
    dp = [[0 for _ in range(k + 1)] for _ in range(n + 1)]

    for i in range(n):
        for j in range(1, k + 1):
            if backpack[i][0] > j:
                dp[i + 1][j] = dp[i][j]
            else :
                dp[i + 1][j] = max(dp[i][j], dp[i][j - backpack[i][0]] + backpack[i][1])
                
                
    print(dp[n][k])

solution()
