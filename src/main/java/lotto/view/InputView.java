package lotto.view;

import static lotto.validate.InputValidate.validateComma;
import static lotto.validate.InputValidate.validatePositiveInteger;
import static lotto.validate.InputValidate.validateInteger;
import static lotto.util.InputUtil.parseLottoNumbers;

import java.util.List;

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

    //  - 당첨 번호를 쉼표와 함께 한 줄로 입력받는 메서드
    public List<Integer> inputWinningLottoNumbers() {
        String input = Console.readLine();
        validateComma(input);
        return parseLottoNumbers(input);
    }
    //  - 보너스 번호 입력 메서드
}
