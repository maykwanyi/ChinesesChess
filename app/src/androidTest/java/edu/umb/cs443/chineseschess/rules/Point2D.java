using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess
{
    public class Point2D
    {
        public int X { get; set; }
        public int Y { get; set; }

        public Point2D (int X, int Y)
        {
            this.X = X;
            this.Y = Y;
        }
        public bool Equals(Point2D that)
        {
            return this.X == that.X && this.Y == that.Y;
        }

        public override int GetHashCode()
        {
            return this.X.GetHashCode() + this.Y.GetHashCode();
        }
    }
}
