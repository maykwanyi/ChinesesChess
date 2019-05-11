package edu.umb.cs443.chineseschess;


import edu.umb.cs443.chineseschess.piece.Piece;

public class Board
{
    public Piece[][] board;

    public Point2D RGP;
    public Point2D BGP;

    public int RIVER_BLACK_SIDE = 5;
    public int RIVER_RED_SIDE = 4;

    public Board()
    {
        board = new Piece[9][10];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 10; j++)
                board[i][j] = new Piece(i, j);

        RGP = new Point2D(4, 0);
        RGP = new Point2D(4, 9);
    }

    public boolean isIn (int X, int Y)
    {
        return (X < board.length && Y < board[0].length) && (X >= 0 && Y >= 0);
    }

    public void updatePos(Piece new_p, int old_X, int old_Y)
    {
        board[new_p.X][new_p.Y] = new_p;
        board[old_X][old_Y] = new Piece(old_X, old_Y);
    }
    public boolean isInRedPalace (int X, int Y)
    {
        return X >= 3 && X <= 5 && Y <= 2 && Y >= 0;
    }
    public boolean isInBlackPalace(int X, int Y)
    {
        return X >= 3 && X <= 5 && Y >= 7 && Y <= 9;
    }
}
