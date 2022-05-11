import math
import sys

def input():
    return sys.stdin.readline()

def solve():
    n, m = map(int, input().split())    
    
    times = []
    for i in range(n):
        val = int(input())
        times.append(val)
    times.sort()    
    left = 0
    right = math.ceil((m / n) * times[-1])

    while(left <= right):
        mid = (left + right) // 2
        cnt = 0
        for time in times:
            cnt += mid // time
        
        if cnt < m:
            left = mid + 1
        else:
            right = mid - 1

    print(left)
    

if __name__ == "__main__":
    solve()