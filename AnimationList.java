import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

/** Created by Angel Fernandez on 7/14/2017 */

public class AnimationList {
   static ArrayList<Animation> animations;

    public static void load(){
        animations = new ArrayList<Animation>();
        add("falling-Sheet.png", 2, 2);
    }

    public static void add(String SpriteSheet, int Columns, int Rows, float Speed){

        Texture spriteSheet = new Texture(SpriteSheet);
        int width = spriteSheet.getWidth();
        int height = spriteSheet.getHeight();

        TextureRegion[][] tmp = TextureRegion.split(spriteSheet, width / Columns, height / Rows);

        TextureRegion[] animationFrames = new TextureRegion[Columns * Rows];
        int index = 0;

        for (int i = 0; i < Rows; i++){
            for(int j = 0; j < Columns; j++) {
                animationFrames[index++] = tmp[j][i];
            }
        }

        animations.add(new Animation(Speed, animationFrames));
    }

    public static Animation get(int AnimationIndex){
        return animations.get(AnimationIndex);
    }

}
