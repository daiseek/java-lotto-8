package lotto.dto;

import java.util.List;

// 로또 관련 입력 데이터를 저장하는 클래스
public class LottoDto {

    private int purchaseAmount;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoDto(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static LottoDto of(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoDto(purchaseAmount, winningNumbers, bonusNumber);
    }

}

