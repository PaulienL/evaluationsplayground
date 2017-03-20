package com.cegeka.school.domain.meetings;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MEETINGS")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "MEETING_ID")
    private int meetingID;
    @Column (name = "MEETING_DATE")
    private LocalDate meetingDate;
    @Column (name = "SCORE")
    private int score;
    @Column (name = "STATUS")
    private boolean status;

    public Meeting(LocalDate meetingDate, int score) {
        this.meetingDate = meetingDate;
        this.score = score;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public int getScore() {
        return score;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meeting meeting = (Meeting) o;

        if (meetingID != meeting.meetingID) return false;
        if (score != meeting.score) return false;
        if (status != meeting.status) return false;
        return meetingDate != null ? meetingDate.equals(meeting.meetingDate) : meeting.meetingDate == null;
    }

    @Override
    public int hashCode() {
        int result = meetingID;
        result = 31 * result + (meetingDate != null ? meetingDate.hashCode() : 0);
        result = 31 * result + score;
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}
