# Code mostly "borrowed" from geeks for geeks
# https://www.geeksforgeeks.org/finding-optimal-move-in-tic-tac-toe-using-minimax-algorithm-in-game-theory/
# Goes through every possible value of a tic tac toe board, finds the best move, and adds it to a csv file

import csv

# Begin "borrowed" code #

# Python3 program to find the next optimal move for a player 
player, opponent = 'x', 'o' 
  
# This function returns true if there are moves 
# remaining on the board. It returns false if 
# there are no moves left to play. 
def isMovesLeft(board) : 
  
    for i in range(3) :
        for j in range(3) :
            if (board[i][j] == '_') :
                return True 
    return False
  
# This is the evaluation function as discussed 
# in the previous article ( http://goo.gl/sJgv68 ) 
def evaluate(b) : 
    
    # Checking for Rows for X or O victory. 
    for row in range(3) :     
        if (b[row][0] == b[row][1] and b[row][1] == b[row][2]) :        
            if (b[row][0] == player) :
                return 10
            elif (b[row][0] == opponent) :
                return -10
  
    # Checking for Columns for X or O victory. 
    for col in range(3) :
       
        if (b[0][col] == b[1][col] and b[1][col] == b[2][col]) :
          
            if (b[0][col] == player) : 
                return 10
            elif (b[0][col] == opponent) :
                return -10
  
    # Checking for Diagonals for X or O victory. 
    if (b[0][0] == b[1][1] and b[1][1] == b[2][2]) :
      
        if (b[0][0] == player) :
            return 10
        elif (b[0][0] == opponent) :
            return -10
  
    if (b[0][2] == b[1][1] and b[1][1] == b[2][0]) :
      
        if (b[0][2] == player) :
            return 10
        elif (b[0][2] == opponent) :
            return -10
  
    # Else if none of them have won then return 0 
    return 0
  
# This is the minimax function. It considers all 
# the possible ways the game can go and returns 
# the value of the board 
def minimax(board, depth, isMax) : 
    score = evaluate(board)
  
    # If Maximizer has won the game return his/her 
    # evaluated score 
    if (score == 10) : 
        return score
  
    # If Minimizer has won the game return his/her 
    # evaluated score 
    if (score == -10) :
        return score
  
    # If there are no more moves and no winner then 
    # it is a tie 
    if (isMovesLeft(board) == False) :
        return 0
  
    # If this maximizer's move 
    if (isMax) :     
        best = -1000 
  
        # Traverse all cells 
        for i in range(3) :         
            for j in range(3) :
               
                # Check if cell is empty 
                if (board[i][j]=='_') :
                  
                    # Make the move 
                    board[i][j] = player 
  
                    # Call minimax recursively and choose 
                    # the maximum value 
                    best = max( best, minimax(board,
                                              depth + 1,
                                              not isMax) )
  
                    # Undo the move 
                    board[i][j] = '_'
        return best
  
    # If this minimizer's move 
    else :
        best = 1000 
  
        # Traverse all cells 
        for i in range(3) :         
            for j in range(3) :
               
                # Check if cell is empty 
                if (board[i][j] == '_') :
                  
                    # Make the move 
                    board[i][j] = opponent 
  
                    # Call minimax recursively and choose 
                    # the minimum value 
                    best = min(best, minimax(board, depth + 1, not isMax))
  
                    # Undo the move 
                    board[i][j] = '_'
        return best
  
# This will return the best possible move for the player 
def findBestMove(board) : 
    bestVal = -1000 
    bestMove = (-1, -1) 
  
    # Traverse all cells, evaluate minimax function for 
    # all empty cells. And return the cell with optimal 
    # value. 
    for i in range(3) :     
        for j in range(3) :
          
            # Check if cell is empty 
            if (board[i][j] == '_') : 
              
                # Make the move 
                board[i][j] = player
  
                # compute evaluation function for this 
                # move. 
                moveVal = minimax(board, 0, False) 
  
                # Undo the move 
                board[i][j] = '_' 
  
                # If the value of the current move is 
                # more than the best value, then update 
                # best
                if (moveVal > bestVal) :                
                    bestMove = (i, j)
                    bestVal = moveVal
  
    return bestMove

# End "borrowed" code #

def check_for_win(board: list):
    
    # Check rows
    for i in range(3):
        if (board[i][0] == board[i][1]) and (board[i][1] == board[i][2]) and (board[i][0] != '_'):
            return board[i][0]
        
    # Check columns
    for i in range(3):
        if (board[0][i] == board[1][i]) and (board[1][i] == board[2][i]) and (board[0][i] != '_'):
            return board[0][i]
        
    # Check diagonals
    if (board[1][1] != '_'):
        if (board[0][0] == board[1][1]) and (board[1][1] == board[2][2]):
            return board[1][1]
        if (board[2][0] == board[1][1]) and (board[1][1] == board[0][2]):
            return board[1][1]
    
    return False
  
# Variables
board = [
    ['', '', ''],
    ['', '', ''],
    ['', '', '']
]

inputs = []

# Opens up the csv file
with open('tictactoe.csv', 'w', newline='') as file:
    writer = csv.writer(file)

    # Repeats for every possible tic tac toe combo
    for n in range(3 ** 9):

        # Generate possible board
        ternary = []

        while n:
            n, r = divmod(n, 3)
            ternary.append(r)

        for i in range(9 - len(ternary)):
            ternary.append(0)

        board_ternary = [j * 0.5 for j in reversed(ternary)]

        # Convert from ternary to a board readable by the figure out the best move program
        for j in range(3):
            for i in range(3):
                board[j][i] = ['o', '_', 'x'][int(board_ternary[j*3 + i] * 2)]

        # Make sure the game board isn't already won
        if not(check_for_win(board)):
            # Find the best move
            bestMove = findBestMove(board) 

            # Convert best move into AI understandable format
            best_move_board = [0, 0, 0, 0, 0, 0, 0, 0, 0]
            best_move_board[bestMove[0] * 3 + bestMove[1]] = 1

            # Create a list of input board and best move output
            output = board_ternary
            output.extend(best_move_board)

            # Write the data to the CSV
            writer.writerow(output)
    