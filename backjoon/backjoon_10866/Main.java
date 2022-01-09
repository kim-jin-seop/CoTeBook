package backjoon_10866;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque deque = new Deque();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String input = br.readLine();
            switch (input.split(" ")[0]) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(input.split(" ")[1]));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(input.split(" ")[1]));
                    break;
                case "pop_front":
                    int popVal = deque.popFront();
                    bw.write(String.valueOf(popVal));
                    bw.newLine();
                    break;
                case "pop_back":
                    popVal = deque.popBack();
                    bw.write(String.valueOf(popVal));
                    bw.newLine();
                    break;
                case "size":
                    int size = deque.size();
                    bw.write(String.valueOf(size));
                    bw.newLine();
                    break;
                case "empty":
                    boolean isEmpty = deque.isEmpty();
                    bw.write(isEmpty ? String.valueOf(1) : String.valueOf(0));
                    bw.newLine();
                    break;
                case "front" :
                    int front = deque.front();
                    bw.write(String.valueOf(front));
                    bw.newLine();
                    break;
                case "back" :
                    int back = deque.back();
                    bw.write(String.valueOf(back));
                    bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Deque{
        int[] list = new int[10000];
        int listSize = 10000;
        int front = 0;
        int back = 0;

        public boolean isEmpty(){
            return front == back;
        }
        public void pushFront(int X){
            list[(front++ + listSize)%listSize] = X;
        }

        public void pushBack(int X){
            list[(--back+listSize)%listSize] = X;
        }

        public int popFront(){
            if(isEmpty())
                return -1;
            return list[(--front+listSize)%listSize];
        }

        public int popBack(){
            if(isEmpty())
                return -1;
            return list[(back++ + listSize)%listSize];
        }

        public int size(){
            return front - back;
        }

        public int front(){
            if(isEmpty())
                return -1;
            return list[(front - 1 + listSize)%listSize];
        }

        public int back(){
            if(isEmpty())
                return -1;
            return list[(back + listSize)%listSize];
        }
    }
}
