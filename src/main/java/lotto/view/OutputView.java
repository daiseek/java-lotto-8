package lotto.view;

import java.util.Map;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;

public class OutputView {

    public void printLottos(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        // 구입한 로또 리스트를 출력
        for (Lotto lotto : lottos) {
            List<Integer> sortedLottoNumbers = lotto.getLottoNumbers().stream()
                .sorted()
                .toList();

            System.out.println("[" + sortedLottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]");
        }
    }

    //  - 당첨 내역 출력 메서드
    public void printWinningRecord(Map<LottoRank, Integer> prizeMap) {
        System.out.println("당첨 통계");
        System.out.println("---");

        // 모든 등급을 순서대로 출력 (당첨되지 않은 등급도 0개로)
        printRankResult(prizeMap, LottoRank.FIFTH);
        printRankResult(prizeMap, LottoRank.FOURTH);
        printRankResult(prizeMap, LottoRank.THIRD);
        printRankResult(prizeMap, LottoRank.SECOND);
        printRankResult(prizeMap, LottoRank.FIRST);
    }

    private void printRankResult(Map<LottoRank, Integer> prizeMap, LottoRank rank) {
        int count = prizeMap.getOrDefault(rank, 0);
        String prizeStr = String.format("%,d", rank.getPrize());

        if (rank == LottoRank.SECOND) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + prizeStr + "원) - " + count + "개");
        } else {
            System.out.println(rank.getMatchCount() + "개 일치 (" + prizeStr + "원) - " + count + "개");
        }
    }
    
        
    //  - 수익률 출력 메서드 + 소수점 둘째 자리에서 반올림
    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
        System.out.println("---");
    }

    //  - 에러 메시지 출력 메서드
    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

}
