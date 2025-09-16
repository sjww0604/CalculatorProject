package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        boolean exit = true; // exit 입력 전 값 초기화 진행, 반복문은 true일 때 실행되도록 설계
        while(exit) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int firstNum = sc.nextInt(); // 첫번째 입력값 설정 -> 변수명 첫글자만 소문자로 변경
            System.out.print("두 번째 숫자를 입력하세요 : ");
            int secondNum = sc.nextInt(); // 두번째 입력값 설정
            System.out.print("사칙연산 기호를 입력하세요: ");
            char opration = sc.next().charAt(0); // 연산기호 입력 및 첫 글자만 추출

            int result = 0; // 계산값 저장 변수 result  설정
            if (firstNum > 0 && secondNum > 0) {
                switch (opration) {
                    case '+':
                        result = firstNum + secondNum;
                        System.out.println("결과: " + result);
                        break;
                    case '-':
                        result = firstNum - secondNum;
                        System.out.println("결과:" + result);
                        break;
                    case '*':
                        result = firstNum * secondNum;
                        System.out.println("결과:" + result);
                        break;
                    case '/':
                        result = firstNum / secondNum;
                        System.out.println("결과:" + result);
                        break;
                    default:
                        System.out.println("올바른 사칙연산 기호를 입력하세요");
                }
            } else {
                System.out.println("0 이상의 정수를 입력해주세요!"); // 0 이상의 입력값 검증 진행
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            String choice = sc.next().toLowerCase().trim();
            // "exit"라는 글자를 입력받아야하는데 항상 고르게 입력 받아야 하므로 LowerCase(소문자로 치환), trim(공백 제거) 사용
            if (choice.equals("exit")) {
                exit = false;
            }
        }

    }
}
