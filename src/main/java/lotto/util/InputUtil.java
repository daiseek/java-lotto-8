package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputUtil {
    // TODO : Input 관련 유틸리티 메서드 정의

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    //  로또 번호 생성 메서드 - 로또 범위의 끝 값을 상수로 할당후 사용
    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }
    
    //  보너스 번호와 로또 번호를 비교하는 메서드
    
    //  로또 번호를 쉼표 기준으로 구분(파싱)하는 메서드
    public static List<Integer> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
