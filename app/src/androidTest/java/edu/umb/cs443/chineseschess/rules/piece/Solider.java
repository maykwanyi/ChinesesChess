using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess.piece
{
    public class Solider:Piece
    {
        public Solider (bool isRed, int X, int Y, int id): base (isRed, X, Y, id)
        {
            this.X = X;
            this.Y = Y;
            this.isRed = isRed;
            this.isEmpty = false;
            this.id = id;
        }

        public static bool checkPos(Board board, int X, int Y, bool isRed)
        {
            Solider s = new Solider(isRed, X, Y, 0);
            if (s.checkCrossed(board))
                return true;
            else
            {
                if (isRed && Y > 3 && (X == 0 || X == 2 || X == 4 || X == 6 || X == 8))
                    return true;
                else if (!isRed && Y < 7 && (X == 0 || X == 2 || X == 4 || X == 6 || X == 8))
                    return true;
            }
            return false;
        }

        private bool checkCrossed (Board board)
        {
            if (isRed && Y > board.RIVER_RED_SIDE)
                return true;
            else if (isRed && Y < board.RIVER_BLACK_SIDE)
                return true;
            return false;
        }

        public bool move(int X, int Y, Board board)
        {
            List<Point2D> moveList = getMoveList(board);
            if (moveList.Contains(new Point2D(X, Y)))
            {
                this.X = X;
                this.Y = Y;
                eat(board);
                board.updatePos(this, X, Y);
                return true;
            }
            return false;
        }

        public List<Point2D> getMoveList(Board board)
        {
            List<Point2D> list = new List<Point2D>();
            if (!checkCrossed(board))
            {
                if (isRed)
                    list.Add(new Point2D(X, Y + 1));
                else
                    list.Add(new Point2D(X, Y + 1));
            }
            else
            {
                if (isRed)
                {
                    if (board.isIn(X + 1, Y))
                        list.Add(new Point2D(X + 1, Y));
                    if (board.isIn(X - 1, Y))
                        list.Add(new Point2D(X - 1, Y));
                    if (board.isIn(X, Y + 1))
                        list.Add(new Point2D(X + 1, Y));
                }
                else
                {
                    if (board.isIn(X + 1, Y))
                        list.Add(new Point2D(X + 1, Y));
                    if (board.isIn(X - 1, Y))
                        list.Add(new Point2D(X - 1, Y));
                    if (board.isIn(X, Y - 1))
                        list.Add(new Point2D(X, Y - 1));
                }
            }
            return list;
        }
    }
}
