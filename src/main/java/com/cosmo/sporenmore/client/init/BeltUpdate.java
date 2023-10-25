/*
 * Copyright 2022 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cosmo.sporenmore.client.init;

import com.cosmo.sporenmore.client.capability.IBeltUpdate;

public class BeltUpdate implements IBeltUpdate {

    private int ticksSinceAttack;
    private boolean attacking;
    private boolean charging;

    @Override
    public int getTicksSinceAttack() {
        return this.ticksSinceAttack;
    }

    @Override
    public void setTicksSinceAttack(int ticksSinceAttack) {
        this.ticksSinceAttack = ticksSinceAttack;
    }

    @Override
    public boolean getAttacking() {
        return this.attacking;
    }

    @Override
    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    @Override
    public boolean getCharging() {
        return this.charging;
    }

    @Override
    public void setCharging(boolean charging) {
        this.charging = charging;
    }

//    @Override
//    public Tag serializeNBT() {
//        CompoundTag nbt = new CompoundTag();
//
//        nbt.putInt("TicksSinceAttack", getTicksSinceAttack());
//        nbt.putBoolean("Attacking", getAttacking());
//        nbt.putBoolean("Charging", getCharging());
//
//        return nbt;
//    }
//
//    @Override
//    public void deserializeNBT(Tag inbt) {
//        CompoundTag nbt = (CompoundTag) inbt;
//
//        setTicksSinceAttack(nbt.getInt("TicksSinceAttack"));
//        setAttacking(nbt.getBoolean("Attacking"));
//        setCharging(nbt.getBoolean("Charging"));
//    }
}
