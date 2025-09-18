package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    // 속성
    private List<Integer> saveList = new ArrayList<>(); // 배열 값을 저장하는 객체 생성

    public int calculate(int firstNum, int secondNum, Operator operator) {

        int result;
        switch (operator) {
            case ADD:
                result = firstNum + secondNum;
                break;
            case SUBTRACT:
                result = firstNum - secondNum;
                break;
            case MULTIPLY:
                result = firstNum * secondNum;
                break;
            case DIVIDE:
                if (firstNum == 0 || secondNum == 0) {
                    throw new ArithmeticException("0을 나누거나 0으로 나눌 수 없습니다!");
                }
                result = firstNum / secondNum;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
        saveList.add(result);
        return result;
    }
    // 생성자 (결과값 반환 및 배열 저장)
    public List<Integer> getSaveList() {
        return saveList;
    }

    // 기능 (초기값 삭제기능 유지)
    public Integer removeResult() {
        if (saveList.isEmpty()) {
            return null;
        }
        return saveList.remove(0);
    }
}



