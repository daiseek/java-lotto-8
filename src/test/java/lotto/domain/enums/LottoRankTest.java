package lotto.domain.enums;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("1등 당첨 일치 개수 확인")
    @Test
    void FIRST_등급_getMatchCount_테스트() {
        // given
        LottoRank lottoRank = LottoRank.FIRST;

        // when
        int matchCount = lottoRank.getMatchCount();

        // then
        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("1등 당첨 금액 확인")
    @Test
    void FIRST_등급_getPrize_테스트() {
        // given
        LottoRank lottoRank = LottoRank.FIRST;

        // when
        int prize = lottoRank.getPrize();

        // then
        assertThat(prize).isEqualTo(2000000000);
    }

    @DisplayName("2등 당첨 일치 개수 확인")
    @Test
    void SECOND_등급_getMatchCount_테스트() {
        // given
        LottoRank lottoRank = LottoRank.SECOND;

        // when
        int matchCount = lottoRank.getMatchCount();

        // then
        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("2등 당첨 금액 확인")
    @Test
    void SECOND_등급_getPrize_테스트() {
        // given
        LottoRank lottoRank = LottoRank.SECOND;

        // when
        int prize = lottoRank.getPrize();

        // then
        assertThat(prize).isEqualTo(30000000);
    }

    @DisplayName("3등 당첨 일치 개수 확인")
    @Test
    void THIRD_등급_getMatchCount_테스트() {
        // given
        LottoRank lottoRank = LottoRank.THIRD;

        // when
        int matchCount = lottoRank.getMatchCount();

        // then
        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("3등 당첨 금액 확인")
    @Test
    void THIRD_등급_getPrize_테스트() {
        // given
        LottoRank lottoRank = LottoRank.THIRD;

        // when
        int prize = lottoRank.getPrize();

        // then
        assertThat(prize).isEqualTo(1500000);
    }

    @DisplayName("4등 당첨 일치 개수 확인")
    @Test
    void FOURTH_등급_getMatchCount_테스트() {
        // given
        LottoRank lottoRank = LottoRank.FOURTH;

        // when
        int matchCount = lottoRank.getMatchCount();

        // then
        assertThat(matchCount).isEqualTo(4);
    }

    @DisplayName("4등 당첨 금액 확인")
    @Test
    void FOURTH_등급_getPrize_테스트() {
        // given
        LottoRank lottoRank = LottoRank.FOURTH;

        // when
        int prize = lottoRank.getPrize();

        // then
        assertThat(prize).isEqualTo(50000);
    }

    @DisplayName("5등 당첨 일치 개수 확인")
    @Test
    void FIFTH_등급_getMatchCount_테스트() {
        // given
        LottoRank lottoRank = LottoRank.FIFTH;

        // when
        int matchCount = lottoRank.getMatchCount();

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("5등 당첨 금액 확인")
    @Test
    void FIFTH_등급_getPrize_테스트() {
        // given
        LottoRank lottoRank = LottoRank.FIFTH;

        // when
        int prize = lottoRank.getPrize();

        // then
        assertThat(prize).isEqualTo(5000);
    }
}
