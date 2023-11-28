package com.legdayDev.FootballManager.domain.player;

import com.legdayDev.FootballManager.domain.team.Team;
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
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String playerName;

    private Position position;

    private boolean isOut = false;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // ADMIN, USER

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Player(int id, String playerName, Position position, boolean isOut, Role role, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.playerName = playerName;
        this.position = position;
        this.isOut = isOut;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    // 연관관계 메서드
    public void setTeam(Team team){
        this.team = team;
    }

}
