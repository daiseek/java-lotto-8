package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
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
            lotto.sortLotto();
            lottos.add(lotto);
    } 
        return lottos;
    }

    // 로또 당첨 확인
    public Map<LottoRank, Integer> checkLottoPrize(List<Lotto> lottos,
                                                   List<Integer> winningNumbers,
                                                   int bonusNumber) {
        
        LottoRank rank; // 당첨 순위 변수
        int prize; // 당첨 금액

        // 당첨 순위와 당첨 금액을 저장하는 맵
        Map<LottoRank, Integer> prizeMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.compareLotto(winningNumbers); // 당첨 번호 일치 개수
            
            if (matchCount == 6) {
                rank = LottoRank.FIRST;
                prize = LottoRank.FIRST.getPrize();
                prizeMap.put(rank, prizeMap.getOrDefault(rank, 0) + 1);
                continue;
            } 
            if (matchCount == 5 && lotto.containBonusNumber(bonusNumber)) {
                rank = LottoRank.SECOND;
                prize = LottoRank.SECOND.getPrize();
                prizeMap.put(rank, prizeMap.getOrDefault(rank, 0) + 1);
                continue;
            }
            if (matchCount == 5) {
                rank = LottoRank.THIRD;
                prize = LottoRank.THIRD.getPrize();
                prizeMap.put(rank, prizeMap.getOrDefault(rank, 0) + 1);
                continue;
            }
            if (matchCount == 4) {
                rank = LottoRank.FOURTH;
                prize = LottoRank.FOURTH.getPrize();
                prizeMap.put(rank, prizeMap.getOrDefault(rank, 0) + 1);
                continue;
            }
            if (matchCount == 3) {
                rank = LottoRank.FIFTH;
                prize = LottoRank.FIFTH.getPrize();
                prizeMap.put(rank, prizeMap.getOrDefault(rank, 0) + 1);
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
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : prizeMap.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return (double) totalPrize / purchaseAmount;
    }
}


