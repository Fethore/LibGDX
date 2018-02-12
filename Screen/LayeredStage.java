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
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.util.ArrayList;

/**
 * @author angel 1/23/2018
 */
public class LayeredStage {

    private ArrayList<Group> layers;
    public Stage stage;
    private SuperScreen screen;

    public LayeredStage(SuperScreen Screen) {
        screen = Screen;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    public void createLayers(int Amount) {
        layers = new ArrayList<Group>();
        for (int i = 0; i < Amount; i++) {
            Group x = new Group();
            addLayer(x);
        }
    }

    private void addLayer(Group Layer) {
        layers.add(Layer);
        stage.addActor(Layer);
    }

    public void add(Tile tile, int index) {
        layers.get(index).addActor(tile);
    }

    public void update() {
        Gdx.gl.glClearColor(0F, 0F, 0F, 0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose() {

    }

}
