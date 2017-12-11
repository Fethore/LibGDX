import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

/** Created by Angel Fernandez on 11/24/2017. */
public class AnimationFactory {

    public static int FPS = 10;

    public static Animation create(String Location) {
        return create(Location, false);
    }

    public static Animation create(String Location, boolean Flip) {
        Texture spriteSheet = new Texture(Location);
        TextureRegion[][] tmp = createTextureRegion(spriteSheet);
        int length = countFrames(spriteSheet);
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
