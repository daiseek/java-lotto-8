package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
import lotto.util.InputUtil;

public class LottoService {

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
    public Map<LottoRank, Integer> checkLottoPrize(List<Lotto> lottos,
                                                   List<Integer> winningNumbers,
                                                   int bonusNumber) {
        
        // 당첨 등급별 개수를 저장하는 맵
        Map<LottoRank, Integer> prizeMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.compareLotto(winningNumbers); // 당첨 번호 일치 개수

            if (matchCount == 6) {
                prizeMap.put(LottoRank.FIRST, prizeMap.getOrDefault(LottoRank.FIRST, 0) + 1);
                continue;
            }
            if (matchCount == 5 && lotto.containBonusNumber(bonusNumber)) {
                prizeMap.put(LottoRank.SECOND, prizeMap.getOrDefault(LottoRank.SECOND, 0) + 1);
                continue;
            }
            if (matchCount == 5) {
                prizeMap.put(LottoRank.THIRD, prizeMap.getOrDefault(LottoRank.THIRD, 0) + 1);
                continue;
            }
            if (matchCount == 4) {
                prizeMap.put(LottoRank.FOURTH, prizeMap.getOrDefault(LottoRank.FOURTH, 0) + 1);
                continue;
            }
            if (matchCount == 3) {
                prizeMap.put(LottoRank.FIFTH, prizeMap.getOrDefault(LottoRank.FIFTH, 0) + 1);
                continue;
            }
            if (matchCount < 3) {
                continue;
            }
        }
        return prizeMap; // 당첨 순위와 당첨 금액이 저장된 맵 반환
    }

    // 수익률 계산 메서드
    public double calculateProfitRate(Map<LottoRank, Integer> prizeMap, int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : prizeMap.entrySet()) {
            totalPrize += (long) entry.getKey().getPrize() * entry.getValue();
        }
        return Math.round(totalPrize * 100.0 / purchaseAmount * 100.0) / 100.0;
    }
}


