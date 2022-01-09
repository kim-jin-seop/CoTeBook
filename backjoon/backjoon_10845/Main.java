package backjoon_10845;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue queue = new Queue();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String input = br.readLine();
            switch (input.split(" ")[0]) {
                case "push":
                    queue.push(Integer.parseInt(input.split(" ")[1]));
                    break;
                case "pop":
                    int popVal = queue.pop();
                    bw.write(String.valueOf(popVal));
                    bw.newLine();
                    break;
                case "size":
                    int size = queue.size();
                    bw.write(String.valueOf(size));
                    bw.newLine();
                    break;
                case "empty":
                    boolean isEmpty = queue.isEmpty();
                    bw.write(isEmpty ? String.valueOf(1) : String.valueOf(0));
                    bw.newLine();
                    break;
                case "front" :
                    int front = queue.front();
                    bw.write(String.valueOf(front));
                    bw.newLine();
                    break;
                case "back" :
                    int back = queue.back();
                    bw.write(String.valueOf(back));
                    bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Queue {
        private int list[] = new int[10000];
        private int front = 0;
        private int back = 0;

        public boolean push(int X) {
            list[front++] = X;
            return true;
        }

        public int pop() {
            if(isEmpty())
                return -1;
            return list[back++];
        }

        public int size() {
            return front - back;
        }

        public boolean isEmpty() {
            return front == back;
        }

        public int front() {
            if (isEmpty())
                return -1;
            return list[back];
        }

        public int back() {
            if (isEmpty())
                return -1;
            return list[front - 1];
        }
    }
}
