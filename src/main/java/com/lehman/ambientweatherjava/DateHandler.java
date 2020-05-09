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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * This is a deserializer for use with Jackson to convert
 * long epoch times into Java Date objects.
 */
public class DateHandler extends StdDeserializer<Date> {
    public DateHandler() {
        this(null);
    }

    public DateHandler(Class<?> vc) {
        super(vc);
    }

    /**
     * Performs the deserialization of the long epoch time into a Java Date object.
     * @param p
     * @param ctxt
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return new Date(p.getLongValue());
    }
}
