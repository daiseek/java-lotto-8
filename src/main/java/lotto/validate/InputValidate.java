package lotto.validate;

public class InputValidate {
    // TODO : 유효성 검증 메서드 구현
    
    //  양의 정수 외의 숫자를 입력하면 에러를 발생시키는 메서드
    public static void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.");
        }
    }

    public static int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.");
        }
    }
}
