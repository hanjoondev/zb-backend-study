import sys
import math

def input():
    return sys.stdin.readline().rstrip()

def isPrime(num):
    for i in range(2, int(math.sqrt(num)) + 1):
        if(num % i == 0):
            return False
    return True

n = int(input())

possible_first = [2, 3, 5, 7]
possible_next = [1, 3, 5, 7, 9]

def result(target, n):

    if n == 1:
        print(target)
        return
    
    if(len(str(target)) == n):
        print(target)
        return

    for pos_next in possible_next:
        if isPrime(target * 10 + pos_next):
            result(target * 10 + pos_next, n)


for pos_first in possible_first:
    target = pos_first
    result(target, n)