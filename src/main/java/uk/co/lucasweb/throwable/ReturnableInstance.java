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

/**
 * Represents a function that returns a result.
 *
 * @param <R>
 *         the type of the result of the function
 */
@FunctionalInterface
public interface ReturnableInstance<R> {
    /**
     * Applies the function.
     *
     * @return the function's result.
     * @throws Exception
     *         thrown if an error occurs.
     */
    R apply() throws Exception;
}
