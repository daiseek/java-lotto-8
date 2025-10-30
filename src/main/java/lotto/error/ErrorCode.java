package lotto.error;

public class ErrorCode {
    // TODO : 에러 코드 정의
    //  - 양의 정수 외의 숫자 입력시 에러 코드
    public static final String INVALID_INPUT_INTEGER = "INVALID_INPUT_INTEGER";
    //  - 로또 번호 중복 에러 코드
    public static final String INVALID_DUPLICATE_LOTTO = "INVALID_DUPLICATE_LOTTO";
    //  - 로또 번호 범위 초과 에러 코드
    public static final String INVALID_OVER_LOTTO_NUMBER = "INVALID_OVER_LOTTO_NUMBER";
    // 쉼표 기준 파싱할때 에러 코드
    public static final String INVALID_COMMA = "INVALID_COMMA";


}
