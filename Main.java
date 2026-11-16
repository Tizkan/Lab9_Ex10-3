package tournament;

public class Main {
    public static void main(String[] args) {
        League league = new League("Premier League");

        Tournament t1 = new Tournament("Summer Cup", league);
        Tournament t2 = new Tournament("Winter Cup", league);

        new Round(1, t1);
        new Round(2, t1);

        Player a = new Player("An");
        Player b = new Player("Binh");

        t1.addPlayer(a);       // gọi từ phía Tournament
        b.addTournament(t1);   // gọi từ phía Player
        a.addTournament(t2);

        System.out.println(league.getTournaments().size()); // 2
        System.out.println(t1.getRounds().size());          // 2
        System.out.println(t1.getPlayers().size());         // 2
        System.out.println(a.getTournaments().size());      // 2

        t1.removePlayer(a);
        System.out.println(a.getTournaments().size());      // 1
        System.out.println(t1.getPlayers().size());         // 1
    }
}