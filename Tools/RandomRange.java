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
package Ophelia.Tools;

import java.util.Random;

/**
 * Created by Angel Fernandez on 11/22/2017.
 */
public class RandomRange {

    private Random rand;
    private int range;

    public RandomRange() {
        rand = new Random();
        range = 100;
    }

    public boolean get(int Percentage) {
        return getValue() < Percentage;
    }

    public int getValue() {
        return rand.nextInt(range);
    }

    public void setRange(int Range) {
        range = Range;
    }
}
