/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * Credits goes to all Open Source Core Developer Groups listed below
 * Please do not change here something, regarding the developer credits, except the "developed by XXXX".
 * Even if you edit a lot of files in this source, you still have no rights to call it as "your Core".
 * Everybody knows that this Emulator Core was developed by Aion Lightning 
 * @-Aion-Unique-
 * @-Aion-Lightning
 * @Aion-Engine
 * @Aion-Extreme
 * @Aion-NextGen
 * @Aion-Core Dev.
 */
package com.aionemu.gameserver.utils.collections;

/**
 * @author Rolandas
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class CachePair<K extends Comparable, V> implements Comparable<CachePair> {

    public CachePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K key;
    public V value;

    public boolean equals(Object obj) {
        if (obj instanceof CachePair) {
            CachePair p = (CachePair) obj;
            return key.equals(p.key) && value.equals(p.value);
        }
        return false;
    }

    public int compareTo(CachePair p) {
        int v = key.compareTo(p.key);
        if (v == 0 && p.value instanceof Comparable) {
            return ((Comparable) value).compareTo(p.value);
        }
        return v;
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 37 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
