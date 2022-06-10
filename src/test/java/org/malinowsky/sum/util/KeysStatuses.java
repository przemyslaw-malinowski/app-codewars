package org.malinowsky.sum.util;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KeysStatuses {
    private int activeGsko;
    private int activeTmSck;
    private int activeGck;
    private List<Integer> dmSck = new ArrayList<>();

    public void set(String key, int value) {
        switch (key) {
            case "activeGck":
                activeGck = value;
                break;
            case "activeGsko":
                activeGsko = value;
                break;
            case "activeTmSck":
                activeTmSck = value;
                break;
            case "dmScks":
                dmSck.add(value);
                break;
        }
    }

    public int getActiveGsko() {
        return activeGsko;
    }

    public void setActiveGsko(int activeGsko) {
        this.activeGsko = activeGsko;
    }

    public int getActiveTmSck() {
        return activeTmSck;
    }

    public void setActiveTmSck(int activeTmSck) {
        this.activeTmSck = activeTmSck;
    }

    public int getActiveGck() {
        return activeGck;
    }

    public void setActiveGck(int activeGck) {
        this.activeGck = activeGck;
    }

    public List<Integer> getDmSck() {
        return dmSck;
    }

    public void setDmSck(List<Integer> dmSck) {
        this.dmSck = dmSck;
    }

    @Override
    public String toString() {
        return "KeysStatuses{" +
                "activeGsko=" + activeGsko +
                ", activeTmSck=" + activeTmSck +
                ", activeGck=" + activeGck +
                ", dmSck=" + dmSck +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        KeysStatuses that = (KeysStatuses) o;
//        return activeGsko == that.activeGsko && activeTmSck == that.activeTmSck && activeGck == that.activeGck && Objects.equals(dmSck, that.dmSck);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(activeGsko, activeTmSck, activeGck, dmSck);
//    }
}
