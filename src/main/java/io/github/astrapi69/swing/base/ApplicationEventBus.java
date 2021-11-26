package io.github.astrapi69.swing.base;

import java.util.HashMap;
import java.util.Map;

import io.github.astrapi69.design.pattern.observer.event.EventObject;
import io.github.astrapi69.design.pattern.observer.event.EventSource;

public class ApplicationEventBus
{

	private static final Map<String, EventSource<?>> eventSources = new HashMap<>();

	/** The instance. */
	private static ApplicationEventBus instance = new ApplicationEventBus();

	public static EventSource<?> get(final String key)
	{
		return eventSources.get(key);
	}

	@SuppressWarnings("unchecked")
	public static <T> EventSource<EventObject<T>> getEventSource(
		final Class<T> eventSourceTypeClass)
	{
		final EventSource<EventObject<T>> eventSource = (EventSource<EventObject<T>>)ApplicationEventBus
			.get(eventSourceTypeClass.getSimpleName());
		return eventSource;
	}

	public static ApplicationEventBus getInstance()
	{
		return instance;
	}

	public static synchronized EventSource<?> put(final String key, final EventSource<?> value)
	{
		return eventSources.put(key, value);
	}

	private ApplicationEventBus()
	{
	}

}
