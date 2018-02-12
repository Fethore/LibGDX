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
import com.badlogic.gdx.math.Vector3;

/**
 * @author angel 1/28/2018
 */
public class TouchControl {

    private Vector3 touch;
    private boolean touchTracker;
    private float counter;

    public TouchControl() {
        touch = new Vector3();
        touchTracker = true;
        counter = 0;
    }

    public boolean isTouched() {
        if (Gdx.input.isTouched()) {
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            return true;
        } else {
            return false;
        }
    }

    public boolean isHeld() {
        if (isTouched() && counter <= 100) {
            return true;
        }
        return false;
    }

    public boolean isTouched(Tile tile) {
        return isTouched() && tile.isTouched();
    }

    public Vector3 getTouch() {
        return touch;
    }
}
