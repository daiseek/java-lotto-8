package lotto.validate;

import java.util.HashSet;
import java.util.List;

import lotto.error.ErrorMessage;

public class LottoValidate {

    // 로또 번호 리스트 중복 검사 메서드
    public void validateDuplicateLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != new HashSet<>(lottoNumbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_LOTTO_MESSAGE);
        }
    }

    //  로또 번호 리스트 범위 미만 검사 메서드
    public void validateOverLottoNumber(int lottoNumbers) {
        if (lottoNumbers < 1 || lottoNumbers > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OVER_LOTTO_NUMBER_MESSAGE);
        }
    }

    //  로또 번호 범위 리스트 검사 메서드
    public void validateRangeLotto(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) { validateOverLottoNumber(lottoNumber); }
    }

}
