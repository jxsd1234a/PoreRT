/*
 * Pore(RT)
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
 * Copyright (c) 2014-2016, Contributors
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package blue.lapis.pore.impl.entity;

import blue.lapis.pore.converter.type.entity.ProfessionConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager.Profession;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.monster.Zombie;

@SuppressWarnings("deprecation")
public class PoreZombie extends PoreMonster implements org.bukkit.entity.Zombie {

    public static PoreZombie of(Zombie handle) {
        return WrapperConverter.of(PoreZombie.class, handle);
    }

    protected PoreZombie(Zombie handle) {
        super(handle);
    }

    @Override
    public Zombie getHandle() {
        return (Zombie) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ZOMBIE;
    }

    @Override
    public boolean isBaby() {
        return this.getHandle().require(Keys.AGE) > 0;
    }

    @Override
    public void setBaby(boolean isBaby) {
        this.getHandle().offer(Keys.AGE, -1);
    }

    @Override
    @Deprecated
    public boolean isVillager() {
        return this.getHandle().getType().equals(EntityTypes.ZOMBIE_VILLAGER);
    }

    @Override
    @Deprecated
    public void setVillager(boolean isVillager) {
        if (isVillager != isVillager()) {
            throw new NotImplementedException("setVillager is not implemented!");
            /*if (isVillager) {
                getHandle().getZombieData().type().set(ZombieTypes.VILLAGER);
            } else {
                getHandle().getZombieData().type().set(ZombieTypes.NORMAL);
            }*/
        }
    }

    @Override
    @Deprecated
    public void setVillagerProfession(Profession profession) {
        throw new NotImplementedException("setVillagerProfession is not implemented!");
        //getHandle().getZombieData().profession().setTo(ProfessionConverter.of(profession));
    }

    @Override
    @Deprecated
    public Profession getVillagerProfession() {
        throw new NotImplementedException("getVillagerProfession is not implemented!");
        //ProfessionConverter.of(getHandle().getZombieData().profession().get().orElse(null));
    }
}
