package pgm_42860;

public class Solution {
    private int min = Integer.MAX_VALUE;

    public int solution(String name) {
        boolean[] checked = new boolean[name.length()];
        checked[0] = true;
        checkRecursive(checked, 0, Math.min(controlUp(name.charAt(0)), controlDown(name.charAt(0))), name);
        return min == -1 ? 0 : min;
    }

    public void checkRecursive(boolean[] checked, int position, int movement, String name) {
        int idx;
        for (idx = 0; idx < checked.length; idx++) {
            if (!checked[idx])
                break;
        }
        if (idx == checked.length) {
            if(name.charAt(position) == 'A')
                movement --;
            min = Math.min(movement, min);
            return;
        }

        char alphabet = name.charAt(position);
        if (alphabet == 'A') {
            boolean[] copyChecked = new boolean[checked.length];
            for (int i = 0; i < copyChecked.length; i++)
                copyChecked[i] = checked[i];
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt((position + i) % name.length()) == 'A')
                    copyChecked[(position + i) % name.length()] = true;
                else
                    break;
            }

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt((position - i + name.length()) % name.length()) == 'A')
                    copyChecked[(position - i + name.length()) % name.length()] = true;
                else
                    break;
            }
            for (idx = 0; idx < copyChecked.length; idx++) {
                if (!copyChecked[idx])
                    break;
            }
            if (idx == copyChecked.length) {
                min = Math.min(movement-1, min);
                return;
            }
        }

        int front = (position + 1) % name.length();
        int moveCount = 1;
        while (checked[front]){
            front = (front + 1) % name.length();
            moveCount ++;
        }
        checked[front] = true;
        checkRecursive(checked, front, movement + moveCount
                + Math.min(controlUp(name.charAt(front)), controlDown(name.charAt(front))), name);
        checked[front] = false;

        moveCount = 1;
        int back = (position - 1 + name.length()) % name.length();
        while (checked[back]){
            back = (back - 1 + name.length()) % name.length();
            moveCount++;
        }
        checked[back] = true;
        checkRecursive(checked, back, movement + moveCount
                + Math.min(controlUp(name.charAt(back)), controlDown(name.charAt(back))), name);
        checked[back] = false;
    }

    public int controlUp(char want) {
        return want - 'A';
    }

    public int controlDown(char want) {
        return 'Z' - want + 1;
    }
}