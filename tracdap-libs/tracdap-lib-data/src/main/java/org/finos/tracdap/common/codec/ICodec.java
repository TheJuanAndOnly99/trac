/*
 * Copyright 2022 Accenture Global Solutions Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.finos.tracdap.common.codec;

import org.finos.tracdap.common.data.DataBlock;
import org.finos.tracdap.metadata.SchemaDefinition;
import io.netty.buffer.ByteBuf;
import org.apache.arrow.memory.BufferAllocator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow;

public interface ICodec {

    interface Encoder extends Flow.Processor<DataBlock, ByteBuf> {}
    interface Decoder extends Flow.Processor<ByteBuf, DataBlock> {}

    List<String> options();

    String defaultFileExtension();

    Encoder getEncoder(
            BufferAllocator arrowAllocator,
            SchemaDefinition schema,
            Map<String, String> options);

    Decoder getDecoder(
            BufferAllocator arrowAllocator,
            SchemaDefinition schema,
            Map<String, String> options);
}
