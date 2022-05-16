import sys
import math

def input():
    return sys.stdin.readline().rstrip()

cur = int(input())
result = []

p2 = 1
root = math.sqrt(cur)
if int(root + 0.5) ** 2 == cur:
    p1 = int(root)
else:
    p1 = int(root) + 1

while(p1 **2 - p2 ** 2 >= cur or p1 > p2):
    if p1 **2 - p2 ** 2 == cur:
        result.append(p1)
        p1 += 1
    elif p1 ** 2 - p2 **2 < cur:
        p1 += 1
    elif p1 **2  - p2 **2 > cur:
        p2 += 1

if result:
    for num in result:
        print(num)
else:
    print(-1)
