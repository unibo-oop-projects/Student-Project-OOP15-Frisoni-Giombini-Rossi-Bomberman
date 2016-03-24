package view.menu.views.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import model.units.PowerUpType;
import view.GUIFactory;
import view.ImageLoader;
import view.ImageLoader.GameImage;
import view.LanguageHandler;

/**
 * This class is used to realize a view representation of the power-up legend.
 *
 */
public class PowerUpsPanel {
    
    private final GUIFactory factory;
    
    /**
     * Creates a new CommandsPanel.
     */
    public PowerUpsPanel() {
        this.factory = new GUIFactory.Standard();
    }
    
    /**
     * @return a panel with a list containing the power-ups' details.
     */
    public JPanel getPanel() {
        final JPanel panel = new JPanel(new BorderLayout());

        // Creates the model and adds elements
        final DefaultListModel<PowerUpEntry> listModel = new DefaultListModel<>();
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.ATTACK_UP), PowerUpType.ATTACK.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("attack")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.LIFE_UP), PowerUpType.LIFE.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("life")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.BOMBS_UP), PowerUpType.BOMB.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("bomb")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.RANGE_UP), PowerUpType.RANGE.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("range")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.LIFE_DOWN), PowerUpType.HURT.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("hurt")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.CONFUSION_ON), PowerUpType.CONFUSION_ON.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("confusionOn")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.CONFUSION_OFF), PowerUpType.CONFUSION_OFF.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("confusionOff")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.MYSTERY), PowerUpType.MYSTERY.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("mistery")));
        listModel.addElement(new PowerUpEntry(ImageLoader.getLoader().createImageIcon(GameImage.KEY), PowerUpType.KEY.name(),
                LanguageHandler.getHandler().getLocaleResource().getString("key")));
        
        // Creates the list
        final JList<PowerUpEntry> powerUpList = factory.createList(listModel, new PowerUpCellRenderer());
        final JScrollPane scrollPane = new JScrollPane(powerUpList);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        panel.setBackground(Color.DARK_GRAY);
        return panel;
    }
    
    private final class PowerUpEntry {
        
        private final ImageIcon image;
        private final String name;
        private final String description;
        
        PowerUpEntry(final ImageIcon image, final String name, final String description) {
            this.image = image;
            this.name = name;
            this.description = description;
        }
        
        /**
         * @return the image associated to the power-up.
         */
        public ImageIcon getImage() {
            return this.image;
        }
        
        /**
         * @return the name of the power-up.
         */
        public String getName() {
            return this.name;
        }
        
        /**
         * @return the description of the power-up.
         */
        public String getDescription() {
            return this.description;
        }
    }
    
    private class PowerUpCellRenderer extends JLabel implements ListCellRenderer<PowerUpEntry> {

        /**
         * Auto-generated UID.
         */
        private static final long serialVersionUID = -132664349851495348L;
        
        /**
         * Creates a new cell-renderer for the power-ups. 
         */
        PowerUpCellRenderer() {
            setOpaque(true);
        }
        
        @Override
        public Component getListCellRendererComponent(final JList<? extends PowerUpEntry> list, final PowerUpEntry powerUp,
                final int index, final boolean isSelected, final boolean cellHasFocus) {
            
            this.setIcon(powerUp.getImage());
            this.setFont(PowerUpsPanel.this.factory.getDescriptionFont());
            this.setText("<html><FONT COLOR=#DAA520>" + powerUp.getName() + ":</FONT> " + powerUp.getDescription() + "</html>");
            
            if (isSelected) {
                setBackground(PowerUpsPanel.this.factory.getBombermanColor());
                setForeground(Color.WHITE);
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            
            return this;
        }
        
    }
}