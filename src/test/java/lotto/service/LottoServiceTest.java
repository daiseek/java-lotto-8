package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @DisplayName("로또 구매 후 로또 개수 반환 메서드 테스트")
    @Test
    void purchaseLotto_메서드_테스트() {
        // given
        LottoService lottoService = new LottoService();
        int purchaseAmount = 8000;

        // when
        int lottoCount = lottoService.purchaseLotto(purchaseAmount);

        // then
        assertThat(lottoCount).isEqualTo(8);
    }

    @DisplayName("로또 생성 메서드 테스트")
    @Test
    void generateLottos_메서드_테스트() {
        // given
        LottoService lottoService = new LottoService();
        lottoService.purchaseLotto(5000); // 5장 구매 설정

        // when
        List<Lotto> lottos = lottoService.generateLottos();

        // then
        assertThat(lottos).isNotNull();
        assertThat(lottos).hasSize(5);
        lottos.forEach(lotto -> {
            assertThat(lotto).isNotNull();
            assertThat(lotto.getLottoNumbers()).hasSize(6);
        });
    }

    @DisplayName("로또 당첨 확인 메서드 테스트")
    @Test
    void checkLottoPrize_메서드_테스트() {
        // given
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = List.of(
            Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
            Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
            Lotto.of(List.of(1, 2, 3, 4, 5, 8)),
            Lotto.of(List.of(1, 2, 3, 4, 9, 10)),
            Lotto.of(List.of(1, 2, 3, 11, 12, 13)),
            Lotto.of(List.of(1, 2, 14, 15, 16, 17))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        Map<LottoRank, Integer> prizeMap = lottoService.checkLottoPrize(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(prizeMap.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(prizeMap.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(prizeMap.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(prizeMap.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(prizeMap.get(LottoRank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률 계산 메서드 테스트")
    @Test
    void calculateProfitRate_메서드_테스트() {
        // given
        LottoService lottoService = new LottoService();
        Map<LottoRank, Integer> prizeMap = Map.of(
            LottoRank.FIRST, 0,
            LottoRank.SECOND, 0,
            LottoRank.THIRD, 1,
            LottoRank.FOURTH, 1,
            LottoRank.FIFTH, 1
        );
        int purchaseAmount = 5000; // 5,000원 구입

        // when
        double profitRate = lottoService.calculateProfitRate(prizeMap, purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo(31100.0);
    }
}
