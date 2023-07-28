# Minesweeper

The goal of the game is to find all the mines within an MxN field. To help you, the game shows a
number in a square which tells you how many mines there are adjacent to that square. For 
instance, take the following 4x4 field with 2 mines (which are represented by an * character):
*...
....
.*..
....
The same field including the hint numbers described above would look like this:
*100
2210
1*10
1110
You should write a program that takes input as follows:
A String Array for each element represents a line assuming that all elements have the same 
number of characters. Each safe square is represented by an “.” character (without the quotes) 
and each mine square is represented by an “*” character (also without the quotes).
Your program should produce output as follows:
The field with the “.” characters replaced by the number of adjacent mines to that square.
In Rest Example:
Input:
{
 "square": ["**...",".....",".*..."]
}
Output:
{
 "hints": ["**100","33200","1*100"]
}
