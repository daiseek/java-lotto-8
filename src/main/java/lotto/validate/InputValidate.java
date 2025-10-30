package lotto.validate;

import lotto.error.ErrorMessage;

public class InputValidate {
    // TODO : 유효성 검증 메서드 구현
    
    //  양의 정수 외의 숫자를 입력하면 에러를 발생시키는 메서드
    public static void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITIVE_INTEGER_MESSAGE);
        }
    }

    //  정수 외의 숫자를 입력하면 에러를 발생시키는 메서드
    public static int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITIVE_INTEGER_MESSAGE);
        }
    }

    //  로또 번호 범위 검사 메서드
    public static void validateRangeLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OVER_LOTTO_NUMBER_MESSAGE);
        }
    }

    // 쉼표를 기준으로 파싱할 수 없을때 예외 처리 메서드
    public static void validateComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COMMA_MESSAGE);
        }
    }
}
