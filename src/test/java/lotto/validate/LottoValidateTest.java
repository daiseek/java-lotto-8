package lotto.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidateTest {

    @DisplayName("로또 번호 중복 검증 - 정상 케이스")
    @Test
    void validateDuplicateLotto_정상_케이스_테스트() {
        // given
        LottoValidate lottoValidate = new LottoValidate();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        lottoValidate.validateDuplicateLotto(lottoNumbers);
        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("로또 번호 중복 검증 - 예외 케이스 (중복 존재)")
    @Test
    void validateDuplicateLotto_예외_케이스_테스트() {
        // given
        LottoValidate lottoValidate = new LottoValidate();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> lottoValidate.validateDuplicateLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("로또 번호 범위 검증 - 정상 케이스")
    @Test
    void validateOverLottoNumber_정상_케이스_테스트() {
        // given
        LottoValidate lottoValidate = new LottoValidate();
        int lottoNumber = 10;

        // when & then
        lottoValidate.validateOverLottoNumber(lottoNumber);
        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("로또 번호 범위 검증 - 예외 케이스 (범위 초과)")
    @Test
    void validateOverLottoNumber_예외_케이스_테스트() {
        // given
        LottoValidate lottoValidate = new LottoValidate();
        int lottoNumber = 50;

        // when & then
        assertThatThrownBy(() -> lottoValidate.validateOverLottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호 리스트 범위 검증 - 정상 케이스")
    @Test
    void validateRangeLotto_정상_케이스_테스트() {
        // given
        LottoValidate lottoValidate = new LottoValidate();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        lottoValidate.validateRangeLotto(lottoNumbers);
        // 예외가 발생하지 않으면 테스트 통과
    }

    @DisplayName("로또 번호 리스트 범위 검증 - 예외 케이스 (범위 초과 번호 존재)")
    @Test
    void validateRangeLotto_예외_케이스_테스트() {
        // given
        LottoValidate lottoValidate = new LottoValidate();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 50);

        // when & then
        assertThatThrownBy(() -> lottoValidate.validateRangeLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
