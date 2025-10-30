package lotto.view;

import java.util.Map;
import lotto.domain.enums.LottoRank;

public class OutputView {

    // TODO: 출력 메서드 구현
    //  - 사용자가 구매한 갯수 출력 메서드
    public void printLottos(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    //  - 당첨 내역 출력 메서드
    public void printWinningRecord(Map<LottoRank, Integer> prizeMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<LottoRank, Integer> entry : prizeMap.entrySet()) {
            System.out.println(entry.getKey().getMatchCount() + "개 일치 (" + entry.getKey().getPrize() + "원) - " + entry.getValue() + "개");
        }
    }
        
    //  - 수익률 출력 메서드 + 소수점 둘째 자리에서 반올림
    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    //  - 에러 메시지 출력 메서드
    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

}
