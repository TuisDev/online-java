board = ["_" for i in range(42)]
red = "\033[91m{}\033[00m".format("O")
yellow = "\033[93m{}\033[00m".format("O")

def test():
    pass

def draw_board():
    for j in range(6):
        print(f"|{board[j * 7]}|{board[j * 7 + 1]}|{board[j * 7 + 2]}|{board[j * 7 + 3]}|{board[j * 7 + 4]}|{board[j * 7 + 5]}|{board[j * 7 + 6]}|")
    print(" 1 2 3 4 5 6 7")    
    
def drop_token(column, token):
    for j in range(5, 0, -1):
        if board[j * 7 + column] == "_":
            board[j * 7 + column] = token
            return True
    return False

def check_for_win(token):
    for j in range(42):
        if board[j] == token:
            win = True
            for i in range(1, 4, 1):
                if j + 7 * i < 42:
                    if board[j + 7 * i] != token:
                        win = False
                        break
                else:
                    win = False
                    break
            if win:
                return True
            
            win = True
            for i in range(1, 4, 1):
                if (j + i) % 7 != 0:
                    if board[j + i] != token:
                        win = False
                        break
                else:
                    win = False
                    break
            if win:
                return True

            win = True
            for i in range(1, 4, 1):
                if (j + i) % 7 != 0 and (j + i * 7) < 42:
                    if board[j + i * 7 - i] != token:
                        win = False
                        break
                else:
                    win = False
                    break
            if win:
                return True

            win = True
            for i in range(1, 4, 1):
                if (j - i) % 7 != 6 and (j + i * 7) < 42:
                    win = False
                    break
                else:
                    win = False
                    break
            if win:
                return True
            
    return False
def main():
    player = red
    print(-1 % 7)
    draw_board()
    while (True):
        column = int(input("What column")) - 1
        drop_token(column, player)
        draw_board()
        if check_for_win(player):
            break
        player = {red: yellow, yellow: red}[player]

    print(f"GAME OVER: {player} won")

# Run the main program
if __name__ == '__main__':
    main()