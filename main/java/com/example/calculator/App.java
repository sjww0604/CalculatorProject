package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();
        Scanner sc =  new Scanner(System.in);

        boolean exit = true; // exit 입력 전 값 초기화 진행, 반복문은 true일 때 실행되도록 설계
        while(exit) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int firstNum = sc.nextInt(); // 첫번째 입력값 설정 -> 변수명 첫글자만 소문자로 변경
            System.out.print("두 번째 숫자를 입력하세요 : ");
            int secondNum = sc.nextInt(); // 두번째 입력값 설정
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // 연산기호 입력 및 첫 글자만 추출

            Integer result = calculator.calculate(firstNum, secondNum, operator); // Calculator 계산 클래스 적용
            if(result != null) {
                System.out.println("결과 : " + result);
            } // 반환받은 결과값이 null 이 아닌 경우 반환된 result 값을 공유

            System.out.println("=============================="); // 배열 구분선 추가
            // 저장된 결과값을 보여주는 배열을 하단에 첨부 getter 기능을 활용
            System.out.println("저장된 결과값: " + calculator.getSaveList());
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");

            // "exit"라는 글자를 입력받아야하는데 항상 고르게 입력 받아야 하므로 LowerCase(소문자로 치환), trim(공백 제거) 사용
            String choice = sc.next().toLowerCase().trim();
            if (choice.equals("exit")) {
                exit = false;
            }
        }

    }
}
