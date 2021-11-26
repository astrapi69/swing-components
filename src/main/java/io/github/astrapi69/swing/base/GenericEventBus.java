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
	private static GenericEventBus instance = new GenericEventBus();

	public static EventSource<?> get(final String key)
	{
		return eventSources.get(key);
	}

	public static boolean containsEventSource(final String key) {
		return eventSources.containsKey(key);
	}

	@SuppressWarnings("unchecked")
	public static <T> EventSource<EventObject<T>> getEventSource(
		@NonNull
		final Class<T> eventSourceTypeClass)
	{
		if (!containsEventSource(eventSourceTypeClass.getSimpleName()))
		{
			GenericEventBus.getInstance().put(eventSourceTypeClass.getSimpleName(),
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

	private GenericEventBus()
	{
	}

}
