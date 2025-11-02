package lotto.error;

public class ErrorMessage {

    //  - 양의 정수 외의 숫자 입력시 에러 메시지
    public static final String INVALID_POSITIVE_INTEGER_MESSAGE = "[ERROR] 양의 정수를 입력해야 합니다.";
    //  - 로또 번호 중복 에러 메시지
    public static final String INVALID_DUPLICATE_LOTTO_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    //  - 로또 번호 범위 초과 에러 메시지
    public static final String INVALID_OVER_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    // 쉼표 기준 파싱할때 에러 메시지
    public static final String INVALID_COMMA_MESSAGE = "[ERROR] 쉼표를 기준으로 파싱할 수 없습니다.";
    // 로또 번호가 6개가 아닐때 에러 메시지
    public static final String INVALID_NUMBERS_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
}
