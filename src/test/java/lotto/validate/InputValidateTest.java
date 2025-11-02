package lotto.validate;

import lotto.validate.InputValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {

    @DisplayName("양의 정수 검증 - 정상 케이스")
    @Test
    void validatePositiveInteger_정상_케이스_테스트() {
        // given
        int number = 1000;

        // when & then
        InputValidate.validatePositiveInteger(number);
        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("양의 정수 검증 - 예외 케이스 (0 이하)")
    @Test
    void validatePositiveInteger_예외_케이스_테스트() {
        // given
        int number = 0;

        // when & then
        assertThatThrownBy(() -> InputValidate.validatePositiveInteger(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양의 정수를 입력해야 합니다.");
    }

    @DisplayName("정수 변환 검증 - 정상 케이스")
    @Test
    void validateInteger_정상_케이스_테스트() {
        // given
        String number = "1000";

        // when
        int result = InputValidate.validateInteger(number);

        // then
        assertThat(result).isEqualTo(1000);
    }

    @DisplayName("정수 변환 검증 - 예외 케이스 (숫자가 아님)")
    @Test
    void validateInteger_예외_케이스_테스트() {
        // given
        String number = "abc";

        // when & then
        assertThatThrownBy(() -> InputValidate.validateInteger(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양의 정수를 입력해야 합니다.");
    }

    @DisplayName("로또 번호 범위 검증 - 정상 케이스")
    @Test
    void validateRangeLottoNumber_정상_케이스_테스트() {
        // given
        int number = 10;

        // when & then
        InputValidate.validateRangeLottoNumber(number);
        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("로또 번호 범위 검증 - 예외 케이스 (범위 초과)")
    @Test
    void validateRangeLottoNumber_예외_케이스_테스트() {
        // given
        int number = 50;

        // when & then
        assertThatThrownBy(() -> InputValidate.validateRangeLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("쉼표 포함 검증 - 정상 케이스")
    @Test
    void validateComma_정상_케이스_테스트() {
        // given
        String input = "1,2,3,4,5,6";

        // when & then
        InputValidate.validateComma(input);
        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("쉼표 포함 검증 - 예외 케이스 (쉼표 없음)")
    @Test
    void validateComma_예외_케이스_테스트() {
        // given
        String input = "123456";

        // when & then
        assertThatThrownBy(() -> InputValidate.validateComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 쉼표를 기준으로 파싱할 수 없습니다.");
    }
}
