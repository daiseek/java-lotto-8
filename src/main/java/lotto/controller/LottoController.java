package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;

public class LottoController {
    // TODO : 애플리케이션 흐름을 제어하는 메서드 구현
    // Input -> Controller -> Service -> Output

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    // 
    public void run() {
        System.out.println("구입금액을 입력해 주세요.");

        // 로또 구입 금액 입력
        int purchaseAmount = inputView.inputLottoPurchaseAmount();
        // 구입한 로또 개수
        int lottoCount = lottoService.purchaseLotto(purchaseAmount);
        // 로또 생성
        List<Lotto> lottos = lottoService.generateLottos();
        // 구입한 로또 개수와 각 로또 리스트 출력
        outputView.printLottos(lottoCount, lottos);
        
        // 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = inputView.inputWinningLottoNumbers();
        
        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputView.inputBonusNumber();

        // 로또 당첨 확인
        Map<LottoRank, Integer> prizeMap = lottoService.checkLottoPrize(lottos, winningNumbers, bonusNumber);
        // 수익률 계산
        double profitRate = lottoService.calculateProfitRate(prizeMap, purchaseAmount);

        // 당첨 통계 출력
        outputView.printWinningRecord(prizeMap);
        // 수익률 출력
        outputView.printProfitRate(profitRate);



    }
}
