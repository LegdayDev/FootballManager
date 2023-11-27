package com.legdayDev.FootballManager.domain.team;

import com.legdayDev.FootballManager.domain.stadium.Stadium;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 30)
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Team(int id, String teamName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.teamName = teamName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 연관관계 메서드
    public void setStadium(Stadium stadium){
        this.stadium = stadium;
    }
}
