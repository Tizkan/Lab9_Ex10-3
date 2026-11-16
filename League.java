package tournament;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class League {
    private final String name;

    /* Aggregation League <>- Tournament: tournaments chỉ được thêm vào bởi
     * constructor của Tournament và không bao giờ bị xóa. */
    private final Set<Tournament> tournaments;

    public League(String name) {
        this.name = name;
        this.tournaments = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    /** Chỉ được gọi từ constructor của Tournament (cùng package). */
    void addTournament(Tournament t) {
        tournaments.add(t);
    }

    public Collection<Tournament> getTournaments() {
        return Collections.unmodifiableCollection(tournaments);
    }
}