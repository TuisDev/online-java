# Code by Jacob Watson with help from
# https://stackabuse.com/tensorflow-2-0-solving-classification-and-regression-problems/
# Creates and trains an AI model on tic-tac-toe data

import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from tensorflow.keras.layers import Input, Dense, Activation, Dropout
from tensorflow.keras.models import Model, load_model

# Constants
epochs = 200

# Variables
cols = ['i1', 'i2', 'i3', 'i4', 'i5', 'i6', 'i7', 'i8', 'i9', 'o1', 'o2', 'o3', 'o4', 'o5', 'o6', 'o7', 'o8', 'o9']
games = pd.read_csv(r'tictactoe.csv', names=cols, header=None)

X = games[['i1', 'i2', 'i3', 'i4', 'i5', 'i6', 'i7', 'i8', 'i9']]
y = games[['o1', 'o2', 'o3', 'o4', 'o5', 'o6', 'o7', 'o8', 'o9']]

# Create model
input_layer = Input(shape=(X.shape[1],))
dense_layer_1 = Dense(18, activation='relu')(input_layer)
dense_layer_2 = Dense(36, activation='relu')(dense_layer_1)
dense_layer_3 = Dense(54, activation='relu')(dense_layer_2)
dense_layer_4 = Dense(36, activation='relu')(dense_layer_3)
output = Dense(y.shape[1], activation='softmax')(dense_layer_4)

model = Model(inputs=input_layer, outputs=output)
model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['acc'])

# Train model
history = model.fit(X, y, batch_size=8, epochs=epochs, verbose=1, validation_split=0.0)

# Save the model
model.save("tictactoe-model")



