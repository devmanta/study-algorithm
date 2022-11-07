package day221107;

import java.util.Scanner;

public class Main {
    /*
    3. 최대점수 구하기(DFS)
    설명
    이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
    각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
    제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
    (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

    입력
    첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
    두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.

    출력
    첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.

    예시 입력 1
        5 20
        10 5
        25 12
        15 8
        6 3
        7 4
    예시 출력 1
        41
    */

    static int n;
    static int totalTime;
    static int answer = Integer.MIN_VALUE;

    public static void DFS(int L, int sum, int time, int[] questionCnt, int[] duration) {
        if(time > totalTime) {
            return;
        }

        if(L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + questionCnt[L], time + duration[L], questionCnt, duration);
            DFS(L + 1, sum, time, questionCnt, duration);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] questionCnt = new int[n]; //문제 수
        int[] duration  = new int[n]; // 문제 수를 푸는데 걸리는 시간

        totalTime = sc.nextInt();

        for(int i = 0; i < n; i++) {
            questionCnt[i] = sc.nextInt();
            duration[i] = sc.nextInt();
        }

        DFS(0, 0, 0, questionCnt, duration);

        System.out.println(answer);
    }

}
