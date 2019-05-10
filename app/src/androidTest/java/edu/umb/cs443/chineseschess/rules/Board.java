using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess
{

    public class Board
    {
        public Piece[][] board { get; set; }

        public Point2D RGP { get; set; }
        public Point2D BGP { get; set; }

        public int RIVER_BLACK_SIDE = 6;
        public int RIVER_RED_SIDE = 5;

        public Board()
        {
            board = new Piece[9][10];
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 10; j++)
                    board[i][j] = new Piece(i, j);

            RGP = new Point2D(4, 0);
            RGP = new Point2D(4, 9);
        }

        public bool isIn (int X, int Y)
        {
            return X < board.Length && Y < board[0].Length;
        }

        public void updatePos(Piece new_p, int old_X, int old_Y)
        {
            board[new_p.X][new_p.Y] = new_p;
            board[old_Y][old_Y].isEmpty = true;
        }
        public bool isInRedPalace (int X, int Y)
        {
            return X >= 3 && X <= 5 && Y <= 2 && Y >= 0;
        }
        public bool isInBlackPalace(int X, int Y)
        {
            return X >= 3 && X <= 5 && Y >= 7 && Y <= 9;
        }
    }
}


