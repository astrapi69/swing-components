package de.alpharogroup.swing.table;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.base.BasePanel;
import de.alpharogroup.swing.renderer.TableCellButtonRenderer;
import de.alpharogroup.swing.table.editor.TableCellButtonEditor;
import de.alpharogroup.swing.table.model.TableColumnsModel;
import de.alpharogroup.swing.table.model.properties.PropertiesTableModel;
import de.alpharogroup.swing.x.GenericJXTable;

public class TableWithButtonsPanel extends BasePanel<List<KeyValuePair<String, String>>>
{
	private GenericJXTable<KeyValuePair<String, String>> table;

	private JScrollPane scrTable;

	public static void main(final String[] args)
	{
		List<KeyValuePair<String, String>> list = new ArrayList<>();
		list.add(KeyValuePair.<String, String> builder().key("foo").value("overview").build());
		list.add(KeyValuePair.<String, String> builder().key("bar").value("overview").build());
		list.add(KeyValuePair.<String, String> builder().key("bla").value("overview").build());

		TableWithButtonsPanel panel = new TableWithButtonsPanel(BaseModel.ofList(list));

		final JFrame frame = new JFrame();
		frame.addWindowListener(new CloseWindow());
		frame.setTitle("TableWithButtonsPanel");


		frame.add(panel);
		frame.setBounds(0, 0, 1020, 420);
		frame.setVisible(true);

	}

	public TableWithButtonsPanel(Model<List<KeyValuePair<String, String>>> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		PropertiesTableModel tableModel =
			new PropertiesTableModel(TableColumnsModel.builder().columnNames(
				new String[] { "Key", "Value" })
			.canEdit(new boolean[] { false, true })
			.columnClasses(new Class<?>[] { String.class, String.class }).build());
		tableModel.addList(getModelObject());
		table = new GenericJXTable<>(tableModel);
		final TableColumn valueColumn = table.getColumn("Value");
		valueColumn.setCellRenderer(new TableCellButtonRenderer(null, null));
		valueColumn.setCellEditor(new TableCellButtonEditor(new JCheckBox()));
		scrTable = new JScrollPane(table);
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		add(BorderLayout.CENTER, scrTable);
	}
}
