package com.cosmo.sporenmore.client.capability;
public interface IBeltUpdate {

    int getTicksSinceAttack();

    void setTicksSinceAttack(int ticksSinceAttack);

    boolean getAttacking();

    void setAttacking(boolean attacking);

    boolean getCharging();

    void setCharging(boolean charging);

}
