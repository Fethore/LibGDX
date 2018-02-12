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

/**
 * Created by Angel Fernandez on 11/17/2017.
 */
public class Timer {

    private long startTime;
    private long endTime;
    private boolean paused = false;

    public void start() {
        startTime = System.nanoTime();
    }

    public void reset() {
        startTime = 0;
    }

    public boolean isDone() {
        if (paused) {
            return true;
        } else {
            return endTime <= getNano();
        }
    }

    public void pause() {
        this.paused = true;
    }

    public boolean isPaused() {
        return paused;
    }

    //==================================================================== GET CURRENT
    public float getNano() {
        return System.nanoTime() - startTime;
    }

    //==================================================================== SET END TIME
    public void setEndNano(long NanoSeconds) {
        endTime = NanoSeconds;
    }

    public void setEndMicro(long MicroSeconds) {
        setEndNano(MicroSeconds * 1000);
    }

    public void setEndMilli(long MilliSeconds) {
        setEndMicro(MilliSeconds * 1000);
    }

    public void setEndSec(long Seconds) {
        setEndMilli(Seconds * 1000);
    }

}
