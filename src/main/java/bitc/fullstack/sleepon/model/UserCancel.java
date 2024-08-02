package bitc.fullstack.sleepon.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sleep_on_cancel")
public class UserCancel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SleepOnUser user;

    @ManyToOne
    @JoinColumn(name = "reserv_id", nullable = true)
    private UserReservation reservation;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "inquiry", nullable = false, length = 2000)
    private String inquiry;

    @Column(name = "reply", length = 2000)
    private String reply;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "reply_date")
    private LocalDateTime replyDate;

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

    public UserReservation getReservation() {
        return reservation;
    }

    public void setReservation(UserReservation reservation) {
        this.reservation = reservation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDateTime replyDate) {
        this.replyDate = replyDate;
    }
}
