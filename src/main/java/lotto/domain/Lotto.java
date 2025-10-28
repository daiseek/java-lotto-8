package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    //  - 로또 번호 리스트 오름차순 정렬 메서드
    // 구현후 validate로 이동
    //  - 로또 번호 리스트 중복 검사 메서드
    //  - 로또 번호 리스트 범위 검사 메서드
    //  - 로또 번호 리스트 범위 미만 검사 메서드
    //  - 로또 번호 리스트 범위 초과 검사 메서드

    // - 당첨 번호 비교 메서드 
}
