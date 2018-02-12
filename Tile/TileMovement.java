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

import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import java.util.Random;

/**
 * Created by Angel Fernandez on 12/13/2017.
 */
public class TileMovement {

    private Tile tile;
    private Random rand;
    public float distance;
    public float speed = 1f;

    public TileMovement(Tile Tile) {
        this.tile = Tile;
        rand = new Random();
        distance = tile.getWidth();
    }

    public void moveUp(float distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(0, distance);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveDown(float distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(0, -distance);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveLeft(float distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(-distance, 0);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveRight(float distance) {
        MoveByAction mba = new MoveByAction();
        mba.setAmount(distance, 0);
        mba.setDuration(speed);
        tile.addAction(mba);
    }

    public void moveTo(float X, float Y) {
        moveToX(X);
        moveToY(Y);
    }

    public void moveToX(float X) {
        if (X > tile.getX()) {
            distance = X - tile.getX();
            moveRight(distance);
        }
        if (X < tile.getX()) {
            distance = tile.getX() - X;
            moveLeft(distance);
        }
    }

    public void moveToY(float Y) {
        if (Y > tile.getX()) {
            distance = Y - tile.getY();
            moveUp(distance);
        }
        if (Y < tile.getX()) {
            distance = tile.getY() - Y;
            moveDown(distance);
        }
    }

    public void followTile(Tile Tile) {
        followTileX(Tile);
        followTileY(Tile);
    }

    public void followTileX(Tile Tile) {
        if (tile.getCenterX() > Tile.getCenterX()) {
            moveLeft(tile.getWidth());
        } else if (tile.getCenterX() < Tile.getCenterX()) {
            moveRight(tile.getWidth());
        }
    }

    public void followTileY(Tile Tile) {
        if (tile.getCenterY() > Tile.getCenterY()) {
            moveDown((int) tile.getWidth());
        } else if (tile.getCenterY() < Tile.getCenterY()) {
            moveUp((int) tile.getWidth());
        }
    }

    public void followXY(float X, float Y) {
        followX(X);
        followY(Y);
    }

    public void followX(float X) {
        if (tile.getCenterX() > X) {
            moveLeft(tile.getWidth());
        } else if (tile.getCenterX() < X) {
            moveRight(tile.getWidth());
        }
    }

    public void followY(float Y) {
        if (tile.getCenterY() > Y) {
            moveDown(tile.getWidth());
        } else if (tile.getCenterY() < Y) {
            moveUp(tile.getWidth());
        }
    }

    public void moveRandomly(float distance) {
        int index = rand.nextInt(4);
        switch (index) {
            case 0:
                moveUp(tile.getWidth());
                break;
            case 1:
                moveDown(tile.getWidth());
                break;
            case 2:
                moveLeft(tile.getWidth());
                break;
            case 3:
                moveRight(tile.getWidth());
                break;
        }
    }

}
