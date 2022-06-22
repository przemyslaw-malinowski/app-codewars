package org.malinowsky.the.greater.warriors;

import java.util.ArrayList;
import java.util.List;

public class Warrior {
    private int level;
    private String rank;
    private int experience;
    private List<String> achievements;

    public Warrior() {
        this(100);
    }

    public Warrior(int experience) {
        System.out.println("Create new warrior");
        System.out.println(experience);
        System.out.println(level);
        this.experience = experience;
        this.achievements = new ArrayList<>();
    }

    public int level() {
        return experience / 100;
    }

    public String rank() {
        switch(level() / 10) {
            case 0: return "Pushover";
            case 1: return "Novice";
            case 2: return "Fighter";
            case 3: return "Warrior";
            case 4: return "Veteran";
            case 5: return "Sage";
            case 6: return "Elite";
            case 7: return "Conqueror";
            case 8: return "Champion";
            case 9: return "Master";
        }
        throw new IllegalStateException();
    }

    public int experience() {
        return experience;
    }

    private void setExperience(int newExp) {
        experience = (experience + newExp < 10000) ?
                        experience + newExp :
                        100;
    }

    public String battle(int level) {
        System.out.println("Incoming battle " + level);
        System.out.println("Experience " + experience + "\n");
        if(level < 1 || level > 100) {
            return "Invalid level";
        }

        if((level / 10) > (level() / 10) && level - 5 >= level()) {
            return "You've been defeated";
        }

        if(level + 1 < level()) {
            return "Easy fight";
        } else if((level + 1 == level()) || (level == level())) {
            if(level == level()) {
                setExperience(10);
            } else if(level + 1 == level()) {
                setExperience(5);
            }
            return "A good fight";
        } else {
            int diff = Math.abs(level - level());
            setExperience(20 * diff * diff);
            return "An intense fight";
        }
    }

    public String training(String achievement, int addingExperience, int minimumLvl) {
        if(level() < minimumLvl) {
            return "Not strong enough";
        }
        System.out.printf("Training %s level with %s exp called %s ", minimumLvl, addingExperience, achievement);
        setExperience(addingExperience);
        achievements.add(achievement);
        return achievement;
    }

    public List<String> achievements() {
        return achievements;
    }
}
