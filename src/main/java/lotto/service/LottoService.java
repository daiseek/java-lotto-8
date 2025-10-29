package lotto.service;

public class LottoService {
    // TODO : Lotto 관련 로직을 모아서 비즈니스 로직 구현 

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    // 로또 구매 후 로또 개수 반환 메서드 
    public int purchaseLotto(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    // 로또 당첨 확인 메서드

    // 수익률 계산 메서드


}
