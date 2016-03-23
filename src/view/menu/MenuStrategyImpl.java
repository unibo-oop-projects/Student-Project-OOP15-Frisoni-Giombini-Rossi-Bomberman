package view.menu;

import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import view.ImageLoader;
import view.ImageLoader.GameImage;
import view.menu.views.MenuView.MenuObserver;
import view.LanguageHandler;

/**
 * An implementation of {@link MenuStrategy}.
 * 
 */
public class MenuStrategyImpl implements MenuStrategy {

    private enum MainMenuButton implements MenuButton {
        PLAY("play", ImageLoader.getLoader().createImageIcon(GameImage.PLAY)) {
            @Override
            public void clickEvent(final MenuObserver observer) {
                observer.play();
            }
        },
        SCORES("scores", ImageLoader.getLoader().createImageIcon(GameImage.SCORES)) {
            @Override
            public void clickEvent(final MenuObserver observer) {
                observer.scores();
            }
        },
        SETTINGS("settings", ImageLoader.getLoader().createImageIcon(GameImage.SETTINGS)) {
            @Override
            public void clickEvent(final MenuObserver observer) {
                observer.settings();
            }
        },
        INFO("info", ImageLoader.getLoader().createImageIcon(GameImage.INFO)) {
            @Override
            public void clickEvent(final MenuObserver observer) {
                observer.credits();
            }
        };

        private final String name;
        private final ImageIcon icon;

        MainMenuButton(final String name, final ImageIcon icon) {
            this.name = name;
            this.icon = icon;
        }

        @Override
        public String getName() {
            return LanguageHandler.getHandler().getLocaleResource().getString(this.name);
        }

        @Override
        public ImageIcon getIcon() {
            return this.icon;
        }
    }

    @Override
    public List<MenuButton> getButtons() {
        return Arrays.asList(MainMenuButton.values());
    }
}
