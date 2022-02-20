package pgm_42587;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Word> printer = new LinkedList<>();
        int maxPrior = 0;
        for (int i = 0; i < priorities.length; i++) {
            maxPrior = maxPrior < priorities[i] ? priorities[i] : maxPrior;
            printer.add(new Word(priorities[i], location == i));
        }

        int count = 0;
        boolean isOk = false;
        while(!isOk){
            Word word = printer.removeFirst();
            if(word.prior == maxPrior){
                count++;
                if(word.isMine)
                    isOk = true;
                else
                    maxPrior = findMaxPrior(printer);
            }
            else{
                printer.addLast(word);
            }
        }

        return count;
    }

    public int findMaxPrior(Deque<Word> deque) {
        int max = 0;
        for (int i = 0; i < deque.size(); i++) {
            Word word = deque.removeFirst();
            max = word.prior > max ? word.prior : max;
            deque.addLast(word);
        }
        return max;
    }

    public class Word {
        int prior;
        boolean isMine;

        public Word(int p, boolean isMine) {
            prior = p;
            this.isMine = isMine;
        }
    }
}