package com.example.calculator;

// 사칙연산을 처리할 Enum 타입
public enum OperatorType {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
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

