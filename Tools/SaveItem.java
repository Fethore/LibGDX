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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * @author angel 1/28/2018
 */
public class SaveItem {

    private Preferences data;
    private String name;

    public void load(String Name) {
        name = Name;
        data = Gdx.app.getPreferences(Name);
    }

    public void setInt(String Key, int Value) {
        data.putInteger(Key, Value);
        data.flush();
    }

    public int getInt(String Key) {
        return data.getInteger(Key);
    }

    public void addInt(String Key, int Amount) {
        int newValue = getInt(Key);
        newValue += Amount;
        setInt(Key, newValue);
    }

    public void removeInt(String Key, int Amount) {
        int newValue = getInt(Key);
        if (newValue - Amount <= 0) {
            setInt(Key, 0);
        } else {
            newValue -= Amount;
            setInt(Key, newValue);
        }
    }

    public void setBoolean(String Key, boolean Value) {
        data.putBoolean(Key, Value);
        data.flush();
    }

    public boolean getBoolean(String Key) {
        return data.getBoolean(Key);
    }

    public void setString(String Key, String Value) {
        data.putString(Key, Value);
        data.flush();
    }

    public String getString(String Key) {
        return data.getString(Key);
    }

}
