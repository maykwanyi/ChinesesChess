using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess.piece
{
    public class General : Piece
    {

        public General(bool isRed, int X, int Y, int id) : base(isRed, X, Y, id)
        {
            this.X = X;
            this.Y = Y;
            this.isRed = isRed;
            this.isEmpty = false;
            this.id = id;
        }

        public bool move (int X, int Y, Board board)
        {
            if (checkMove(X, Y,board) && isRed)
            {
                this.X = X;
                this.Y = Y;
                board.RGP.X = X;
                board.RGP.Y = Y;
                eat(board);
                board.updatePos(this,X,Y);
                return true;
            }

            else if (!isRed && checkMove(X, Y, board))
            {
                this.X = X;
                this.Y = Y;
                board.BGP.X = X;
                board.BGP.Y = Y;
                eat(board);
                board.updatePos(this, X, Y);
                return true;
            }/*
            else if (board.RGP.Y == board.BGP.Y)
            {
                bool hasCovers = false;
                for (int i = board.RGP.X; i < board.BGP.X; i++)
                    if (board.board[board.RGP.X][i].isEmpty)
                    {
                        hasCovers = true;
                        break;
                    }
                if (!hasCovers)
                {
                    if (isRed)
                    {
                        this.X = board.BGX;
                        this.Y = board.BGY;
                        eat(board);
                    }
                    else
                    {
                        this.X = board.RGP.X;
                        this.Y = board.RGP.Y;
                        eat(board);
                    }
                    return true;
                }     */   
            

            return false;
        }
        public List<Point2D> getMoveList(Board board)
        {
            List <Point2D> list= new List<Point2D>();

            if (checkMove(X++, Y, board))
                list.Add(new Point2D(X, Y));
            if (checkMove(X--, Y, board))
                list.Add(new Point2D(X, Y));
            if (checkMove(X, Y++, board))
                list.Add(new Point2D(X, Y));
            if (checkMove(X, Y--, board))
                list.Add(new Point2D(X, Y));
            if (checkMove(board.RGP.X, board.RGP.Y,board))
                list.Add(new Point2D(board.RGP.X, board.RGP.Y));
            if (checkMove(board.BGP.X, board.BGP.Y, board))
                list.Add(new Point2D(board.BGP.X, board.BGP.Y));

            return list;
        }

        private bool checkMove(int X, int Y,Board board)
        {
           if (isRed && X >= 3 && X <= 5 && Y <= 2 && Y >= 0 && (Math.Abs(X - this.X) == 1 ^ Math.Abs(Y - this.Y) == 1) && (board.board[X][Y].isEmpty) && X != this.X && Y != this.Y)
                return true;
            else if (!isRed && X >= 3 && X <= 5 && Y >= 7 && Y <= 9 && (Math.Abs(X - this.X) == 1 ^ Math.Abs(Y - this.Y) == 1) && (board.board[X][Y].isEmpty) && X != this.X && Y != this.Y)
                return true;
            else if (board.RGP.Y == board.BGP.Y)
            {
                bool hasCovers = false;
                for (int i = board.RGP.X; i < board.BGP.X; i++)
                    if (board.board[board.RGP.X][i].isEmpty)
                    {
                        hasCovers = true;
                        break;
                    }
                if (!hasCovers)
                    return true;
            }
            return false;
        }
    }
}
