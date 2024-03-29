package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import model.units.PowerUpType;
import model.units.Tile;
import model.units.TileImpl;
import model.units.TileType;
import model.utilities.MapPoint;

/**
 * This class allows to establish which type of tile
 * there will be in a specific position and sets its
 * characteristics.
 */
public class TileFactory {

    private static final double BLOCK_DENSITY = 0.5;
    private static final double POWERUP_DENSITY = 0.75;
    
    private final int rows;
    private final int columns;

    /**
     * Constructs a TileFactory.
     * 
     * @param rows
     *          the number of rows
     * @param columns
     *          the number of columns
     */
    public TileFactory(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * Creates a new tile for the specified coordinates.
     * 
     * @param row
     *          the row in the map
     * @param column
     *          the column in the map
     * @param tileDimension
     *          the dimension of a tile
     * @return the new tile
     */
    public Tile createForCoordinates(final int row, final int column, final int tileDimension) {
        final TileType type = getTypeForCoordinates(row, column);
        final Optional<PowerUpType> powerup = this.getPowerup(type);
        return new TileImpl(new Point(MapPoint.getCoordinate(row, tileDimension),
                MapPoint.getCoordinate(column, tileDimension)), 
                new Dimension(tileDimension, tileDimension),
                type, powerup);
    }

    /**
     * Gets a correct type of tile for the specified coordinates.
     * 
     * @param row
     *          the row at which is located
     * @param column
     *          the column at which is located
     * @return the type of tile
     */
    private TileType getTypeForCoordinates(final int row, final int column) {
        if (this.tileIsConcrete(row, column)) {
            return TileType.CONCRETE;
        } else if (Math.random() < BLOCK_DENSITY && !MapPoint.isEntryPoint(row, column)) {
            return TileType.RUBBLE;
        } else {
            return TileType.WALKABLE;
        }
    }

    /**
     * Checks if the tile at the specified coordinates refers
     * to a concrete block.
     * 
     * @param row
     *          the row of the tile
     * @param column
     *          the column of the tile
     * @return true if the tile is concrete, false otherwise
     */
    private boolean tileIsConcrete(final int row, final int column) {
        return row == 0 || column == 0 || row == this.rows - 1 || column == this.columns - 1
                || row % 2 == 0 && column % 2 == 0;
    }

    /**
     * Gets a correct type of powerup for the specified block.
     * 
     * @param type
     *          block type
     * @return an powerup that is an optional
     *           because a block might not have a powerup
     */
    private Optional<PowerUpType> getPowerup(final TileType type) {
        if (!type.equals(TileType.RUBBLE) || Math.random() < POWERUP_DENSITY) {
            return Optional.empty();
        } else {
                return Optional.of(this.selectType());
        }
    }

    /**
     * Selects a random type, except key.
     * 
     * @return a powerup type
     */
    private PowerUpType selectType() {
        PowerUpType type = PowerUpType.KEY;
        while (type.equals(PowerUpType.KEY)) {
            type = PowerUpType.values()[new Random().nextInt(PowerUpType.values().length)];
        }
        return type;
    } 

    /**
     * Sets a random tile's type equals to the closed door.
     * 
     * @param walkableTiles
     *          the set of walkable tiles
     */
    public void setDoor(final Set<Tile> walkableTiles) {
        walkableTiles.stream().findAny().get().setType(TileType.DOOR_CLOSED);
    }

    /**
     * Sets the powerup of a random tile equals to the key.
     * 
     * @param rubbleTiles
     *          the set of rubbles tiles
     */
    public void setKey(final Set<Tile> rubbleTiles) {
        rubbleTiles.stream().findAny().get().setKeyPowerUp();
    }
}
