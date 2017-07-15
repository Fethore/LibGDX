import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

/** Created by Mike Fernandez on 7/14/2017 */

public class AnimationList {
    ArrayList<Animation> animations;

    public AnimationList(){
        animations = new ArrayList<Animation>();
    }

    public void addSpriteSheet(String SpriteLocation, int SpriteSheetSize, int SpriteSize){
        
        //CAN ONLY ADD SQUARE SPRITESHEETS AND SQUARE SPRITES
        
        Texture spriteSheet = new Texture(SpriteLocation);

        TextureRegion[][] tmpFrames = TextureRegion.split(spriteSheet, SpriteSize, SpriteSize);

        TextureRegion[] animationFrames = new TextureRegion[4];
        int index = 0;

        for (int i = 0; i < SpriteSheetSize; i++){
            for(int j = 0; j < SpriteSheetSize; j++) {
                animationFrames[index++] = tmpFrames[j][i];
            }
        }

        animations.add(new Animation(1f/4f,animationFrames)); //add to list
    }

    public int getSize(){
        return animations.size();
    }

    public Animation getAnimation(int AnimationIndex){
        return animations.get(AnimationIndex);
    }

}
