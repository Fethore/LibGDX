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

import Ophelia.Assets.SpriteCreator;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Angel Fernandez on 12/13/2017.
 */
public class ImageTile extends Tile {

    public Sprite sprite = SpriteCreator.create("Sprites/Tiles/T15.png");

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawState(batch);
    }

    private void drawState(Batch batch) {
        batch.draw(sprite, getX(), getY(), getWidth(), getHeight());
    }

}
