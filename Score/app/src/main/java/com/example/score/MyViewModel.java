package com.example.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<Integer>teamAScore;

    MutableLiveData<Integer>teamBScore;

    int aBack,bBack;

    public MutableLiveData<Integer> getTeamAScore() {
        if(teamAScore == null){
            teamAScore = new MutableLiveData<>();
            teamAScore.setValue(0);
        }
        return teamAScore;
    }

    public MutableLiveData<Integer> getTeamBScore() {
        if(teamBScore == null){
            teamBScore = new MutableLiveData<>();
            teamBScore.setValue(0);
        }
        return teamBScore;
    }

    public void addTeamAScore(int p){
        aBack = teamAScore.getValue();
        bBack = teamBScore.getValue();
        teamAScore.setValue(teamAScore.getValue()+p);
    }

    public void addTeamBScore(int p){
        aBack = teamAScore.getValue();
        bBack = teamBScore.getValue();
        teamBScore.setValue(teamBScore.getValue()+p);
    }

    public void reset(){
        teamAScore.setValue(0);
        teamBScore.setValue(0);
    }

    public void undo(){
        teamAScore.setValue(aBack);
        teamBScore.setValue(bBack);
    }
}
