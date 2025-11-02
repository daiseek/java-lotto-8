package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    @DisplayName("로또 컨트롤러 객체 생성 테스트")
    @Test
    void 로또_컨트롤러_객체_생성_테스트() {
        // given & when
        LottoController lottoController = new LottoController();

        // then
        assertThat(lottoController).isNotNull();
    }
}
