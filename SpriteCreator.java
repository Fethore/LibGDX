import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/** Created by Angel Fernandez on 7/14/2017 */
public class SpriteCreator {
  
    public static Sprite create(String SpriteLocation){
        Texture texture = new Texture(Gdx.files.internal(SpriteLocation));
        Sprite sprite = new Sprite(texture);
        return sprite;
    }

}
