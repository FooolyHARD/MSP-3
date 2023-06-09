package com.senechka.lab3.db;

import com.senechka.lab3.beans.Coordinates;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The HitResult class represents a hit result entity in the database.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hitResults")
public class HitResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Integer id;
    private String sessionId;

    private double x;
    private double y;
    private double r;
    private String currentTime;
    private boolean result;

    private boolean removed = false;

    /**
     * Constructs a new HitResult instance.
     * @param sessionId The session ID associated with the hit result.
     * @param coordinates The coordinates of the hit result.
     * @param currentTime The current time of the hit result.
     * @param result The result of the hit.
     */
    public HitResult(String sessionId, Coordinates coordinates, String currentTime, boolean result) {
        this.sessionId = sessionId;
        this.x = coordinates.getX();
        this.y = coordinates.getY();
        this.r = coordinates.getR();
        this.currentTime = currentTime;
        this.result = result;
    }

    /**
     * Retrieves the coordinates object associated with the hit result.
     * @return The coordinates object.
     */
    public Coordinates getCoordinates(){
        return new Coordinates(x,y,r);
    }
}
