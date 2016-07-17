/*
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 *   the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 *   an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 *
 *   Copyright 2016 the original author or authors.
 *
 */

package uk.co.lucasweb.throwable;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Richard Lucas
 */
public class ThrowablesTest {

    private VoidInstance voidInstance = () -> {
        throw new Exception("test");
    };

    private ReturnableInstance<String> returnableInstance = () -> {
        throw new Exception("test");
    };

    @Test
    public void shouldWrapVoidInstanceInIllegalArgumentException() {
        assertThatThrownBy(() -> Throwables.voidInstance(voidInstance, IllegalArgumentException::new))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldWrapReturnableInstanceInIllegalArgumentException() {
        assertThatThrownBy(() -> Throwables.returnableInstance(returnableInstance, IllegalArgumentException::new))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}