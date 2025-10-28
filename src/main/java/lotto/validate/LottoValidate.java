package lotto.validate;

import java.util.HashSet;
import java.util.List;

public class LottoValidate {

    // 로또 번호 리스트 중복 검사 메서드
    public void validateDuplicateLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != new HashSet<>(lottoNumbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

}
