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
package Ophelia.Assets;

import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by angel on 12/27/2017.
 */
public class SpriteList {

    ArrayList<Sprite> textures;
    private Random rand;
    private String directory;

    public void load() {
        textures = new ArrayList<Sprite>();
        rand = new Random();
    }

    public void setDirectory(String Directory) {
        directory = Directory + "/";
    }

    public void add(String Location) {
        textures.add(SpriteCreator.create(directory + Location));
    }

    public Sprite get(int Index) {
        return textures.get(Index);
    }

    public Sprite getRandom() {
        int size = textures.size();
        int index = rand.nextInt(size);
        return get(index);
    }
}
