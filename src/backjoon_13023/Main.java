package backjoon_13023;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleCount = sc.nextInt();
        int relationCount = sc.nextInt();

        ArrayList<Integer>[] relations = new ArrayList[peopleCount];
        for(int i = 0; i < peopleCount; i++)
            relations[i] = new ArrayList<>();

        for(int i = 0; i < relationCount; i ++){
            int personFirst = sc.nextInt();
            int personSecond = sc.nextInt();
            relations[personFirst].add(personSecond);
            relations[personSecond].add(personFirst);
        }

        for(int i = 0; i< peopleCount; i++){
            boolean[] check = new boolean[peopleCount];
            check[i] = true;
            if(hasRelation(i,check,relations,1)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static boolean hasRelation(int person ,boolean[] check ,ArrayList<Integer>[] relations, int count) {
        if(count == 5)
            return true;

        ArrayList<Integer> relation = relations[person];
        for(int i = 0; i< relation.size(); i++){
            int friend = relation.get(i);
            if(!check[friend]){
                check[friend] = true;
                if(hasRelation(friend,check,relations,count+1))
                    return true;
                check[friend] = false;
            }
        }
        return false;
    }
}
