## Change log
----------------------

Version 7.2-SNAPSHOT
-------------

CHANGED:

- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.11.0
- update of dependency jobj-core to new major version 7
- update of dependency gen-tree to new major version 7
- update of test dependency file-worker to new minor version 11.2
- update of test dependency zip4j to new patch version 2.11.2

Version 7.1
-------------

ADDED:

- new constructor with a set from exclude values in class EnumComboBoxModel
- new class GenericComboBoxModel with generic type value
- new class GenericMutableComboBoxModel with generic type value

CHANGED:

- update of gradle to new version 7.5.1
- update of gradle-plugin dependency 'io.freefair.gradle:lombok-plugin' to new version 6.5.1
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.10.0
- update of dependency observer version to new major version 6
- update of dependency state version to new major version 6
- update of dependency silly-collection to new major version 20
- update of dependency silly-bean to new major version 2
- update of dependency silly-math to new minor version 2.2
- update of dependency throwable to new minor version 2.3
- update of test dependency crypt-api to new minor version 8.3
- update of test dependency file-worker to new minor version 11.3
- update of test dependency junit-jupiter to new minor version 5.9.1

Version 7
-------------

ADDED:

- new test dependency org.assertj:assertj-swing in new patch version 3.17.1
- new gui unit test for CheckListPanel with assertj-swing module
- new test dependencies 'org.junit.jupiter:junit-jupiter-api' and 'org.junit.jupiter:junit-jupiter-engine'
- new test dependency 'io.github.astrapi69:junit-jupiter-extensions' for add junit-jupiter-extension classes

CHANGED:

- update of JDK to newer version 11
- update of gradle to new version 7.5
- update of gradle-plugin dependency 'io.freefair.gradle:lombok-plugin' to new version 6.5.0.3
- update of gradle-plugin dependency 'org.ajoberstar.grgit:grgit-gradle' to new version 5.0.0
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.8.0
- update dependency of swing-base-components version to 1.4
- update of test dependency junit-jupiter to new release candidate version 5.9.0-RC1
- update of test dependency junit-jupiter-extensions to new release candidate version 1.1
- removed test dependency testng

Version 6.2
-------------

ADDED:

- new dependency io.github.astrapi69:swing-renderer in new minor version 1.1
- new dependency io.github.astrapi69:component-model in new major version 1

CHANGED:

- removed all related classes that was moved to its own repository
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.5.2

Version 6.1
-------------

ADDED:

- new method the sets the mouse position to the given coordinates x and y in class MouseExtensions

CHANGED:

- update of gradle to new version 7.4.2
- update of lombok dependency to new patch version 1.18.24
- update of randomizer dependency to new minor version to 8.6
- update of gradle-plugin dependency 'io.freefair.gradle:lombok-plugin' to new version 6.4.3
- update of gradle-plugin dependency 'com.github.ben-manes.versions.gradle.plugin' to new version 0.42.0
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.5.0

Version 6
-------------

ADDED:

- new JListExtensions class for operation on JList component
- new decorator class for JComboBox that encapsulate a property model and bind it to it
- new decorator class for JMPasswordField that encapsulate a property model and bind it to it
- new decorator class for JTextArea that encapsulate a property model and bind it to it
- integration from gradle plugin spotless

CHANGED:

- update gradle to new version 7.3.3
- removed class GenericJTable
- removed help components that have moved to swing-base-components module
- return type of setPropertyModel to (this) for chaining on initialization
- replaced all occurrences of GenericJTable with GenericJXTable
- deleted deprecated class GenericJTable
- replaced locally test class Permission with the same name class from test-objects dependency
- moved wizard component to its own repository and deleted corresponding classes
- moved base components to its own repository and deleted corresponding classes
- moved table components to its own repository and deleted corresponding classes
- moved tree component to its own repository and deleted corresponding classes
- moved splashscreen components to its own repository and deleted corresponding classes
- moved CheckedModelBean class from test to main module
- moved CheckableListModelBean class from test to main module
- update dependency of jobj-core version to 5.3
- update dependency of randomizer version to 8.5
- update dependency of com.github.ben-manes.versions.gradle.plugin to new version 0.41.0
- update of test dependency test-objects version to 5.7
- update of test dependency testng version to 7.5
- moved components that accepts a BaseModel to package 'io.github.astrapi69.swing.component'
- update of model-data dependency to new version 1.12
- renamed package actions to action
- renamed package panels to panel
- removed editor config gradle plugin

Version 5.12
-------------

ADDED:

