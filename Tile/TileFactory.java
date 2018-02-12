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

/**
 * @author angel 1/28/2018
 */
public class TileFactory {

    public static GridTile gridTile(float X, float Y, int Z, float Width, float Height) {
        GridTile tile;
        tile = new GridTile();
        tile.setPosition(X, Y, Z);
        tile.setSize(Width, Height);
        return tile;
    }

    public static ImageTile imageTile(float X, float Y, float Width, float Height) {
        ImageTile tile;
        tile = new ImageTile();
        tile.setBounds(X, Y, Width, Height);
        return tile;
    }

}
