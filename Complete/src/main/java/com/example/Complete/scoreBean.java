package com.example.Complete;

public class scoreBean {


        public int Win,Loss,Draw;

        public int WinStreak;

        public int getWin() {
            return Win;
        }

        public void addWin() {
            Win =+ 1;
        }

        public int getLoss() {
            return Loss;
        }

        public void addLoss() {
            Loss =+ 1;
        }

        public int getDraw() {
            return Draw;
        }

        public void addDraw() {
            Draw =+ 1;
        }

        public int getWinStreak() {
            return WinStreak;
        }

        public void addWinStreak() {
            WinStreak =+ 1;
        }

}

