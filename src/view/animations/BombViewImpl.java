package view.animations;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import model.units.Bomb;
import view.animations.unit.AbstractSingleAnimationView;
import view.animations.unit.Sprite;

/**
 * An implementation of {@link BombView}.
 *
 */
public class BombViewImpl extends AbstractSingleAnimationView implements BombView {

    private static final List<BufferedImage> BOMB_TRIGGER = Sprite.getSprites(new Point(10, 0), new Point(11, 0), new Point(12, 0));

    private final Bomb bomb;

    /**
     * Constructs a new view for the bomb.
     * 
     * @param bomb
     *          the bomb to represent
     * @param fps
     *          the number of frame-per-second
     * @param duration
     *          the duration (in milliseconds) of the animation
     */
    public BombViewImpl(final Bomb bomb, final int fps, final long duration) {
        super(bomb, fps, duration);
        this.bomb = bomb;
    }
    
    @Override
    public List<BufferedImage> animationFrames() {
        return BOMB_TRIGGER;
    }

    @Override
    public Bomb getBomb() {
        return this.bomb;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bomb == null) ? 0 : bomb.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof BombViewImpl && this.bomb.equals(((BombViewImpl) obj).bomb);
    }
}