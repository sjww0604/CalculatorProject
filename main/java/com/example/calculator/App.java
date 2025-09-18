package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        Scanner sc =  new Scanner(System.in);

        boolean exit = true; // exit 입력 전 값 초기화 진행, 반복문은 true일 때 실행되도록 설계
        while(exit) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            double firstNum = sc.nextDouble(); // 첫번째 입력값 설정 -> 변수명 첫글자만 소문자로 변경
            System.out.print("두 번째 숫자를 입력하세요 : ");
            double secondNum = sc.nextDouble(); // 두번째 입력값 설정
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // 연산기호 입력 및 첫 글자만 추출
            OperatorType operatorType = OperatorType.fromChar(operator);

            Double result = arithmeticCalculator.calculate(firstNum, secondNum, operatorType); // Calculator 계산 클래스 적용
            if(result != null) {
                System.out.println("결과 : " + result);
            } // 반환받은 결과값이 null 이 아닌 경우 반환된 result 값을 공유

            System.out.println("=============================="); // 배열 구분선 추가
            // 저장된 결과값을 보여주는 배열을 하단에 첨부 getter 기능을 활용
            System.out.println("저장된 결과값: " + arithmeticCalculator.getSaveList());
            System.out.print("명령어를 입력하세요. ( y=초기화면 | del=삭제 | big=큰 값 조회 | exit=종료 ) : ");

            // 삭제 기능 추가 및 종료 조건을 만족하기 위해 항상 입력값을 고르게 입력 받아야 하므로 LowerCase(소문자로 치환), trim(공백 제거) 사용
            String choice = sc.next().toLowerCase().trim();

            switch (choice) {
                case "y":
                    continue;
                case "del":
                    Double removeResult = arithmeticCalculator.removeResult();
                    if (removeResult != null) {
                        System.out.println("삭제된 값: " + removeResult);
                    } else {
                        System.out.println("히스토리가 비어 있습니다.");
                    }
                    break;
                case "big": // 기준값 보다 큰 값을 배열로 보여주는 메서드
                    System.out.print("기준값을 입력하세요: ");
                    double scNumStandard = sc.nextDouble();
                    arithmeticCalculator.compareLargeNumPrint(scNumStandard);
                    break;
                case "exit":
                    exit = false;
                    break;
                default:
                    System.out.println("잘못된 명령어를 입력하였습니다. 초기화면으로 돌아갑니다.");
                    continue;
            }
        }
    }
}
