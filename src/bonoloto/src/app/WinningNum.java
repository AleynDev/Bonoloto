package bonoloto.src.app;

import java.util.ArrayList;
import java.util.Collections;

public class WinningNum {

    ArrayList<Integer> winningBet;

    public  WinningNum() {
        this.winningBet = winnNumCombination();
    }

    public ArrayList<Integer> getWinningBet() {
        return winningBet;
    }

    public void setWinningBet(ArrayList<Integer> winningBet) {
        this.winningBet = winningBet;
    }

    private Integer randomNum() {
        return (int)((Math.random() * 48) + 1);
    }

    private ArrayList<Integer> winnNumCombination() {
        ArrayList<Integer> num = new ArrayList<>();
        Controllers cts = new Controllers();
        int total = 6;
        for (int i = 0; i < total; i ++) {
            boolean check = false;
            while (!check) {
                int aux = randomNum();
                if (cts.uniqueNum(aux, num)) {
                    num.add(aux);
                    check = true;
                }
            }
        }
        Collections.sort(num);
        return num;
    }

}
