package tournament;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tournament {
    private final String name;

    /* Aggregation: league được gán trong constructor và không bao giờ đổi. */
    private final League league;

    /* Aggregation Tournament <>- Round: rounds chỉ được thêm bởi constructor của Round. */
    private final Set<Round> rounds;

    /* Association * - * với Player: luôn thay đổi qua addPlayer/removePlayer
     * để giữ nhất quán với Player.tournaments. */
    private final Set<Player> players;

    public Tournament(String name, League league) {
        this.name = name;
        this.league = league;
        this.rounds = new HashSet<>();
        this.players = new HashSet<>();
        league.addTournament(this);       // khởi tạo aggregation hai chiều
    }
    
/** Chỉ được gọi từ constructor của Round (cùng package). */
    void addRound(Round r) {
        rounds.add(r);
    }
    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }

    public Collection<Round> getRounds() {
        return Collections.unmodifiableCollection(rounds);
    }

    public void addPlayer(Player p) {
        if (!players.contains(p)) {
            players.add(p);
            p.addTournament(this);
        }
    }

    public void removePlayer(Player p) {
        if (players.contains(p)) {
            players.remove(p);
            p.removeTournament(this);
        }
    }

    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }
}