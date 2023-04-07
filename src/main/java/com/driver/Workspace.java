package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings
    public Workspace(){

    }
    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am


        // so we sort our meeting according to endTime of a meeting because as soon a meeting ended
        // as soon we can join another one
        calendar.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getEndTime().compareTo(o2.getEndTime());
            }
        });

        LocalTime endTime = calendar.get(0).getEndTime();
        int count = 1;

        for(int i = 1; i < calendar.size(); i++){
            if(calendar.get(i).getStartTime().isAfter(endTime)){
                endTime = calendar.get(i).getEndTime();
                count++;
            }
        }
        return count;
    }
}