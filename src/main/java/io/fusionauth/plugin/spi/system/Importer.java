/*
 * Copyright (c) 2018, FusionAuth, All Rights Reserved
 */
package io.fusionauth.plugin.spi.system;

import java.net.URL;
import java.nio.file.Path;

/**
 * Used to import users and other settings from third party systems.
 *
 * @author Daniel DeGroff
 */
public interface Importer {
  /**
   * Perform the import process. The importer should log errors for debug purposes if <code>false</code> is returned.
   *
   * @return true if the import was successful.
   */
  boolean doImport(Path file, String password);

  /**
   * @return return a description of how the plugin works and what it does.
   */
  String getDescription();

  /**
   * @return return a name of of the logo filename, for example <code>acme.svg</code>.
   */
  String getLogoFileName();

  /**
   * A URL to the logo. Ideally this is a URL to a resource in the plugin jar. It may also be a publicly accessible URL
   * to an image, if this method is utilized know that it may not always exist and then the graphic will not be
   * displayable.
   *
   * @return the path to the logo on the file system.
   */
  URL getLogoURL();

  /**
   * @return return the name of this importer. For example 'Acme Users'.
   */
  String getName();
}
