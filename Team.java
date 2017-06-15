package com.brian;

import java.util.ArrayList;

/**
 * Created by Brian on 6/15/2017.
 */
public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    private int gamesPlayed;
    private int wins;
    private int losses;
    private int ties;

    @Override
    public int compareTo(Team<T> o) {
        if(this.ranking() > o.ranking()){
            return -1;
        } else if(o.ranking() > this.ranking()){
            return 1;
        } else {
            return 0;
        }
    }

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println("Player "+player.getName()+" is already on the team");
            return false;
        } else {
            members.add(player);
            System.out.println("Player "+player.getName()+" has been added to the "+this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if(ourScore > theirScore){
            wins++;
            message = " beat ";
        } else if(theirScore > ourScore){
            losses++;
            message = " lost to ";
        } else {
            ties++;
            message = " tied with ";
        }
        gamesPlayed++;
        //Now we need to update the opposing team's record
        if(opponent != null){
            System.out.println(this.getName()+message+opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (wins * 2) + ties;
    }


}
