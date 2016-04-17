package model.units;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;

import model.Tile;

/**
 * This class models a Hero.
 *
 */
public interface Hero extends Entity {
    
    /**
     * Implements hero's movement.
     * 
     * @param dir
     *          the direction where to move
     * @param blockSet
     *          the set of blocks
     * @param bombSet
     *          the set of bombs
     * @param powerUpSet
     *          the set of powerups
     */
    void move(final Direction dir, final Set<Rectangle> blockSet, final Set<Rectangle> bombSet,
            final Set<Tile> powerUpSet);
    
    /**
     * Plants a bomb.
     * 
     * @param p the point where to place a bomb 
     * @return the bomb to plant
     */
    void plantBomb(final Point p);
    
    /**
     * Increase the number of bombs.
     */
    void increaseBomb();
    
    /**
     * This method increase the range of a hero's bomb.
     */
    void increaseRange();  
    
    /**
     * Increase hero's score.
     * 
     * @param score
     *          score to add
     */
    void increaseScore(final int enemyScore);
    
    /**
     * Checks if there's a collision with the open door.
     * 
     * @param openDoor
     *          the open door
     * @return true if there's a collision, false otherwise
     */
    boolean checkOpenDoorCollision(final Tile openDoor);
    
    /**
     * This method sets correctly hero
     * for the next level.
     * 
     * @param lives
     *          the lives
     * @param attack
     *          the attack
     * @param score
     *          the score
     */
    void nextLevel(final int lives, final int attack, final int score);
    
    /**
     * Gets bomb's delay.
     * 
     * @return bomb's delay
     */
    long getBombDelay();
    
    /**
     * Gets the direction where the hero would move.
     * 
     * @param dir
     *          the direction
     * @return the direction where to move
     */
    Direction getCorrectDirection(final Direction dir);
    
    /**
     * Returns hero's deonator.
     * 
     * @return hero's detonator
     */
    Detonator getDetonator();
    
    /**
     * This method set the hero in movement or not. 
     * 
     * @param b
     *          true if he's in movements, false otherwise
     */
    void setMoving(boolean b);
    
    /**
     * Set the hero to be confused or not.
     */
    void setConfusion(final boolean b);
    
    /**
     * Set the key.
     */
    void setKey();
    
    boolean isConfused();

    /**
     * Checks if the hero's got the key.
     * 
     * @return true if he's got it, false otherwise
     */
    boolean hasKey();
   
    /**
     * Checks if he has bombs.
     * 
     * @return true if there's at least a bomb, false otherwise
     */
    boolean hasBomb();
    
    /**
     * Hero's toString.
     * 
     * @return the string describing the hero
     */
    String toString();
    
}