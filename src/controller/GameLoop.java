package controller;

/**
 * This class models a GameLoop.
 */
public interface GameLoop {
    
    /**
     * This method check if the game is running.
     * @return true if the game is running, false
     */
    boolean isRunningLoop();
    
    /**
     * Change the state of game in pause.
     */
    void pauseLoop();
    
    /**
     * Change the state of game in stop pause.
     */
    void unPauseLoop();
    
    /**
     * Stops the game.
     */
    void stopLoop();
    
}
