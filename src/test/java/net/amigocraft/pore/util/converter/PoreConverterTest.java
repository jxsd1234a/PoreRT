/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
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
package net.amigocraft.pore.util.converter;

import net.amigocraft.pore.PoreTests;
import net.amigocraft.pore.impl.entity.PoreEntity;
import net.amigocraft.pore.impl.entity.PoreLivingEntity;
import net.amigocraft.pore.impl.entity.PorePlayer;
import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.player.Player;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PoreConverterTest {

    @Before
    public void initConverters() {
        PoreTests.mockPlugin();
    }

    @Test
    public void resolveEntity() {
        Entity generic = mock(Entity.class);
        assertEquals(PoreEntity.class, PoreConverter.of(generic).getClass());
    }

    @Test
    public void resolveLivingEntity() {
        Entity living = mock(Living.class);
        assertEquals(PoreLivingEntity.class, PoreConverter.of(living).getClass());
    }

    @Test
    public void resolvePlayer() {
        Entity player = mock(Player.class);
        assertEquals(PorePlayer.class, PoreConverter.of(player).getClass());
    }
}