/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.test;

import java.awt.AWTException;

import io.github.astrapi69.junit.jupiter.callback.before.test.GenericThrowableExtension;

/**
 * The class {@link IgnoreAWTExceptionExtension} can be used if the {@link AWTException} should be
 * ignored in the lifecycle from the test annotation. For more information for the lifecycle
 * <a href= "https://junit.org/junit5/docs/current/user-guide/#extensions-execution-order-overview">
 * https://junit.org/junit5/docs/current/user-guide/#extensions-execution-order-overview</a>
 */
public class IgnoreAWTExceptionExtension extends GenericThrowableExtension<AWTException>
{
}
