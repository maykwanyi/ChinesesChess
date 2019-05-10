using ChineseChess.piece;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess
{
    public enum rank { Rook, Horse, Advioor, Elephant, Soilder, General};

    public class Game
    {
        Board board { get; set; }

        int Red_rook_id { get; set; }
        int Red_Horse_id { get; set; }
        int Red_Advisor_id { get; set; }
        int Red_Elephant_id { get; set; }
        int Red_G_id { get; set; }
        int Red_S_id { get; set; }

        int Black_rook_id { get; set; }
        int Black_Horse_id { get; set; }
        int Black_Advisor_id { get; set; }
        int Black_Elephant_id { get; set; }
        int Black_G_id { get; set; }
        int Black_S_id { get; set; }

        public Game()
        {
            board = new Board();
        }

        public static void checkmate(string side)
        {
            if (side.Equals("RED"))
            {
                lose("RED");
            }
            else
                lose("BLACK");
        }
        public static void lose(string s)
        {

        }

        public void startNewGame()
        {

        }
        public void generatePiece(rank r, Point2D pos, bool isRed)
        {
            switch (r)
            {
                case rank.Rook:
                    {
                        if (isRed && Red_rook_id < 2 && !board.board[pos.X][pos.Y].isEmpty)
                        {
                            board.board[pos.X][pos.Y] = new Rook(true, pos.X, pos.Y, Red_rook_id);
                            Red_rook_id++;
                            break;
                        }
                        else if (!isRed && Black_rook_id < 2 && !board.board[pos.X][pos.Y].isEmpty)
                        {
                            board.board[pos.X][pos.Y] = new Rook(true, pos.X, pos.Y, Black_rook_id);
                            Black_rook_id++;
                            break;
                        }
                    }
                case rank.Advisor:
                    {
                        if (isRed && Advisor.checkPos(pos.X,pos.Y,isRed) && !board.board[pos.X][pos.Y].isEmpty && Red_Advisor_id < 2)
                        {
                            board.board[pos.X][pos.Y] = new Advisor(isRed, pos.X, pos.Y, Red_Advisor_id);
                            Red_Advisor_id++;
                            break;
                        }
                        else if (!isRed && Advisor.checkPos(pos.X, pos.Y, isRed) && !board.board[pos.X][pos.Y].isEmpty && Black_Advisor_id < 2)
                        {
                            board.board[pos.X][pos.Y] = new Advisor(isRed, pos.X, pos.Y, Red_Advisor_id);
                            Black_Advisor_id++;
                            break;
                        }
                    }
                
            }
                

                

        }
    }
}
