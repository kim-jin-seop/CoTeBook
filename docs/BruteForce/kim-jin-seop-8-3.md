# ★★☆☆☆ 피로도
- 난이도 : ★★☆☆☆
- <a href="https://programmers.co.kr/learn/courses/30/lessons/87946">문제 바로가기</a>
- <a href="https://cnu-jinseop.tistory.com/143">풀이 바로가기</a>
- 사용 언어 : Java

### 구현코드
```java
package pgm_87946;

public class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] permutation = new int[dungeons.length];
        for(int i = 0; i < permutation.length; i++){
            permutation[i] = i;
        }
        int max = 0;
        do{
            //모든 경우에 대해 던전을 돌고 최대값을 찾아준다.
            int count = doDungeons(permutation, dungeons, k);
            max = max > count ? max : count;
        }while (nextPermutation(permutation));
        return max;
    }

        //정해진 순서로 던전을 입장했을 때 입장한 던전의 수
        public int doDungeons(int[] permutation, int[][] dungeons, int p){
            int count = 0;
            for(int i = 0; i < permutation.length; i++){
                //피로도가 던전입장을 위한 최소 피로도보다 작은경우
                if(dungeons[permutation[i]][0] <= p){
                    p -= dungeons[permutation[i]][1];
                    count++;
                }
            }
            return count;
        }

    //순열의 다음 위치를 찾아주기
    private boolean nextPermutation(int[] numbers){
        int prevIndex;
        int n = numbers.length;
        int nextIndex = n-1;
        int changeIndex = -1;

        for(int i = n-2; i >= 0; i--){
            prevIndex = nextIndex;
            nextIndex = i;

            if(numbers[nextIndex] < numbers[prevIndex]){
                changeIndex = nextIndex;
                break;
            }
        }

        if(changeIndex == -1)
            return false;

        for(int i = n-1; i > changeIndex; i--){
            if(numbers[i] > numbers[changeIndex]){
                swap(numbers, i, changeIndex);
                break;
            }
        }
        while(++changeIndex < --n){
            swap(numbers,changeIndex,n);
        }
        return true;
    }

    //배열의 순서변경
    private void swap(int[] numbers, int a, int b){
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}

```

---
<Comment />
