package bonoloto.src.app;

import java.util.ArrayList;

public class Controllers {

    public boolean uniqueNum(int num, ArrayList<Integer> sample) {
        boolean check = true;
        for (Integer integer : sample) {
            if (num == integer) {
                check = false;
                break;
            }
        }
        return check;
    }

    public boolean checkClick(boolean check) {
        return !check;
    }

    public int positionList(int num, ArrayList<Integer> sample) {
        int pos = -1;
        for (int i = 0; i < sample.size(); i ++) {
            if (num == sample.get(i)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public int checkReward(ArrayList<Integer> bet, ArrayList<Integer> prize) {
        int cont = 0;
        for (Integer element : prize) {
            if (bet.contains(element)) {
                cont ++;
            }
        }
        return cont;
    }

   public String rewards(int num) {
        String result = "";
        switch (num) {
            case 0, 1, 2 -> {
                result = "<html><p>No ha resultado premiado,<br>más suerte la próxima</p></html>";
            }
            case 3 -> {
                result = "<html><p>Enhorabuena!!<br>ha ganado 6,5€</p></html>";
            }
            case 4 -> {
                result = "<html><p>Enhorabuena!!<br>ha ganado 1025,16€</p></html>";
            }
            case 5 -> {
                result = "<html><p>Enhorabuena!!<br>ha ganado 159800,50€</p></html>";
            }
            case 6 -> {
                result = "<html><p>Enhorabuena!!<br>ha ganado 200150,25€</p></html>";
            }
        }
        return result;
   }


}
