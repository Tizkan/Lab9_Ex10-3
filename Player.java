package tournament;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final String name;

    /* Association * - * với Tournament: luôn thay đổi qua addTournament/removeTournament
     * để giữ nhất quán với Tournament.players. */
    private final Set<Tournament> tournaments;

    public Player(String name) {
        this.name = name;
        this.tournaments = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addTournament(Tournament t) {
        if (!tournaments.contains(t)) {
            tournaments.add(t);
            t.addPlayer(this);
        }
    }

    public void removeTournament(Tournament t) {
        if (tournaments.contains(t)) {
            tournaments.remove(t);
            t.removePlayer(this);
        }
    }

    public Collection<Tournament> getTournaments() {
        return Collections.unmodifiableCollection(tournaments);
    }
}