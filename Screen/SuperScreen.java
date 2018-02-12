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
package Ophelia.Screen;

import Ophelia.Tile.Tile;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Created by Angel Fernandez on 11/22/2017.
 */
public class SuperScreen implements Screen {

    public Game game;
    private TouchControl touch;
    public LayeredStage layeredStage;

    public float width;
    public float height;

    public void start(Game game) {
        this.game = game;

        layeredStage = new LayeredStage(this);
        layeredStage.createLayers(5);

        touch = new TouchControl();

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    public boolean isTouched() {
        return touch.isTouched();
    }

    public boolean isTouched(Tile tile) {
        return isTouched() && tile.isTouched();
    }

    public void setTile(Tile tile, int Z) {
        tile.touch = touch.getTouch();
        layeredStage.add(tile, Z);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        layeredStage.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        layeredStage.dispose();
    }
}
