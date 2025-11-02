package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilTest {

    @DisplayName("로또 번호 생성 메서드 테스트")
    @Test
    void generateLotto_메서드_테스트() {
        // when
        List<Integer> lottoNumbers = InputUtil.generateLotto();

        // then
        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers).hasSize(6);
        lottoNumbers.forEach(number -> {
            assertThat(number).isBetween(1, 45);
        });
        // 중복 없는지 확인
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);
    }

    @DisplayName("로또 번호 파싱 메서드 테스트")
    @Test
    void parseLottoNumbers_메서드_테스트() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> result = InputUtil.parseLottoNumbers(input);

        // then
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("쉼표와 공백이 포함된 로또 번호 파싱 메서드 테스트")
    @Test
    void parseLottoNumbers_공백_포함_테스트() {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when
        List<Integer> result = InputUtil.parseLottoNumbers(input);

        // then
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
