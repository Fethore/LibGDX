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
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

/*
 * Created by Angel Fernandez on 12/13/2017.
 */
public class Tile extends Actor {

    public float elapsedTime;
    public boolean flipped = false;
    public boolean touchable = false;
    public Vector3 touch;

    public TileMovement movement;
    public TileCollision collision;

    public Tile() {
        movement = new TileMovement(this);
        collision = new TileCollision(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setElapsedTime();
    }

    public void setElapsedTime() {
        this.elapsedTime += Gdx.graphics.getDeltaTime();
    }

    public void resetElapsedTime() {
        this.elapsedTime = 0;
    }

    public int getCenterX() {
        return (int) (getX() + (getWidth() / 2));
    }

    public int getCenterY() {
        return (int) (getY() + (getHeight() / 2));
    }

    public boolean isTouched() {
        if (touchable) {
            float posX = this.touch.x - getX();
            float posY = (Gdx.graphics.getHeight() - this.touch.y) - getY();
            return posX <= getWidth() && posX >= 0 && posY <= getHeight() && posY >= 0;
        }
        return false;
    }

    public boolean outOfScreen(SuperScreen Screen) {
        if (getX() > Screen.width) {
            return true;
        }
        if (getY() > Screen.height) {
            return true;
        }
        if (getX() + getWidth() < 0) {
            return true;
        }
        if (getY() + getHeight() < 0) {
            return true;
        }
        return false;
    }
}
