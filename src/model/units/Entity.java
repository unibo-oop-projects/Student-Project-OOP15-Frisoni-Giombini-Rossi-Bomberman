package model.units;

import java.awt.Point;
import java.util.Set;

import model.Tile;
import model.level.Collision;

public interface Entity extends LevelElement{
    
    /**
     * Checks collisions with flames.
     * 
     * @param afflictedTiles
     *          set of afflicted tiles
     * @return true if there's a collision, false otherwise
     */
    boolean checkFlameCollision(final Set<Tile> afflictedTiles);
    
    /**
     * This method allow the entity to move.
     * 
     * @param dir
     *          the direction where to move
     */
    void move(final Direction dir);
    
    /**
     * Method that modify the current value of lives.
     * 
     * @param change
     *          life to be added
     */
    void modifyLife(final int change);
    
    /**
     * This method update the entity's direction.
     * 
     * @param dir
     *          the new direction
     */
    void updateDirection(Direction dir);
    
    /**
     * This method returns the position where the hero would be if there's no collision.
     * 
     * @param p
     *          the point whose coordinates are to be added
     * @return the position where the hero would move
     */
    Point getPossiblePos(Point p);
    
    /**
     * This method is used to know the actual direction of the entity.
     * 
     * @return the entity's direction
     */
    Direction getDirection();
    
    /**
     * Gets remaining lives.
     * 
     * @return remaining lives
     */
    int getRemainingLives();
    
    /**
     * Checks if the entity is dead.
     * 
     * @return true if the entity is dead
     */
    boolean isDead();
    
    /**
     * Check if the hero is in movement.
     * 
     * @return true if he's in movement, false otherwise
     */
    boolean isMoving();
    
    /**
     * This method return the attack level.
     * 
     * @return the hero's attack level
     */
    int getAttack();
    
    /**
     * Increase hero's attack level.
     */
    void increaseAttack(final int attackToAdd);
    
    /**
     * Gets the entity's score.
     * 
     * @return entity's score
     */
    int getScore();
    
    Collision getCollision();
}
