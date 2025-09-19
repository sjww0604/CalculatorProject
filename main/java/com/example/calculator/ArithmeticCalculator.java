package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

/* 다양한 타입을 받을 수 있도록 제네릭 타입 설정
단, 입력은 다양한 타입으로 되나 내부적으로는 double 형태로 값을 바꿔 계산
 */
public class ArithmeticCalculator<T extends Number> {
    // 속성
    private List<Double> saveList = new ArrayList<>(); // 배열 값을 저장하는 객체 생성

    public List<Double> getSaveList() { // 저장값을 얻은 배열을 저장하는 getter 생성
        return saveList;
    }

    public void addResult(double result) {
        saveList.add(result);
    } // 결과값을 배열에 저장


    public double calculate(T firstNum, T secondNum, OperatorType operatorType) {
        double a = firstNum.doubleValue();
        double b = secondNum.doubleValue();
        double result = operatorType.apply(a, b); // 결과값에는 연산처리가 적용된 값을 result에 넣어줌
        saveList.add(result);
        return result;
    }

        // 기능 (초기값 삭제기능 유지)
        public Double removeResult () {
            if (saveList.isEmpty()) {
                return null;
            }
            return saveList.remove(0);
        }

        // 입력받은 값보다 큰 값 출력 메서드
        public List<Double> compareLargeNumPrint ( double scNumStandard){
            List<Double> largeFilter = saveList.stream()
                    .filter(v -> v > scNumStandard) // 람다식 활용 scNumStandard(기준값 = 입력받은 값을 기준으로)
                    .sorted()
                    .toList();
            if (saveList.isEmpty()) {
                System.out.println("히스토리가 비어 있습니다.");
            } else if (largeFilter.isEmpty()) {
                System.out.println("기준값보다 큰 값이 없습니다.");
            } else {
                System.out.println("기준값 보다 큰 값은 " + largeFilter + "입니다.");
            }
            return largeFilter;
        }

        // 입력받은 값들의 평균을 구하는 메서드
        public Double averageResult () {
            double average;
            double total = saveList.stream()
                    .mapToDouble(Double::doubleValue).sum(); // stream에서 mapToDouble을 사용함으로서 리스트 안의 객체들을 기본형 double로 변환
            if (saveList.isEmpty()) {
                System.out.println("히스토리가 비어 있습니다.");
                return 0.0;
            } else {
                average = total / saveList.size(); // 저장된 배열의 길이 = 현재까지 입력받은 입력값 갯수
                System.out.println("현재까지 저장된 값의 평균은 : " + average + "입니다.");
                return average;
            }
        }

        // 총합 계산 및 출력 메서드
        public Double sumResult () {
            double total = saveList.stream()
                    .mapToDouble(Double::doubleValue).sum();
            if (saveList.isEmpty()) {
                System.out.println("히스토리가 비어 있습니다.");
                return 0.0;
            } else {
                System.out.println("현재까지 저장된 값의 총합은 : " + total + "입니다.");
                return total;
            }
        }
    }


