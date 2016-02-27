package view.menu;

import javax.swing.JPanel;

/**
 * This interface handles the panel changes inside the {@link MenuFrameImpl}.
 * It defines the possible "cards" that can be replaced and shown. 
 *
 */
public interface MenuFrame {

    /**
     * The possible panels that can be shown.
     */
    enum MenuCard {
        HOME(new MenuView()),
        RANKING(new MenuView()),
        SETTINGS(new SettingsView()),
        CREDITS(new MenuView());

        private final JPanel panel;

        /**
         * Constructs a new MenuCard.
         * 
         * @param panel
         *      the {@link JPanel} to show when the "card" is selected.
         */
        MenuCard(final JPanel panel) {
            this.panel = panel;
        }

        /**
         * @return the {@link JPanel} associated to the MenuCard.
         */
        public JPanel getPanel() {
            return this.panel;
        }
    }

    /**
     * This method is called before the UI is used.
     * It shows the user interface on the screen.
     */
    void initView();
    
    /**
     * Change the {@MenuCard} shown in the main frame with another provided.
     * 
     * @param card
     *          the new card
     */
    void replaceCard(MenuCard card);
}
