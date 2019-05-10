using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess.piece
{
    public class Advisor:Piece
    {
        public Advisor(bool isRed, int X, int Y, int id): base(isRed, X, Y, id)
        {
            this.X = X;
            this.Y = Y;
            this.isRed = isRed;
            this.isEmpty = false;
            this.id = id;
        }

        public bool move(int X, int Y, Board board)
        {
            List<Point2D> moveList = new List<Point2D>();
            if (moveList.Contains(new Point2D(X, Y)))
            {
                this.X = X;
                this.Y = Y;
                eat(board);
                board.updatePos(this,X,Y);
                return true;
            }
            return false;
        }

        public List<Point2D> getMoveList(Board board)
        {
            List<Point2D> list = new List<Point2D>();
            if (isRed)
            {
                if (board.isInRedPalace(X + 1, Y + 1))
                    list.Add(new Point2D(X + 1, Y + 1));
                if (board.isInRedPalace(X - 1, Y - 1))
                    list.Add(new Point2D(X - 1, Y - 1));
                if (board.isInRedPalace(X + 1, Y - 1))
                    list.Add(new Point2D(X + 1, Y - 1));
                if (board.isInRedPalace(X - 1, Y + 1))
                    list.Add(new Point2D(X - 1, Y + 1));
            }
            else
            {
                if (board.isInBlackPalace(X + 1, Y + 1))
                    list.Add(new Point2D(X + 1, Y + 1));
                if (board.isInBlackPalace(X - 1, Y - 1))
                    list.Add(new Point2D(X - 1, Y - 1));
                if (board.isInBlackPalace(X + 1, Y - 1))
                    list.Add(new Point2D(X + 1, Y - 1));
                if (board.isInBlackPalace(X - 1, Y + 1))
                    list.Add(new Point2D(X - 1, Y + 1));
            }
            return list;
        }
        public static bool checkPos(int X, int Y,bool isRed)
        {
            if (isRed && (X == 4 && Y == 0) || (X == 5 && Y == 1) || (X == 6 && Y == 0) || (X == 4 && Y == 2) || (X == 6 && Y == 2))
                return true;
            else if (!isRed && (X == 4 && Y == 9) || (X == 5 && Y == 8) || (X == 6 && Y == 9) || (X == 4 && Y == 7) || (X == 6 && Y == 7))
                return true;
            return false;
        }
    }
}
