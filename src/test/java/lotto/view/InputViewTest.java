package lotto.view;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// InputView는 UI 로직(Console.readLine())을 포함하므로 단위 테스트 작성을 하지 않음.
// ApplicationTest.java에서 통합 테스트로 전체 흐름을 검증 중
class InputViewTest {

    @DisplayName("InputView 객체 생성 테스트")
    @Test
    void InputView_객체_생성_테스트() {
        // given & when
        InputView inputView = new InputView();

        // then
        assertThat(inputView).isNotNull();
    }
}
