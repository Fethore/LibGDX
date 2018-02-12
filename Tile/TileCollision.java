/**
 * *****************************************************************************
 * Copyright 2018 Angel Fernandez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************
 */
package Ophelia.Tile;

/*
 * Created by Angel Fernandez on 12/13/2017.
 */
public class TileCollision {

    private Tile tile;

    public TileCollision(Tile Tile) {
        this.tile = Tile;
    }

    public boolean contact(Tile Tile) {
        return tile.getX() < Tile.getX() + Tile.getWidth()
                && tile.getY() < Tile.getY() + Tile.getHeight()
                && tile.getX() + tile.getWidth() > Tile.getX()
                && tile.getY() + tile.getHeight() > Tile.getY();
    }

    public boolean contactCenter(Tile tile) {
        return contactX(tile) && contactY(tile);
    }

    public boolean contactX(Tile tile) {
        return tile.getCenterX() == tile.getCenterX();
    }

    public boolean contactY(Tile Tile) {
        return tile.getCenterY() == Tile.getCenterY();
    }

}
