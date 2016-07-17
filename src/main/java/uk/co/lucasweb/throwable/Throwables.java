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
 * Invokes a function wrapping any checked exceptions thrown by the function in an unchecked exception.
 *
 * @author Richard Lucas
 */
public final class Throwables {

    private Throwables() {
        // hides the default constructor
    }

    /**
     * Executes a {@link VoidInstance} wrapping any excpetions with the specified exception wrapper.
     *
     * @param voidInstance
     *         a function that does not return a result
     * @param wrapper
     *         an exception wrapper
     * @param <E>
     *         the type of the exception that should be used to wrap the original exception.
     * @throws E
     *         if the function throws an exception
     */
    public static <E extends Throwable> void voidInstance(VoidInstance voidInstance, ExceptionWrapper<E> wrapper) throws E {
        try {
            voidInstance.apply();
        } catch (Exception e) {
            throw wrapper.wrap(e);
        }
    }

    /**
     * Executes a {@link ReturnableInstance} wrapping any exceptions with the specified exception wrapper.
     *
     * @param returnableInstance
     *         a function that returns a result
     * @param wrapper
     *         the exception wrapper
     * @param <R>
     *         the type of the result of the function
     * @param <E>
     *         the type of the exception that should be used to wrap the original exception.
     * @return the result of the function.
     * @throws E
     *         if the function throws an exception.
     */
    public static <R, E extends Throwable> R returnableInstance(ReturnableInstance<R> returnableInstance, ExceptionWrapper<E> wrapper) throws E {
        try {
            return returnableInstance.apply();
        } catch (Exception e) {
            throw wrapper.wrap(e);
        }
    }


}
