package lotto.view;

import static lotto.validate.InputValidate.validatePositiveInteger;
import static lotto.validate.InputValidate.validateInteger;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // TODO : 입력 메서드 구현

    // 로또 구입 금액을 입력받는 메서드
    public int inputLottoPurchaseAmount() {
        String input = Console.readLine();
        int PurchaseAmount = validateInteger(input);
        validatePositiveInteger(PurchaseAmount);
        return PurchaseAmount;
    }


    //  - 당첨 번호를 쉼표 기준으로 한 줄로 입력받는 메서드
    //  - 보너스 번호 입력 메서드
}
