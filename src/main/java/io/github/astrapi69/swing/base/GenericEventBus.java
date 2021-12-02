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
package io.github.astrapi69.swing.base;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import io.github.astrapi69.design.pattern.observer.event.EventObject;
import io.github.astrapi69.design.pattern.observer.event.EventSource;
import io.github.astrapi69.design.pattern.observer.event.EventSubject;

public final class GenericEventBus
{

	private static final Map<String, EventSource<?>> eventSources = new HashMap<>();

	/** The instance. */
	private static final GenericEventBus instance = new GenericEventBus();

	private GenericEventBus()
	{
	}

	public static EventSource<?> get(final String key)
	{
		return eventSources.get(key);
	}

	public static boolean containsEventSource(final String key)
	{
		return eventSources.containsKey(key);
	}

	@SuppressWarnings("unchecked")
	public static <T> EventSource<EventObject<T>> getEventSource(
		@NonNull final Class<T> eventSourceTypeClass)
	{
		if (!containsEventSource(eventSourceTypeClass.getSimpleName()))
		{
			put(eventSourceTypeClass.getSimpleName(),
				new EventSubject<EventObject<T>>());
		}
		return (EventSource<EventObject<T>>)get(eventSourceTypeClass.getSimpleName());
	}

	public static GenericEventBus getInstance()
	{
		return instance;
	}

	public static synchronized EventSource<?> put(final String key, final EventSource<?> value)
	{
		return eventSources.put(key, value);
	}

}
