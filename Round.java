package tournament;

public class Round {
    private final int number;

    /* Aggregation: tournament được gán trong constructor và không bao giờ đổi. */
    private final Tournament tournament;

    public Round(int number, Tournament tournament) {
        this.number = number;
        this.tournament = tournament;
        tournament.addRound(this);        // khởi tạo aggregation hai chiều
    }

    public int getNumber() {
        return number;
    }

    public Tournament getTournament() {
        return tournament;
    }
}