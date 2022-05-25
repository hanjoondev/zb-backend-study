import sys

def input():
    return sys.stdin.readline().rstrip()

def backtracking(depth, solCnt):
    global res
    # 탈출 조건 1.
    if solCnt + 10 - depth < 5:
        return

    # 탈출 조건 2.
    if depth == 10:
        cnt = 0

        for i in range(10):
            if compare[i] == answer[i]:
                cnt += 1
        if(cnt >= 5):
            res += 1
        return
    
    # 생성 조건
    for i in range(1, 6):
        if depth >= 2 and compare[depth -2] == compare[depth -1] == i:
            continue

        compare.append(i)
        if(i == answer[depth]):
            backtracking(depth + 1, solCnt + 1)
        else:
            backtracking(depth + 1, solCnt)

        compare.pop()
        
    
answer = list(map(int, input().split()))
res, compare = 0, []
backtracking(0, 0)
print(res)