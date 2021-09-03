## Change log
----------------------

Version 5.12-SNAPSHOT
-------------

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
- update of dependency menu-actions version to 1.2

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


