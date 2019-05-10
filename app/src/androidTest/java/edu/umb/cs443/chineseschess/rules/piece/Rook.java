using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess.piece
{
    public class Rook:Piece
    {
        public Rook(bool isRed, int X, int Y, int id): base(isRed, X, Y, id)
        {
            this.X = X;
            this.Y = Y;
            this.isRed = isRed;
            this.isEmpty = false;
            this.id = id;
        }

        public bool move (int X, int Y,Board board)
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
            bool isEnd = false;
            List<Point2D> list = new List<Point2D>();

            int targetX = X + 1;
            int targetY = Y;
            while (!isEnd && board.isIn(targetX,targetY))
            {
                isEnd = board.board[targetX][targetY].isEmpty;
                list.Add(new Point2D(targetX, targetY));
                targetX++;
            }

            targetX = X - 1;
            targetY = Y;
            while (!isEnd && board.isIn(targetX, targetY))
            {
                isEnd = board.board[targetX][targetY].isEmpty;
                list.Add(new Point2D(targetX, targetY));
                targetX--;
            }

            targetX = X;
            targetY = Y + 1;
            while (!isEnd && board.isIn(targetX, targetY))
            {
                isEnd = board.board[targetX][targetY].isEmpty;
                list.Add(new Point2D(targetX, targetY));
                targetY++;
            }

            targetX = X;
            targetY = Y - 1;
            while (!isEnd && board.isIn(targetX, targetY))
            {
                isEnd = board.board[targetX][targetY].isEmpty;
                list.Add(new Point2D(targetX, targetY));
                targetY--;
            }
            return list;
        }


    }
}
