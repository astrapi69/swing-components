package io.github.astrapi69.swing.check.model;

import io.github.astrapi69.swing.check.model.CheckableItem;
import io.github.astrapi69.swing.check.model.CheckableValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckableListModelBean
{
	CheckableItem<CheckableValue>[] values;
}