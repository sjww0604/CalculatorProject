package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 값을 저장하는 배열형태의 컬렉션 필드 선언 및 생성
    private 접근제한자 설정으로 외부 클래스에서 접근 불가
     */
     private List<Integer> saveList = new ArrayList<>();

     // 게터(Getter) 메서드 설정
    public List<Integer> getSaveList() {
        return saveList;
    }

    // 세터(setter) 메서드 설정 (필요 시 사용 - 보편적으로는 사용하지 않음)
    public void setSaveList(List<Integer> saveList) {
        this.saveList = saveList;
    }

        public Integer calculate(int firstNum, int secondNum, char operation) { //계산 메서드
            if (firstNum < 0 || secondNum < 0) {
                System.out.println("양의 정수를 입력하세요.");
                return null;
            }
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
                        if ( secondNum == 0) {
                            System.out.println("0으로 나눌 수 없습니다."); // Early return 개념을 확인하여 작성할 것
                            return null;
                        }
                        result = firstNum / secondNum;
                        break;
                    default:
                        System.out.println("올바른 사칙연산 기호를 입력하세요.");
                        return null;
                }
                saveList.add(result);
                return result;
        }

        // 삭제 메서드 선언 및 기능 설정 FIFO 개념의 문제요건을 추가 정리
        public Integer removeResult() {
            if (saveList.isEmpty()) {
                return null;
            } else {
                return saveList.remove(0);
            }
        }
 }
