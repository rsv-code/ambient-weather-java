/*
 * Copyright 2020 Austin Lehman
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
 */

package com.lehman.ambientweatherjava;

/**
 * Custom exception signal an unexpected HTTP status code was returned.
 */
public class HttpStatusException extends Exception {
    /**
     * Constructor takes the status code and response body.
     * @param Code is an int with the non-200 status code.
     * @param ResponseBody is a String with the HttpResponse body.
     */
    public HttpStatusException(int Code, String ResponseBody) {
        super("HttpResponse returned status code " + Code + ". Response body: " + ResponseBody);
    }
}
