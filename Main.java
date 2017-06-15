package com.brian;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	    FootballPlayer joe = new FootballPlayer("Joe");
	    BaseballPlayer pat = new BaseballPlayer("Pat");
	    SoccerPlayer lee = new SoccerPlayer("Lee");

	    Team<FootballPlayer> redskins = new Team<>("Redskins");
	    redskins.addPlayer(joe);

		Team<FootballPlayer> cowboys = new Team<>("Cowboys");
		cowboys.addPlayer(joe);

	    Team<BaseballPlayer> yankees = new Team<>("Yankees");
	    yankees.addPlayer(pat);
		Team<BaseballPlayer> redSox = new Team<>("Red Sox");
		redSox.addPlayer(pat);

	    Team<SoccerPlayer> dcUnited = new Team<>("DC United");
	    dcUnited.addPlayer(lee);
		Team<SoccerPlayer> astros = new Team<>("Astros");
		astros.addPlayer(lee);

        yankees.matchResult(redSox, 10, 20);
		dcUnited.matchResult(astros, 20, 10);
		redskins.matchResult(cowboys, 10, 10);

		System.out.println("Rankings");
		System.out.println(yankees.getName()+": "+yankees.ranking());
		System.out.println(redSox.getName()+": "+redSox.ranking());
		System.out.println(cowboys.getName()+": "+cowboys.ranking());
		System.out.println(astros.getName()+": "+astros.ranking());

		System.out.println(yankees.compareTo(redSox));

//		ArrayList<Team> teams;
//		Collections.sort(teams);
	}
}
