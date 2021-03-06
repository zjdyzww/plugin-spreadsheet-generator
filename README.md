Spreadsheet Generator Plugin
============================

The Spreadsheet Generator Plugin allows a user to export feature attributes from a 3D City Database (3DCityDB) instance as spreadsheets. Supported output formats are CSV and Microsoft Excel.

The Spreadsheet Generator is implemented as plugin for the [3D City Database Importer/Exporter](https://github.com/3dcitydb/importer-exporter). 

License
-------
The Spreadsheet Generator Plugin is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0). See the `LICENSE` file for more details.

Note that releases of the software before version 2.1.0 continue to be licensed under GNU LGPL 3.0. To request a previous release of the 3D City Database Importer/Exporter under Apache License 2.0 create a GitHub issue.

Latest release
--------------
The latest stable release of the Spreadsheet Generator Plugin is 3.1.3.

Download the software [here](https://github.com/3dcitydb/plugin-spreadsheet-generator/releases/download/v3.1.3/plugin-spreadsheet-generator-3.1.3.zip). Previous releases are available from the
 [releases section](https://github.com/3dcitydb/plugin-spreadsheet-generator/releases).

Installation
------------
The Spreadsheet Generator plugin is shipped with the universal installer of the Importer/Exporter tool. When running the setup wizard, you can choose to install the plugin. This is the recommended and easiest way to install the plugin.

Alternatively, you may download the software from the [releases section](https://github.com/3dcitydb/plugin-spreadsheet-generator/releases) (or build it from source) and unzip it into the `plugins` folder within the installation folder of the Importer/Exporter. After a restart of the Importer/Exporter, the Spreadsheet Generator will be ready to be used.

System requirements
-------------------
Each version of the Spreadsheet Generator plugin is built against a specific version of the Importer/Exporter. Please check the release notes of the version you want to use for more information. 

Documentation
-------------
A complete and comprehensive documentation on the Spreadsheet Generator Plugin is installed with the [3D City Database Importer/Exporter](https://github.com/3dcitydb/importer-exporter) and is available [online](https://3dcitydb-docs.readthedocs.io/en/release-v4.2.3/impexp/plugins/spreadsheet.html).

Contributing
------------
* To file bugs found in the software create a GitHub issue.
* To contribute code for fixing filed issues create a pull request with the issue id.
* To propose a new feature create a GitHub issue and open a discussion.

Building
--------
The Spreadsheet Generator plugin uses [Gradle](https://gradle.org/) as build system. To build the plugin from source, clone the repository to your local machine and run the following command from the root of the repository.

    > gradlew installDist
    
The build process will produce the plugin software package under `build/install`. Simply copy the contents of this folder into the `plugins` folder of your Importer/Exporter installation to use the plugin.

Developers
----------
The Spreadsheet Generator plugin has been developed by and with the support from the following cooperation partners:

* [Chair of Geoinformatics, Technical University of Munich](https://www.gis.bgu.tum.de/)
* [virtualcitySYSTEMS GmbH, Berlin](http://www.virtualcitysystems.de/)
* [M.O.S.S. Computer Grafik Systeme GmbH, Taufkirchen](http://www.moss.de/)
