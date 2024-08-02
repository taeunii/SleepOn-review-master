package bitc.fullstack.sleepon.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="sleepOn_reservation")
public class UserReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SleepOnUser user;

    @Column(name = "reserv_data", nullable = false)
    private LocalDateTime reservData;

    @Column(name = "checkintime", nullable = false)
    private String checkinTime;

    @Column(name = "checkouttime", nullable = false)
    private String checkoutTime;

    @Column(name = "contentId", nullable = false)
    private String contentId;

    @Column(name = "reserv_cancel", nullable = false)
    private char reservCancel = 'N';

    @Column(name = "roomtitle", nullable = false)
    private String roomTitle;

    @Column(name = "user_cnt", nullable = false)
    private int userCnt;

    // Getters and Setters
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public SleepOnUser getUser() {
        return user;
    }

    public void setUser(SleepOnUser user) {
        this.user = user;
    }

    public LocalDateTime getReservData() {
        return reservData;
    }

    public void setReservData(LocalDateTime reservData) {
        this.reservData = reservData;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public char getReservCancel() {
        return reservCancel;
    }

    public void setReservCancel(char reservCancel) {
        this.reservCancel = reservCancel;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public int getUserCnt() {
        return userCnt;
    }

    public void setUserCnt(int userCnt) {
        this.userCnt = userCnt;
    }
}
