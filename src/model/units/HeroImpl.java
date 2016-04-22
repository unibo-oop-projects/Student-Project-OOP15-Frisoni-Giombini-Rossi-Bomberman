package model.units;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;

import model.Tile;
import model.level.Collision;
import model.level.HeroCollision;
import model.level.HeroCollisionImpl;
import model.utilities.MapPoint;

/**
 * Implementation of {@link Hero}.
 */
public class HeroImpl extends AbstractEntity implements Hero {

    private final Detonator detonator;
    private final HeroCollision heroCollision;
    private boolean inConfusion;
    private boolean key;

    /**
     * This allow to create a Hero.
     * 
     * @param pos
     *          the initial position
     * @param dir
     *          the initial direction
     * @param dim
     *          the dimension of the hitBox
     */
    public HeroImpl(final Point pos, final Dimension dim) {
        super(pos, dim);
        this.detonator = new Detonator(dim);
        this.heroCollision = new HeroCollisionImpl(this);
        this.inConfusion = false;
        this.key = false;
    }
    
    /**
     * Hero's movement.
     */
    public void move(final Direction dir, final Set<Rectangle> blockSet, 
            final Set<Rectangle> bombSet, final Set<Tile> powerUpSet) {
        this.heroCollision.updateEntityRec(dir);
        if (this.heroCollision.blockCollision(blockSet) && this.heroCollision.bombCollision(bombSet)
                && this.heroCollision.powerUpCollision(powerUpSet)) {
            this.setMoving(true);
            super.move(dir);
        }
    }
    
    /**
     * Verifies if a bomb can be planted.
     * 
     * @return true if the bomb can be planted, false otherwise
     */
    @Override
    public boolean canPlantBomb(final int nTiles) {
        final Point point = new Point(MapPoint.getCorrectPos(this.getX(), nTiles, this.getHitbox().width), 
                MapPoint.getCorrectPos(this.getY(), nTiles, this.getHitbox().height));
        return !this.getDetonator().getPlantedBombs().stream().anyMatch(b -> b.getPosition().equals(point));
    }

    /**
     * Plants a bomb.
     */
    @Override
    public void plantBomb(final int nTiles) {
        this.getDetonator().plantBomb(new Point(MapPoint.getCorrectPos(this.getX(), nTiles, this.getHitbox().width), 
                MapPoint.getCorrectPos(this.getY(), nTiles, this.getHitbox().height)));
    }
    
    /**
     * Increases hero's score.
     */
    @Override
    public void increaseScore(final int scoreToAdd) {
        super.score += scoreToAdd; 
    }

    /**
     * Checks the collision with the open door.
     * 
     * @return true if there's a collision, false otherwise
     */
    @Override
    public boolean checkOpenDoorCollision(final Tile doorOpened) {
        return this.heroCollision.openDoorCollision(doorOpened.getHitbox());
    }
    
    /**
     * Sets correctly hero for next game level.
     * 
     * @param lives
     *          the lives
     * @param attack
     *          the attack
     * @param score
     *          the score
     */
    @Override
    public void nextLevel(final int lives, final int attack, final int score) {
        this.modifyLife(lives - 1);
        this.increaseAttack(attack - 1);
        this.increaseScore(score); 
    }
    
    /**
     * Gets the correct direction depending on the boolean confusion.
     * 
     * @param dir
     *          the direction where he would move
     * @return the direction where he will move
     */
    public Direction getCorrectDirection(final Direction dir) {
        return this.inConfusion ? dir.getOppositeDirection() : dir;
    }
    
    /**
     * Gets hero's detonator.
     * 
     * @return hero's detonator
     */
    @Override
    public Detonator getDetonator() {
        return this.detonator;
    }
        
    /**
     * Gets hero's collision.
     * 
     * @return hero's collision
     */
    @Override
    public Collision getCollision() {
        return this.heroCollision;
    }
    
    /**
     * Set the hero to be in movement or not.
     */
    @Override
    public void setMoving(final boolean b) {
        super.inMovement = b;
    }

    /**
     * Sets confusion.
     */
    @Override
    public void setConfusion(final boolean b) {
        this.inConfusion = b;
    }

    /**
     * Set the hero to own the key.
     */
    @Override
    public void setKey() {
        this.key = true;
    }
    
    /**
     * Cheks if hero's got the key.
     * 
     * @return true if he's got it, false otherwise
     */
    @Override
    public boolean hasKey() {
        return this.key;
    }
    
    /**
     * Hero's toString.
     * 
     * @return hero's description
     */
    @Override
    public String toString(){
        return new StringBuilder().append("HERO -  ")
                .append(super.toString())
                .toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (inConfusion ? 1231 : 1237);
        result = prime * result + (key ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof HeroImpl && this.inConfusion == ((HeroImpl) obj).inConfusion
                && this.key == ((HeroImpl) obj).key;
    }
  
}
