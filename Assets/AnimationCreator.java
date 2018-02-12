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

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Angel Fernandez on 12/6/2017.
 */
public class AnimationCreator {

    public static int FPS = 10;

    public static Animation create(String Location) {
        return create(Location, 0, false);
    }

    public static Animation create(String Location, boolean Flip) {
        return create(Location, 0, Flip);
    }

    public static Animation create(String Location, int Frames) {
        return create(Location, Frames, false);
    }

    public static Animation create(String Location, int Frames, boolean Flip) {
        Texture spriteSheet = new Texture(Location);
        TextureRegion[][] tmp = createTextureRegion(spriteSheet);
        int length = setLength(spriteSheet, Frames);
        if (Flip) {
            tmp = flipTextures(tmp, length);
        }
        return new Animation(getSpeed(length), createAnimationFrames(tmp, length));
    }

    private static TextureRegion[] createAnimationFrames(TextureRegion[][] Textures, int Length) {
        TextureRegion[] animationFrames = new TextureRegion[Length];
        int index = 0;
        for (int i = 0; i < Length; i++) {
            animationFrames[index++] = Textures[0][i];
        }
        return animationFrames;
    }

    private static TextureRegion[][] createTextureRegion(Texture SpriteSheet) {
        int length = SpriteSheet.getWidth() / countFrames(SpriteSheet);
        return TextureRegion.split(SpriteSheet, length, SpriteSheet.getHeight());
    }

    private static int setLength(Texture spriteSheet, int Frames) {
        if (Frames == 0) {
            return countFrames(spriteSheet);
        }
        return Frames;

    }

    private static int countFrames(Texture SpriteSheet) {
        return SpriteSheet.getWidth() / SpriteSheet.getHeight();
    }

    private static TextureRegion[][] flipTextures(TextureRegion[][] Textures, int Length) {
        for (int i = 0; i < Length; i++) {
            Textures[0][i].flip(true, false);
        }
        return Textures;
    }

    private static float getSpeed(int Length) {
        return (Length) * (.1f / FPS);
    }
}