- new methods for click left, middle and right mouse click button
- new dependency io.github.astrapi69:icon-img-extensions for icon and image process
- new extension class JOptionPaneExtensions for JOptionPane created
- new methods for maximize the window of the given component
- new method in extension class JOptionPaneExtensions that gets the option from a given JOptionPane
- new class TreeNodeFactory for generate DefaultMutableTreeNode object from TreeNode object
- new class JXTreeElement created for use as model class with JTree and JXTree objects
- new class JXTreeNodeCellRenderer that uses the JXTreeElement for render in JTree and JXTree objects
- new test dependency io.github.astrapi69:silk-icon-theme for test the classes for icon factory and extensions
- new test dependency org.freedesktop.tango:tango-icon-theme for test the classes for icon factory and extensions
- improve gradle build performance by adding new gradle parameters for caching, parallel, configure on demand and file watch
- new mouse double click listener created for handle single or double clicks only once
- new generic event bus class created

CHANGED:

- update gradle to new version 7.3
- update of lombok version to 1.18.22
- update lombok gradle-plugin dependency of io.freefair.gradle:lombok-plugin to new version 6.3.0
- update of dependency throw-able to new version to 1.7
- update of silly-collections version to 18
- update of file-worker version to 8.1
- update dependency of jobj-core version to 5
- removed all related image and icon classes and methods that was moved to its own repository icon-img-extensions
- removed the button and the icon button factory class

Version 5.11
-------------

ADDED:

- new enum for the size of the help panel
- new methods in DialogExtensions for show information messages

Version 5.10
-------------

ADDED:

- new decorator class for JMSpinner that encapsulate a property model and bind it to it
- new methods in class RobotExtensions for mouse move with argument of thread priority
- new method in ClipboardExtensions for copy a given string to the clipboard
- new class SuffixFileFilter for a generic FileFilter implementation with file suffix
- new class JFileChooserExtensions for extension methods for the JFileChooser
- new classes for show a simple help dialog

CHANGED:

- update gradle to new version 7.2
- update gradle-plugin dependency of io.freefair.gradle:lombok-plugin to new version 6.1.0
- update of dependency menu-actions to new version to 1.2

Version 5.9
-------------

ADDED:

- new abstact class AbstractMutableComboBoxModel for a generic combobox model that can add and remove elements from the combobox dynamically
- new decorator class for JCheckBox that encapsulate a property model and bind it to it
- new class StringMutableComboBoxModel created that extends the AbstractMutableComboBoxModel
- new constructors to BaseDialog and PanelDialog for create dialog with window as owner
- new decorator class for JTextField that encapsulate a property model and bind it to it

CHANGED:

- update of dependency randomizer version to 8.3
- update of dependency model-object version to 1.10
- update of dependency model-type-safe version to 1.10
- update of test dependency test-objects version to 5.5
- removed the call of SwingUtilities#updateComponentTreeUI in factory method newHelpWindow in class BaseDesktopMenu

Version 5.8
-------------

CHANGED:

- update of test dependency zip4j to new version 2.9.0
- update of dependency commons-lang3 to new version 3.12.0
- remove obsolete classes that are tagged as deprecated
- remove of unused plugin interfaces

Version 5.7
-------------

ADDED:

- new factory class MenuFactory for create Menu and JToolbar objects
- new factory class SplashScreenFactory for create SplashScreen objects
- new factory class IconButtonFactory for create JButton objects with Icon objects
- new factory class ButtonFactory for create JButton objects

CHANGED:

- update gradle to new version 7.1
- changed all dependencies from groupid de.alpharogroup to new groupid io.github.astrapi69
- update gradle-plugin dependency of gradle.plugin.com.hierynomus.gradle.plugins:license-gradle-plugin to new version 0.16.1
- moved menu related classes to its own repository menu-actions
- tagged all menu related classes as deprecated

Version 5.6
-------------

ADDED:

- new abstract class DocumentListenerAdapter for the interface DocumentListener
- missing model initialization added in BaseDialog

CHANGED:

- changed to new package io.github.astrapi69
- update gradle to new version 6.9
- update of lombok version to 1.18.20

Version 5.5
-------------

ADDED:

- new method for infinite mouse movement
- new method for mouse movement with a specified time

CHANGED:

- update gradle to new version 6.8
- update of lombok version to 1.18.16
- update dependency of randomizer version to 8
- update of silly-collections version to 8.4
- update dependency of com.github.ben-manes.versions.gradle.plugin to new version 0.36.0
- replaced lombok gradle plugin from io.franzbecker:gradle-lombok to recommended io.freefair.gradle:lombok-plugin in version 5.3.0
- update dependency of itextpdf version to 5.5.13.2
- update dependency of jobj-core version to 3.6
- update dependency of zip4j version to 2.6.4

Version 5.4.1
-------------

ADDED:

- new dependency de.alpharogroup:throw-able in version 1.4
- new class ProgressBarSplashScreen created

CHANGED:

- bugfix for hashcode recursive call in ApplicationFrame and BaseDesktopMenu fixed
- bugfix of image load in BaseSplashScreen classes fixed
- removed progress bar from BaseSplashScreen

Version 5.4
-------------

ADDED:

