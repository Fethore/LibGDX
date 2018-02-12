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

import Ophelia.Screen.SuperScreen;

/**
 * @author angel 1/26/2018.
 */
public class GridTile {

    private float x = 0;
    private float y = 0;
    private int z = 0;

    private float width = 0;
    private float height = 0;
    private float unit = 0;

    private ImageTile topLeft; //no change
    private ImageTile topCenter; // x
    private ImageTile topRight;//no change

    private ImageTile middleLeft; // y
    private ImageTile middleCenter; // x y
    private ImageTile middleRight; // y

    private ImageTile bottomLeft; //no change 
    private ImageTile bottomCenter; //x
    private ImageTile bottomRight; //no change

    public void setSize(float Width, float Height) {
        width = Width;
        height = Height;
    }

    public void setPosition(float X, float Y, int Z) {
        x = X;
        y = Y;
        z = Z;
    }

    public void loadTiles(SuperScreen Screen) {
        setUnit(Screen.width);
        setTopLeft(Screen);
        setTopCenter(Screen);
        setTopRight(Screen);
        setMiddleLeft(Screen);
        setMiddleCenter(Screen);
        setMiddleRight(Screen);
        setBottomLeft(Screen);
        setBottomCenter(Screen);
        setBottomRight(Screen);
    }

    private void setTopLeft(SuperScreen Screen) {
        float tileY = getTop();
        float tileX = getLeft();
        topLeft = TileFactory.imageTile(tileX, tileY, unit, unit);
        Screen.setTile(topLeft, z);
    }

    private void setTopCenter(SuperScreen Screen) {
        float tileY = getTop();
        float tileX = getCenter();
        float tileW = getCenterWidth();
        topCenter = TileFactory.imageTile(tileX, tileY, tileW, unit);
        Screen.setTile(topCenter, z);
    }

    private void setTopRight(SuperScreen Screen) {
        float tileY = getTop();
        float tileX = getRight();
        topRight = TileFactory.imageTile(tileX, tileY, unit, unit);
        //set Image
        Screen.setTile(topRight, z);
    }

    private void setMiddleLeft(SuperScreen Screen) {
        float tileY = getMiddle();
        float tileX = getLeft();
        float tileH = getMiddleHeight();
        middleLeft = TileFactory.imageTile(tileX, tileY, unit, tileH);
        //set Image
        Screen.setTile(middleLeft, z);
    }

    private void setMiddleCenter(SuperScreen Screen) {
        float tileY = getMiddle();
        float tileX = getCenter();
        float tileH = getMiddleHeight();
        float tileW = getCenterWidth();
        middleCenter = TileFactory.imageTile(tileX, tileY, tileW, tileH);
        //set Image
        Screen.setTile(middleCenter, z);
    }

    private void setMiddleRight(SuperScreen Screen) {
        float tileY = getMiddle();
        float tileX = getRight();
        float tileH = getMiddleHeight();
        middleRight = TileFactory.imageTile(tileX, tileY, unit, tileH);
        //set Image
        Screen.setTile(middleRight, z);
    }

    private void setBottomLeft(SuperScreen Screen) {
        float tileY = getBottom();
        float tileX = getLeft();
        bottomLeft = TileFactory.imageTile(tileX, tileY, unit, unit);
        //set Image
        Screen.setTile(bottomLeft, z);
    }

    private void setBottomCenter(SuperScreen Screen) {
        float tileY = getBottom();
        float tileX = getCenter();
        float tileW = getCenterWidth();
        bottomLeft = TileFactory.imageTile(tileX, tileY, tileW, unit);
        //set Image
        Screen.setTile(bottomLeft, z);
    }

    private void setBottomRight(SuperScreen Screen) {
        float tileY = getBottom();
        float tileX = getRight();
        bottomLeft = TileFactory.imageTile(tileX, tileY, unit, unit);
        //set Image
        Screen.setTile(bottomLeft, z);
    }

    private void dispose() {
        topLeft.remove();
        topCenter.remove();
        topRight.remove();
        middleLeft.remove();
        middleCenter.remove();
        middleRight.remove();
        bottomLeft.remove();
        bottomCenter.remove();
        bottomRight.remove();
    }

    private float getTop() {
        return (height + y) - unit;
    }

    private float getBottom() {
        return y;
    }

    private float getMiddle() {
        return y + unit;
    }

    private float getLeft() {
        return x;
    }

    private float getCenter() {
        return x + unit;
    }

    private float getRight() {
        return (x + width) - unit;
    }

    private float getCenterWidth() {
        return width - (unit * 2);
    }

    private float getMiddleHeight() {
        return height - (unit * 2);
    }

    private void setUnit(float Width) {
        unit = Width / 18;
    }

}
