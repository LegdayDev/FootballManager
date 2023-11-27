package com.legdayDev.FootballManager.domain.stadium;

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
public class Stadium {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 30)
    private String stadiumName;

    @Column(nullable = false, length = 30)
    private String homeTown;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Stadium(int id, String stadiumName, String homeTown, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.stadiumName = stadiumName;
        this.homeTown = homeTown;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
