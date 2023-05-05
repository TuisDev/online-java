# Python tic-tac-toe
# Created by Jacob Watson for ICS3U


class Player():
    def __init__ (self, name, symbol):
        self.name = name
        self.symbol = symbol


def get_users():
    # Variables
    players = []
    symbols = ['x', 'o']

    # Gets the name from each player, and creates two new player classes
    for i in range(2):
        name = input(f'What is the {["first", "second"][i]} players name?: ')
        symbol = symbols[i]
        players.append(Player(name, symbol))
    return players

def get_choice(board: list):
    # Repeat until the player provides valid input
    while True:
        try:
            # Get input from player
            choice = input('Where do you want to go? (row, column):')

            # Convert input into two integers
            column, row = choice.split(',')
            column = column.replace('(', '')
            column = column.replace(' ', '')
            row = row.replace(')', '')
            row = row.replace(' ', '')

            column = int(column) - 1
            row = int(row) - 1

            # Check to make sure the target space is empty
            if board[row][column] == ' ':
                return column, row
            else:
                raise Exception
        except:
            print('Invalid Response, Try again')
            output_board(board)

def update_board(player: Player, board: list, position: tuple):
    # Sets the position the player specified to their symbol
    column = position[0]
    row = position[1]
    board[row][column] = player.symbol
    return board

def output_board(board: list):
    for i in range(3):
        print(f'{i + 1}  {board[i][0]} | {board[i][1]} | {board[i][2]} ')
        if i != 2:
            print('  -----------')
    print('   1   2   3 ')

def check_for_win(board: list):
    
    # Check rows
    for i in range(3):
        if (board[i][0] == board[i][1]) and (board[i][1] == board[i][2]) and (board[i][0] != ' '):
            return board[i][0]
        
    # Check columns
    for i in range(3):
        if (board[0][i] == board[1][i]) and (board[1][i] == board[2][i]) and (board[0][i] != ' '):
            return board[0][i]
        
    # Check diagonals
    if (board[1][1] != ' '):
        if (board[0][0] == board[1][1]) and (board[1][1] == board[2][2]):
            return board[1][1]
        if (board[2][0] == board[1][1]) and (board[1][1] == board[0][2]):
            return board[1][1]
    
    return False

def switch_turn(players: list, player: Player):
    i = players.index(player)
    i += 1
    if i > 1:
        i = 0

    return players[i]


def main():
    print('Welcome to Tic-Tac-Toe in Python')

    # Variables
    players = get_users()
    player = players[0]
    game_board = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]

    # Main loop
    for i in range(9):
        
        output_board(game_board)
        column, row = get_choice(game_board)
        game_board = update_board(player, game_board, (column, row))
        game_over = check_for_win(game_board)
        # If someone won, output the game board and give a congratulatory message
        if game_over:
            output_board(game_board)
            print(f'{[player.name for player in players if player.symbol == game_over][0]} wins the game!')
            break
        player = switch_turn(players, player)


if __name__ == '__main__':
    main()