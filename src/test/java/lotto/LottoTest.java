package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 리스트 반환 메서드 테스트")
    @Test
    void getLottoNumbers_메서드_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        // then
        assertThat(lottoNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("of 메서드 테스트")
    @Test
    void of_메서드_테스트() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = Lotto.of(numbers);

        // then
        assertThat(lotto).isNotNull();
        assertThat(lotto.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호 오름차순 정렬 메서드 테스트")
    @Test
    void sortLotto_메서드_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(6, 3, 1, 4, 2, 5));

        // when
        lotto.sortLotto();

        // then
        assertThat(lotto.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("개별 로또 번호 비교 메서드 테스트")
    @Test
    void compareLottoNumber_메서드_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumbers = List.of(1, 2, 3, 7, 8, 9);
        int lottoNumber = 1;

        // when
        int result = lotto.compareLottoNumber(winNumbers, lottoNumber);

        // then
        assertThat(result).isEqualTo(1); // 1은 winNumbers에 포함되어 있음
    }

    @DisplayName("로또 번호 리스트 비교 메서드 테스트")
    @Test
    void compareLotto_메서드_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumbers = List.of(1, 2, 3, 7, 8, 9);

        // when
        int matchCount = lotto.compareLotto(winNumbers);

        // then
        assertThat(matchCount).isEqualTo(3); // 1, 2, 3이 일치
    }

    @DisplayName("보너스 번호 포함 여부 확인 메서드 테스트")
    @Test
    void containBonusNumber_메서드_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        boolean result = lotto.containBonusNumber(bonusNumber);

        // then
        assertThat(result).isFalse(); // 7은 로또 번호에 없음
    }
}
