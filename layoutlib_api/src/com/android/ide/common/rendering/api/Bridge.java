/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.ide.common.rendering.api;


import java.io.File;
import java.util.EnumSet;
import java.util.Map;

/**
 * Entry point of the Layout Library. Extensions of this class provide a method to compute
 * and render a layout.
 */
public abstract class Bridge {

    public final static int API_CURRENT = 5;

    /**
     * Returns the API level of the layout library.
     * <p/>
     * While no methods will ever be removed, some may become deprecated, and some new ones
     * will appear.
     * <p/>All Layout libraries based on {@link Bridge} return at minimum an API level of 5.
     */
    public abstract int getApiLevel();

    /**
     * Returns an {@link EnumSet} of the supported {@link Capability}.
     * @return an {@link EnumSet} with the supported capabilities.
     *
     */
    public EnumSet<Capability> getCapabilities() {
        return EnumSet.noneOf(Capability.class);
    }

    /**
     * Initializes the Bridge object.
     *
     * @param fontLocation the location of the fonts.
     * @param enumValueMap map attrName => { map enumFlagName => Integer value }. This is typically
     *          read from attrs.xml in the SDK target.
     * @param log a {@link LayoutLog} object. Can be null.
     * @return true if success.
     */
    public boolean init(File fontLocation, Map<String, Map<String, Integer>> enumValueMap,
            LayoutLog log) {
        return false;
    }

    /**
     * Prepares the layoutlib to unloaded.
     */
    public boolean dispose() {
        return false;
    }

    /**
     * Starts a layout session by inflating and rendering it. The method returns a
     * {@link RenderSession} on which further actions can be taken.
     *
     * @return a new {@link RenderSession} object that contains the result of the scene creation and
     * first rendering.
     */
    public RenderSession createSession(Params params) {
        return null;
    }

    /**
     * Clears the resource cache for a specific project.
     * <p/>This cache contains bitmaps and nine patches that are loaded from the disk and reused
     * until this method is called.
     * <p/>The cache is not configuration dependent and should only be cleared when a
     * resource changes (at this time only bitmaps and 9 patches go into the cache).
     * <p/>
     * The project key provided must be similar to the one passed in {@link Params}.
     *
     * @param projectKey the key for the project.
     */
    public void clearCaches(Object projectKey) {

    }
}