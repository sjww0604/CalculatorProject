package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int FirstNum = sc.nextInt(); // 첫번째 입력값 설정
        System.out.print("두 번째 숫자를 입력하세요 : ");
        int SecondNum = sc.nextInt(); // 두번째 입력값 설정
        System.out.print("사칙연산 기호를 입력하세요: ");
        char opration = sc.next().charAt(0); // 연산기호 입력 및 첫 글자만 추출

    }
}
