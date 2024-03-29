package view.animations;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.List;

import model.units.Direction;
import model.units.enemy.Enemy;
import view.animations.unit.AbstractEnemyView;
import view.animations.unit.AbstractEntityView;
import view.animations.unit.Sprite;

/**
 * An implementation of {@link AbstractEntityView}.
 * It represents a ballom enemy.
 *
 */
public class BallomView extends AbstractEnemyView {
    
    private static final EnumMap<Direction, List<BufferedImage>> MOVEMENT_MAP = new EnumMap<>(Direction.class);
    private static final EnumMap<Direction, List<BufferedImage>> STANDING_MAP = new EnumMap<>(Direction.class);
    static {
        MOVEMENT_MAP.put(Direction.DOWN, Sprite.getSprites(new Point(0, 5), new Point(1, 5), new Point(2, 5), new Point(3, 5)));
        MOVEMENT_MAP.put(Direction.RIGHT, Sprite.getSprites(new Point(0, 6), new Point(1, 6), new Point(2, 6), new Point(3, 6)));
        MOVEMENT_MAP.put(Direction.UP, Sprite.getSprites(new Point(0, 7), new Point(1, 7), new Point(2, 7), new Point(3, 7)));
        MOVEMENT_MAP.put(Direction.LEFT, Sprite.getSprites(new Point(0, 8), new Point(1, 8), new Point(2, 8), new Point(3, 8)));
        STANDING_MAP.put(Direction.DOWN, MOVEMENT_MAP.get(Direction.DOWN));
        STANDING_MAP.put(Direction.RIGHT, MOVEMENT_MAP.get(Direction.RIGHT));
        STANDING_MAP.put(Direction.UP, MOVEMENT_MAP.get(Direction.UP));
        STANDING_MAP.put(Direction.LEFT, MOVEMENT_MAP.get(Direction.LEFT));
    }
    
    /**
     * Constructs a new ballom view for the enemy.
     * 
     * @param enemy
     *          the enemy to represent
     * @param fps
     *          the number of frame-per-second
     */
    public BallomView(final Enemy enemy, final int fps) {
        super(enemy, fps);
    }
    
    @Override
    public EnumMap<Direction, List<BufferedImage>> movementFrames() {
        return MOVEMENT_MAP;
    }

    @Override
    public EnumMap<Direction, List<BufferedImage>> standingFrames() {
        return STANDING_MAP;
    }
}
