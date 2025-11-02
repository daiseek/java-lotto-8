package lotto.view;

import static lotto.validate.InputValidate.validateComma;
import static lotto.validate.InputValidate.validatePositiveInteger;
import static lotto.validate.InputValidate.validateInteger;
import static lotto.util.InputUtil.parseLottoNumbers;
import static lotto.validate.InputValidate.validateRangeLottoNumber;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // 로또 구입 금액을 입력받는 메서드
    public int inputLottoPurchaseAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                int PurchaseAmount = validateInteger(input);
                validatePositiveInteger(PurchaseAmount);
                return PurchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //  - 당첨 번호를 쉼표와 함께 한 줄로 입력받는 메서드
    public List<Integer> inputWinningLottoNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                validateComma(input);
                return parseLottoNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //  - 보너스 번호 입력 메서드
    public int inputBonusNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                // 유효성 검증
                int bonusNumber = validateInteger(input);
                validateRangeLottoNumber(bonusNumber);
                validatePositiveInteger(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
