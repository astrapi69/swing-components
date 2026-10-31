# swing-components

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/swing-components/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/swing-components/actions/workflows/gradle.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/swing-components)](https://central.sonatype.com/artifact/io.github.astrapi69/swing-components)
[![Javadocs](https://javadoc.io/badge2/io.github.astrapi69/swing-components/javadoc.svg)](http://www.javadoc.io/doc/io.github.astrapi69/swing-components)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/swing-components?branch=develop)](https://hitsofcode.com/github/astrapi69/swing-components/view?branch=develop)

</div>

Several swing components and utilities

- Buffered images to pdf file

<!--Place this tag in your head or just before your close body tag.
<script async defer src="https://buttons.github.io/buttons.js"></script>
Place this tag where you want the button to render.
Peace!-->

> Please support this project by simply putting a Github
> <a class="github-button" href="https://github.com/lightblueseas/swing-components" data-icon="octicon-star" aria-label="Star lightblueseas/swing-components on GitHub">Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## License

The source code comes under the liberal MIT License, making swing-components great for all types of applications.


## gradle dependency

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of swing-components:

define version in file gradle.properties

```
swingComponentsVersion=9
```

or in build.gradle ext area

```
    swingComponentsVersion = "9"
```

and then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:swing-components:$swingComponentsVersion")
```

## Maven dependency

The library is on Maven Central. Check out [Maven Central](https://central.sonatype.com/artifact/io.github.astrapi69/swing-components) for the latest release.

Add the following maven dependency to your project `pom.xml` if you want to import the core functionality of swing-components:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- SWING-COMPONENTS version -->
        <swing-components.version>9</swing-components.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- SWING-COMPONENTS DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>swing-components</artifactId>
                <version>${swing-components.version}</version>
            </dependency>
            ...
        </dependencies>

## Semantic Versioning

The versions of swing-components are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for swing-components are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/swing-components/fork](https://github.com/lightblueseas/swing-components/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/swing-components/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the swing-components developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/swing-components/issues).

## Note

No animals were harmed in the making of this library.

## Support this project

If swing-components is useful to you, a star on [GitHub](https://github.com/astrapi69/swing-components) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Similar projects

Here is a list of awesome swing projects:

Open Source:

 * [SystemTray](https://github.com/dorkbox/SystemTray) Cross-platform SystemTray support for Swing/AWT, GtkStatusIcon, and AppIndicator on Java 8+
 * [Java Generic Swing Application Framework](https://github.com/pgdurand/jGAF) Generic Swing Application Framework (jGAF) is a library designed to facilitate the creation of cross-platorm graphical applications for the Oracle Java Platform.
 * [OpenSwing](http://oswing.sourceforge.net/) OpenSwing is an open-source suite of advanced graphics components based on Swing toolkit
 * [JCalendar](https://toedter.com/jcalendar/) JCalendar is a Java date chooser bean for graphically picking a date.
 * [FlexDock](https://github.com/opencollab/flexdock) FlexDock is a Java docking framework for use in cross-platform Swing applications
 * [DockingFrames](https://github.com/Benoker/DockingFrames) DockingFrames is an open source Java Swing docking framework, licenced under LGPL 2.1
 * [oxbow](https://github.com/eugener/oxbow) Swing UI Enhacements
 * [Darcula](https://github.com/bulenkov/Darcula) Darcula Look and Feel
 * [Spring Rich Client](https://sourceforge.net/projects/spring-rich-c/files/spring-rich-c/)(not maintainend anymore) The Spring Rich Client Project (RCP) is a sub-project of The Spring Framework.
 * [utils4swing](http://www.fuin.org/utils4swing/index.html) A small Java 1.4 compatible library that aims to ease the pain of some Swing development tasks
 * [utils4swing5](http://www.fuin.org/utils4swing5/index.html) A small Java 1.6 library that aims to ease the pain of some Swing development tasks.
 * [RSyntaxTextArea](https://github.com/bobbylight/RSyntaxTextArea) A syntax highlighting, code folding text editor for Java Swing applications.
 * [Java Swing examples](https://github.com/aterai/java-swing-tips) A collection of swing component examples
 * [swing-beansbinding](https://github.com/JFormDesigner/swing-beansbinding) JFormDesigner swing-beansbinding supports the Beans Binding specification (JSR 295)
 * [KControls](https://github.com/k33ptoo/KControls) Java Swing Custom Controls
 * [Material-UI-Swing](https://github.com/atarw/material-ui-swing) A modern, Material Design UI for Java Swing
 * [pumpernickel](https://github.com/mickleness/pumpernickel) This Java project includes classes related to desktop applications, Swing, performance, image processing, data structures, and other misc topics~~~~

Commercial

 * [JIDE](http://www.jidesoft.com/) JIDE Software is a professional Java UI component provider.
 * [Swing Depot: Components Suites](http://www.javadesktop.org/rollups/components/) commercial swing components

Projects that list projects of awesome swing projects
 * [awesome-swing](https://github.com/parubok/awesome-swing) A list of frameworks, libraries and software for the Java Swing GUI toolkit.

## Credits

|**Maven Central**|
|     :---:      |
|[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/swing-components?style=for-the-badge)](https://central.sonatype.com/artifact/io.github.astrapi69/swing-components)|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadocs](https://javadoc.io/badge2/io.github.astrapi69/swing-components/javadoc.svg)](http://www.javadoc.io/doc/io.github.astrapi69/swing-components)|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
