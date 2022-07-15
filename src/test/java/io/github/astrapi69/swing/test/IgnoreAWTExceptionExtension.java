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
