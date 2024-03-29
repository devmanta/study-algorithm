package day220729;

import java.util.Scanner;

public class Main {

//    3. 최대 매출
//    설명
//    현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
//        만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
//12 15 11 20 2510 20 19 13 15
//    연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
//    여러분이 현수를 도와주세요.
//
//        입력
//    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
//    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
//
//    출력
//    첫 줄에 최대 매출액을 출력합니다.
//
//    예시 입력 1
//        10 3
//        12 15 11 20 25 10 20 19 13 15
//    예시 출력 1
//        56

    public static int solution(int n, int m, int[] arr) {
        int sum = 0;

        for(int i = 0; i < m; i++) {
            sum += arr[i];
        }

        int answer = sum;

        for(int i = m; i < n; i++) {
            sum = sum + arr[i] - arr[i - m];
            if(answer < sum){
                answer = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr1 = new int[n];

        int m = s.nextInt();

        for(int i = 0; i < n; i++) {
            arr1[i] = s.nextInt();
        }

        System.out.println(solution2(n, m, arr1));
    }

    public static int solution2(int n, int m, int[] arr) {
        // n: n일 간의 매출
        // m: 연속 된 m일 간의 매출 합 최대를 구하는 거
        // arr: n일간 매일 매출 배열
        int answer = 0;

        int sum = 0;
        for(int i = 0; i < m; i++) {
            sum += arr[i];
        }

        answer = sum;

        for(int i = m; i < n; i++) {
            sum -= arr[i - m];
            sum += arr[i];

            if(answer < sum) {
                answer = sum;
            }
        }

        return answer;
    }
}
