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

import Ophelia.Assets.AnimationCreator;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Animation;

/**
 * Created by Angel Fernandez on 11/17/2017.
 */
public class AnimationTile extends Tile {

    public Animation animation = AnimationCreator.create("Sprites/Default.png");
    public boolean paused = false;

    @Override
    public void setElapsedTime() {
        if (!paused) {
            super.setElapsedTime();
        }
    }

    public void pauseElapsedTime() {
        this.paused = true;
    }

    public void resumeElapsedTime() {
        this.paused = false;
    }

    public void setAnimation(String SpriteSheet) {
        if (this.flipped) {
            this.animation = AnimationCreator.create(SpriteSheet, true);
        } else {
            this.animation = AnimationCreator.create(SpriteSheet);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawState(batch);
    }

    public void drawState(Batch batch) {
        batch.draw(animation.getKeyFrame(elapsedTime, true), getX(), getY(), getWidth(), getHeight());
    }

}
