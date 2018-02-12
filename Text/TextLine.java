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

import Ophelia.Screen.SuperScreen;
import java.util.ArrayList;

/**
 * Created by Angel Fernandez on 12/11/2017.
 */
public class TextLine {

    private float x = 0;
    private float y = 0;
    private float width = 0;
    private float height = 0;

    private ArrayList<Digit> digits = new ArrayList<Digit>();
    private int textLength = 0;
    private String text;

    public TextLine() {
        text = "";
    }

    public void setText(String Text) {
        text = Text;
        textLength = text.length();
        create();
    }

    public void setText(int Text) {
        setText("" + Text);
    }

    public void setText(float Text) {
        setText("" + Text);
    }

    private void create() {
        for (int i = 0; i < textLength; i++) {
            addDigit(i);
        }
    }

    private void addDigit(int index) {
        char character = text.charAt(index);
        digits.add(new Digit(character));
    }

    public void setBounds(float X, float Y, float Width, float Height) {
        setSize(Width, Height);
        setPosition(X, Y);
        setDigits();
    }

    public void setDigits() {
        if (height * textLength > width) {
            setDigitBounds(width / textLength);
        } else {
            setDigitBounds(height);
        }
    }

    public void setSize(float Width, float Height) {
        width = Width;
        height = Height;
    }

    public void setPosition(float X, float Y) {
        x = X;
        y = Y;
    }

    public void addToScreen(SuperScreen screen, int Z) {
        for (Digit D : digits) {
            screen.setTile(D, Z);
        }
    }

    private void setDigitBounds(float Size) {
        int count = 0;
        for (Digit D : digits) {
            D.setBounds(x + Size * count, y, Size, Size);
            count++;
        }
    }

    public void dispose() {
        for (Digit D : digits) {
            D.remove();
        }
    }

}
