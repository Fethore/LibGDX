import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

/** Created by Angel Fernandez on 11/24/2017. */
public class AnimationList {

    private static ArrayList<Animation> animations;
    private static final int fps = 7;

    public static void load() {
        animations = new ArrayList<Animation>();
    }

    //============================================================================================= PUBLIC
    private static void add(String SpriteSheet) {
        animations.add(create(SpriteSheet, false));
    }

    public static Animation get(int AnimationIndex) {
        return animations.get(AnimationIndex);
    }

    public static Animation create(String SpriteSheet) {
        return create(SpriteSheet, false);
    }

    public static Animation create(String SpriteSheet, boolean Flip) {
        Texture spriteSheet = new Texture(SpriteSheet);
        TextureRegion[][] tmp = createTextureRegion(spriteSheet);
        int length = countFrames(spriteSheet);
        if (Flip) { tmp = flipTextures(tmp, length);}
        return new Animation(Speed(length), createAnimationFrames(tmp, length));
    }

    //============================================================================================= PRIVATE
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

    private static float Speed(int Length) {
        return (Length) * (.1f / fps);
    }

}
