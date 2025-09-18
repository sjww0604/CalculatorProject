package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

/* 다양한 타입을 받을 수 있도록 제네릭 타입 설정
단, 입력은 다양한 타입으로 되나 내부적으로는 double 형태로 값을 바꿔 계산
 */
public class ArithmeticCalculator<T extends Number> {
    // 속성
    private List<Double> saveList = new ArrayList<>(); // 배열 값을 저장하는 객체 생성

    public double calculate(T firstNum, T secondNum, OperatorType operatorType) {
        double a = firstNum.doubleValue();
        double b = secondNum.doubleValue();
        double result;

        switch (operatorType) {
            case ADD:
                result = a + b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다!");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
        saveList.add(result);
        return result;
    }
    // 생성자 (결과값 반환 및 배열 저장)
    public List<Double> getSaveList() {
        return saveList;
    }

    // 기능 (초기값 삭제기능 유지)
    public Double removeResult() {
        if (saveList.isEmpty()) {
            return null;
        }
        return saveList.remove(0);
    }

    // 입력받은 값보다 큰 값 출력 메서드
    public List<Double> compareLargeNumPrint (double scNumStandard) {
        return saveList.stream()
                .filter(v -> v > scNumStandard) // 람다식 활용 scNumStandard(기준값 = 입력받은 값을 기준으로)
                .sorted()
                .toList();
    }
}



