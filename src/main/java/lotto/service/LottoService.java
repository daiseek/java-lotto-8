package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.util.InputUtil;

public class LottoService {
    // TODO : Lotto 관련 로직을 모아서 비즈니스 로직 구현 

    private static final int LOTTO_PRICE = 1000;
    private int lottoCount;

    // 로또 구매 후 로또 개수 반환 메서드 
    public int purchaseLotto(int purchaseAmount) {
        lottoCount = purchaseAmount / LOTTO_PRICE;
        return lottoCount;
    }

    // 로또 생성 메서드
    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = InputUtil.generateLotto();
            Lotto lotto = Lotto.of(lottoNumbers);
            lottos.add(lotto);
    } 
        return lottos;
    }

    // 로또 당첨 확인


    //  보너스 번호와 로또 번호를 비교하는 메서드

    // 수익률 계산 메서드


}
