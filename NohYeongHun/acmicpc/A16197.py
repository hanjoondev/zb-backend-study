import sys
def input():
    return sys.stdin.readline().rstrip()

def board_coin():
    n, m = map(int, input().split())
    board = []
    coin_place = []
    for i in range(n):
        val = input()
        board.append(val)
        for j in range(m):
            if board[i][j] == "o":
                coin_place.append((i, j))
    return board, coin_place

def drop_coin(f_coin_pos, b_coin_pos, row, col):
    df_x, df_y = f_coin_pos
    db_x, db_y = b_coin_pos

    f_coin_drop = False
    b_coin_drop = False
            
    if df_x < 0 or df_x >= row or df_y < 0 or df_y >=col:
        f_coin_drop = True

    if db_x < 0 or db_x >= row or db_y < 0 or db_y >=col:
        b_coin_drop = True
    
    return f_coin_drop, b_coin_drop

def dfs(f_coin, b_coin, cnt, row, col):

    if cnt >= 10:
        return

    f_x, f_y = f_coin
    b_x, b_y = b_coin

    for d in dir:
        df_x, df_y = f_x + d[0], f_y + d[1]
        db_x, db_y = b_x + d[0], b_y + d[1]
        
        f_coin_drop, b_coin_drop = drop_coin((df_x, df_y), (db_x, db_y), row, col)
        
        if f_coin_drop and b_coin_drop:
            continue
        
        if f_coin_drop or b_coin_drop:
            cnt += 1
            ans.append(cnt)
            break  
        
        if board[df_x][df_y] == "#":
            df_x, df_y = f_x, f_y

        if board[db_x][db_y] == "#":
            db_x, db_y = b_x, b_y

        dfs([df_x, df_y], [db_x, db_y], cnt + 1, row, col)

if __name__ == "__main__":
    dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    isTrue, ans, cnt = False, [], 0
    board, coin_place = board_coin()
    row, col = len(board), len(board[0]) 
    dfs(coin_place[0], coin_place[1], 0, row, col)
    if ans:
        print(min(ans))
    else:
        print(-1)