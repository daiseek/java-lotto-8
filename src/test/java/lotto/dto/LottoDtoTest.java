package lotto.dto;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoDtoTest {

    @DisplayName("LottoDto 생성자 테스트")
    @Test
    void LottoDto_생성자_테스트() {
        // given
        int purchaseAmount = 8000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoDto lottoDto = new LottoDto(purchaseAmount, winningNumbers, bonusNumber);

        // then
        assertThat(lottoDto).isNotNull();
        assertThat(lottoDto.getPurchaseAmount()).isEqualTo(8000);
        assertThat(lottoDto.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoDto.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("getPurchaseAmount 메서드 테스트")
    @Test
    void getPurchaseAmount_테스트() {
        // given
        LottoDto lottoDto = new LottoDto(8000, List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        int purchaseAmount = lottoDto.getPurchaseAmount();

        // then
        assertThat(purchaseAmount).isEqualTo(8000);
    }

    @DisplayName("getWinningNumbers 메서드 테스트")
    @Test
    void getWinningNumbers_테스트() {
        // given
        LottoDto lottoDto = new LottoDto(8000, List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        List<Integer> winningNumbers = lottoDto.getWinningNumbers();

        // then
        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("getBonusNumber 메서드 테스트")
    @Test
    void getBonusNumber_테스트() {
        // given
        LottoDto lottoDto = new LottoDto(8000, List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        int bonusNumber = lottoDto.getBonusNumber();

        // then
        assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("of 메서드 테스트")
    @Test
    void of_메서드_테스트() {
        // given
        int purchaseAmount = 8000;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        LottoDto lottoDto = LottoDto.of(purchaseAmount, winningNumbers, bonusNumber);

        // then
        assertThat(lottoDto).isNotNull();
        assertThat(lottoDto.getPurchaseAmount()).isEqualTo(8000);
        assertThat(lottoDto.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoDto.getBonusNumber()).isEqualTo(7);
    }
}
