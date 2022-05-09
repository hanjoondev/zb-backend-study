from sys import stdin as s


def solution(graph: dict[dict[int, int]], v1: int, v2: int, N: int) -> None:
    for k, v in graph.items():
        print(k, v)
    return

def reader():
    n, e = map(int, s.readline().split())
    graph = {i: {} for i in range(1, n + 1)}
    for _ in range(e):
        a, b, c = map(int, s.readline().split())
        graph[a] = graph.get(a, {}) | {b: c}
        graph[b] = graph.get(b, {}) | {a: c}
    v1, v2 = map(int, s.readline().split())
    solution(graph, v1, v2, n)

if __name__ == '__main__':
    reader()




'''
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

'''   # expected 7