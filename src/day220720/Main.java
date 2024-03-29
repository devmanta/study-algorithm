package day220720;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

//    12. 멘토링
//        설명
//
//    현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
//    멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
//    선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
//    만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
//    M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
//
//
//    입력
//    첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
//    두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
//    만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
//
//    출력
//    첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
//
//
//    예시 입력 1
//        4 3
//        3 4 1 2
//        4 3 2 1
//        3 1 4 2
//    예시 출력 1
//        3
//    힌트
//
//        출력설명
//        (3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.

    public static int solution(int[][] arr, int n, int m) {
        /*
        n = 학생수(열), m = 시험 본 횟수(행)
        1번 학생은 1번,2번,3번,4번 학생과 페어링을 확인
        2번 학생도 1번,2번,3번,4번 학생과 페어링을 확인
        --> n으로 2중 포문

        Step1)
        그리고, 1,2 페어링일 때 1,2의 등수를 가져와야함 --> 학생수만큼 n포문
        등수를 가져와서 1번 등수가 2번 등수보다 위에면은 cnt++

        Step2)
        Step1을 m번 (시험본 횟수) 만큼 해서 --> m포문

        cnt가 시험본 횟수랑 똑같으면 페어링 가능한 거임
        */

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int cnt = 0;
                for(int k = 0; k < m; k++) {
                    int pi=0;
                    int pj=0; //i학생 j학생의 점수
                    for(int s = 0; s < n; s++) { //등수
                        if(arr[k][s]==i) pi = s;
                        if(arr[k][s]==j) pj = s;
                    }
                    if (pi < pj) { //i학생 등수가 j학생 등수보다 높으면 cnt++
                        cnt++;
                    }
                }
                if(cnt == m){
                    answer++;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); //학생 수
        int m = s.nextInt(); //시험 본 횟수

        int[][] arr = new int [m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        System.out.println(solution(arr, n, m));
    }

}
