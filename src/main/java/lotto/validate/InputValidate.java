package lotto.validate;

public class InputValidate {
    // TODO : 유효성 검증 메서드 구현
    
    //  양의 정수 외의 숫자를 입력하면 에러를 발생시키는 메서드
    public static void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.");
        }
    }

    //  정수 외의 숫자를 입력하면 에러를 발생시키는 메서드
    public static int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해야 합니다.");
        }
    }

    //  로또 번호 범위 검사 메서드
    public static void validateRangeLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 쉼표를 기준으로 파싱할 수 없을때 예외 처리 메서드
    public static void validateComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 쉼표를 기준으로 파싱할 수 없습니다.");
        }
    }
}
