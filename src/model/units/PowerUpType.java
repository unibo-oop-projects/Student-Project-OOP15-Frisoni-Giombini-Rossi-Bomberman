package model.units;

import java.util.Random;

public enum PowerUpType {
    ATTACK(){
        public void doApply(Hero hero){
            hero.increaseAttack();
        }
    },
    LIFE(){
        public void doApply(Hero hero){
            hero.increaseLife();
        }
    },
    BOMB() {
        @Override
        public void doApply(Hero hero) {
            hero.increaseBomb();
        }
    },
    SPEED() {
        @Override
        public void doApply(Hero hero) {
        }
    },
    FLAMEPASS() {
        @Override
        public void doApply(Hero hero) {
            hero.setFlamepass();
        }
    },
    MYSTERY() {
        @Override
        public void doApply(Hero hero) {
            Random random = new Random();
            PowerUpType powerup = MYSTERY;
            while (powerup == MYSTERY) {
                powerup = PowerUpType.values()[random.nextInt(PowerUpType.values().length)];
            }
            powerup.doApply(hero);
        }
    };

    static {
        ATTACK.message = "Attacco aumentato!";
        LIFE.message = "Hai guadagnato una vita in pi�!";
        BOMB.message = "Usa la tua nuova bomba!";
        SPEED.message = "Sfrutta la tua maggiore velocit�!";
        FLAMEPASS.message = "Puoi passare attraverso il fuoco!";
        MYSTERY.message = "Mystery...";//non metterlo perch� poi sa di che tipo � quindi posso fare il getter?
    }
    private String message;
    
    public void apply(Hero hero){
        this.doApply(hero);
    }
    
    public abstract void doApply(Hero hero);
    
    public String getMessage(){
        return this.message;
    }
}

