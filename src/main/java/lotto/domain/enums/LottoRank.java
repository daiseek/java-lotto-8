package lotto.domain.enums;

public enum LottoRank {
    // TODO : 당첨 기준에 따라 당첨순위 & 당첨금 정의

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount; // 당첨 번호 일치 개수
    private final int prize; // 상금

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
    
    public int getPrize() {
        return prize;
    }
}