- new getter method for the valueMap in class EnumComboBoxModel
- new BaseSplashScreen Window created
- new .editorconfig file created from old eclipse configuration file
- new gradle plugin for format source code with editorconfig

CHANGED:

- update gradle to new version 6.6.1

Version 5.3
-------------

ADDED:

- new callback method in BaseDesktopMenu for a refresh the state of the menu items

CHANGED:

- update of model-object version to 1.8
- update of model-type-safe version to 1.8
- extracted project properties to gradle.properties
- visibility of method initValueMap changed to protected in class EnumComboBoxModel

Version 5.2
-------------

ADDED:

- gradle as build system
- new classes DynamicTableColumnsModel and DynamicTableModel created

CHANGED:

- removed maven build system and all related files
- removed all lombok dependent imports
- update of file-worker version to 5.4
- update of randomizer version to 6.7

Version 5.1
-------------

ADDED:

- new method created that create a configuration directory file object with factory method that can be overwritten
- new Factory class for TableCellButtonRenderer created
- new callback methods in TableCellButtonEditor created
- new class RequestFocusListener created for request the focus from a given component
- new panel class created for display the output of the system out and error stream
- new factory method for JDialog with parent component created
- new factory methods for JSplitPane component created
- new application frame with split pane created

CHANGED:

- update of parent version to 4.6
- update of email-tails version to 5.0.2
- update of file-worker version to 5.1
- update of jcommons-lang version to 5.1.1
- update of test-objects version to 5.0.1
- update of silly-collections version to 5.1

Version 5.0.2
-------------

CHANGED:

- update of email-tails version to 5.0.1
- removed deprecated plaf actions
- removed logging dependencies

Version 5.0.1
-------------

CHANGED:

- removed logging dependencies

Version 5
-------------

ADDED:

- new extension class for show dialogs created
- new methods created for get screen informations like the screen id

CHANGED:

- update of parent version to 4.5
- update of email-tails version to 5
- update of test-objects version to 5
- update of file-worker version to 5.0.1
- update of jcommons-lang version to 5.1
- update of vintage-time version to 5.1
- update of randomizer-core version to 5.6
- update of silly-collections version to 5
- update of model-data version to 1.6.2
- update of design-patterns version to 4.14
- update of jobject-extensions version to 2.5
- update of gen-tree version to 4.12

Version 4.31
-------------

ADDED:

- new base class for application frame
- new base class for desktop menu
- new action classes created for help, donate, info and license created
- new factory method for JMenuItem created

CHANGED:

- update of parent version to 4.2
- update of silly-collections version to 4.35
- update of jcommons-lang version to 5
- update of file-worker version to 5
- tagged 'look and feel' enum and action classes as deprecated

Version 4.30
-------------

ADDED:

- new 'look and feel'action classes created

CHANGED:

- moved 'look and feel' enum and action classes to new package
- new enum constants added to LookAndFeels enum

Version 4.29
-------------

ADDED:

- new JTreePanel class created for JTree
- new RangeDocument class created for constraint the range of a document
- new RegularExpressionDocument class created for constraint the input of a document with the given regular expression
- new NumberValuesDocument class created for constraint the input of a document only for numbers separated with comma or semicolon
- new Table Editor for delete rows created
- new lombok configuration file created

CHANGED:

- update of parent version to 4.1
- update of jcommons-lang version to 4.35
- update of file-worker version to 4.23

Version 4.28
-------------

ADDED:

- new DocumentFilter for integer arrays created

CHANGED:

- update of parent version to 4
- update of jcommons-lang version to 4.34
- update of email-tails version to 4.18
- update of file-worker version to 4.22
- update of test-objects version to 4.28
- update of vintage-time version to 4.12
- update of randomizer-core version to 5.4
- update of silly-collections version to 4.33
- update of jobject-extensions version to 1.12

Version 4.27
-------------

CHANGED:

- update of parent version to 3.11
- removed unneeded .0 at the end of version
- update of email-tails version to 4.17
- update of file-worker version to 4.20
- update of jcommons-lang version to 4.31.0
- update of randomizer-core version to 5.3
- update of silly-collections version to 4.28.0

Version 4.26.0
-------------

ADDED:

- created new class EnumComboBoxModel for enums

CHANGED:

- update of parent version to 3.10.0
- new constructors for class AbstractComboBoxModel and added null check and not empty check for given collections
- update of test-objects version to 4.24.0
- update of jcommons-lang version to 4.30.0
- update of randomizer-core version to 5.2.0
- update of jobject-extensions version to 1.10.0

Version 4.25.0
-------------

ADDED:

- this changelog file
- created PULL_REQUEST_TEMPLATE.md file
- created CODE_OF_CONDUCT.md file
- created CONTRIBUTING.md file
- created new eclipse maven launch scripts
- created new BaseDialog component

CHANGED:

- update of parent version
- update of documentation of README.md
- unit tests extended
