package com.example.calculator;

import java.util.function.DoubleBinaryOperator;

// 사칙연산을 처리할 Enum 타입
public enum OperatorType {
    // enum 내 사칙연산을 람다식으로 직접 구현
    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> {
        if (b==0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private final DoubleBinaryOperator operator;

    OperatorType(DoubleBinaryOperator operator) {
        this.operator = operator;
    }

    // 연산처리 진행 및 값을 반환시켜줄 메서드 생성
    public double apply(double a, double b) {
        return operator.applyAsDouble(a, b);
    }

    /* App.java에서 입력받은 사칙연산 값을 변환하는 메서드 추가
    (문제 요건에서는 charAt()을 사용하도록 유도했으므로 char 기준으로 작업 진행)
     */
    public static OperatorType fromChar(char c) {
        switch(c) {
            case '+': return ADD; // + 가 입력되었을 때 ADD 상수 반환
            case '-': return SUBTRACT; // - 가 입력되었을 때 ADD 상수 반환
            case '*': return MULTIPLY; // * 가 입력되었을 때 ADD 상수 반환
            case '/': return DIVIDE; // / 가 입력되었을 때 ADD 상수 반환
            default: throw new IllegalArgumentException("지원하지 않는 연산자입니다!");
        }
    }
}

/*
 기본적으로 모든 enum은 java.lang.Enum<T> 클래스를 상속함 그로 인해 타입 안정성 + 공통 기능 + 컴파일러 지원을 모두 누릴 수 있다.
public final class OperatorType extends Enum<OperatorType> {
    // 1. 상수(객체), ordinal은 상수가 선언된 순서를 0부터 매긴 값
    public static final OperatorType ADD = new OperatorType("ADD", 0);
    public static final OperatorType SUBTRACT = new OperatorType("SUBTRACT", 1);
    public static final OperatorType MULTIPLY = new OperatorType("MULTIPLY", 2);
    public static final OperatorType DIVIDE = new OperatorType("DIVIDE", 3);

    // 2. 모든 상수를 보관하는 배열
    private static final OperatorType[] VALUES = { ADD, SUBTRACT, MULTIPLY, DIVIDE };

    // 3. private 생성자 (외부에서 new 불가)
    private OperatorType(String name, int ordinal) {
        super(name, ordinal);
    }

    // 4. values(), valueOf() 메서드 자동 생성 - 원본 배열을 보호하고 값을 찾을 수 있게 도와주는 메서드
    public static OperatorType[] values() { return VALUES.clone(); }
    public static OperatorType valueOf(String name) { ... }
}
*/

