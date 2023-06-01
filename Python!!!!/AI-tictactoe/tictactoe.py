# Python tic-tac-toe
# Created by Jacob Watson for ICS3U

# Icon: https://www.flaticon.com/free-icons/tic-tac-toe"

import pandas as pd
import sys
import tensorflow.keras as tfk
import random


class Player():
    def __init__ (self, name, symbol):
        self.name = name
        self.symbol = symbol


def get_users(is_ai):
    # Variables
    players = []
    symbols = ['x', 'o']

    # Gets the name from each player, and creates two new player classes
    for i in range(2):
        if is_ai and i == 1:
            name = "AI"
            symbol = symbols[i]
        else:
            name = input(f'What is the {["first", "second"][i]} players name?: ')
            symbol = symbols[i]
        players.append(Player(name, symbol))
    return players

def get_choice(board: list):
    # Repeat until the player provides valid input
    while True:
        try:
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
                    print('Invalid Response, Try again')
                    output_board(board)
            # Check for keyedboard interrupt
            except KeyboardInterrupt:
                print("Keyedboard Interrupt Detected, Goodbye.")
                sys.exit()
        # Make sure the input is valid
        except ValueError:
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

def AI_prediction(board, model):
    print("AI is predicting:")
    # Convert the board into something readible by AI
    normalize_board = [[{'x': 0, 'o':1, ' ':0.5}[piece] for row in board for piece in row]]
    AI_input = pd.DataFrame(normalize_board, columns=['i1', 'i2', 'i3', 'i4', 'i5', 'i6', 'i7', 'i8', 'i9'])
    
    # Get the prediction from the AI
    prediction = model.predict(AI_input, verbose = 0)[0]
    index = [i for i in range(9) if prediction[i] == max(prediction)][0]

    # Convert prediction into rows and columns
    while True:
        row = int(index / 3)
        column = index % 3

        # Make sure the AI's prediction doesn't overlap with an existing square
        if board[row][column] == ' ':
            return column, row
        else:
            index = random.randint(0, 8)

def main():

    # Welcome User
    print('Welcome to Tic-Tac-Toe in Python')

    # Repeat until valid input is given
    while True:
        try:
            # Ask if the user wants to play the AI
            is_ai = int(input("Do you want to play against a person (0) or a computer (1): "))
            if 0 <= is_ai <= 1:
                break
            else:
                print("Invalid response, try again")
        except ValueError:
            print("Invalid response, try again")
    
    # Init AI
    if is_ai:
        print("Loading AI")
        model = tfk.models.load_model("tictactoe-model")

    # Variables
    players = get_users(is_ai)
    player = players[0]
    game_board = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]

    # Main loop
    for i in range(9):
        
        output_board(game_board)
        
        # Get choice from user or AI
        if player.symbol == 'x' or not(is_ai):
            column, row = get_choice(game_board)
        else:
            column, row = AI_prediction(game_board, model)

        game_board = update_board(player, game_board, (column, row))
        game_over = check_for_win(game_board)

        # If someone won, output the game board and give a congratulatory message
        if game_over:
            output_board(game_board)
            print(f'{[player.name for player in players if player.symbol == game_over][0]} wins the game!')
            break
        player = switch_turn(players, player)
    
    # If they game is tied and not won, output the game board and give a tie message
    if not(game_over):
        output_board(game_board)
        print(f"Cats game! {players[0].name} and {players[1].name} tie.")

# Run the main program
if __name__ == '__main__':
    main()