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
package Ophelia.Text;

import Ophelia.Tile.ImageTile;
import com.calculatorspace.tapfast.UserFiles.AssetManager;

/**
 * Created by Angel Fernandez on 12/11/2017.
 */
public class Digit extends ImageTile {

    public char character;

    public Digit(char character) {
        this.character = character;
        int ascii = (int) character;
        assign(ascii);
    }

    public void assign(int ASCII) {
        sprite = AssetManager.acsii.get(ASCII);
    }
}
