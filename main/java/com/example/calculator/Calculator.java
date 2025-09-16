package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
     private List<Integer> saveList = new ArrayList<>(); // 값을 저장하는 배열형태의 컬렉션 필드 선언 및 생성

        public int calculate(int firstNum, int secondNum, char operation){ //계산 메서드
            int result = 0; // 결과값 저장 변수 설정

            switch (operation) {
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-':
                    result = firstNum - secondNum;
                    break;
                case '*':
                    result = firstNum * secondNum;
                    break;
                case '/':
                    if (secondNum != 0) {
                        result = firstNum / secondNum;
                    } else {
                        throw new ArithmeticException("0으로 나눌 수 없습니다."); // 예외 처리에 대한 함수 설정
                    }
                    break;
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자입니다." + operation);
            }

            // 연산 결과 컬렉션 저장
            saveList.add(result);

            // 결과 반환
            return result;
        }

    }

