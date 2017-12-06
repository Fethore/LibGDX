import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;

/** Created by Angel Fernandez on 7/14/2017 */

public class SpriteList {
    ArrayList<Sprite> sprites;

    public SpriteList(){
        sprites = new ArrayList<Sprite>();
    }

    public void addSprite(String SpriteLocation){
        sprites.add(new Sprite(new Texture(Gdx.files.internal(SpriteLocation))));
    }

    public int getSize(){
        return sprites.size();
    }

    public Sprite getSprite(int SpriteIndex){
        return sprites.get(SpriteIndex);
    }

}
