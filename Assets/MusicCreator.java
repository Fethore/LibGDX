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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by Angel Fernandez on 12/23/2017.
 */
public class MusicCreator {

    public static Music create(String Location) {
        return create(Location, true, true);
    }

    public static Music create(String Location, Boolean Looping, Boolean Playing) {
        Music music = Gdx.audio.newMusic(Gdx.files.internal(Location));
        music.setLooping(Looping);
        setPlay(music, Playing);
        return music;
    }

    private static void setPlay(Music music, Boolean Playing) {
        if (Playing) {
            music.play();
        }
    }
}
