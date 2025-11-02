package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import lotto.error.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_MESSAGE);
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_LOTTO_MESSAGE);
        }
    }

    // Lotto 객체 생성 메서드
    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    // 로또 번호 리스트 오름차순 정렬 메서드
    public void sortLotto() {
        Collections.sort(numbers);
    }

    // 로또 개별 당첨 번호 비교 메서드
    public int compareLottoNumber(List<Integer> winNumbers, int lottoNumber) {
        if (winNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    // 당첨 번호 리스트 비교 메서드 
    public int compareLotto(List<Integer> winNumbers) {
        int matchCount = 0;
        for (int lottoNumber : this.numbers) {
            matchCount += compareLottoNumber(winNumbers, lottoNumber);
        }
        return matchCount;
    }

    // 로또 리스트에 보너스 번호가 존재하는지 판단 메서드
    public boolean containBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
    
}
