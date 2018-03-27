package tech.henning.client;

public class Configuration {

    /**
     * IP Address or Hostname of the server to establish a connection.
     */
    public static final String SERVER_ADDRESS = "127.0.0.1";

    /**
     * Name of the cache folder located in the users home directory.
     */
    public static final String CACHE_NAME = ".377cache";

    /**
     * Port for establishing a connection to the game.
     */
    public static final int SERVER_PORT = 43594;

    /**
     * Port for establishing a connection to the update server.
     */
    public static final int JAGGRAB_PORT = 43595;

    /**
     * Port for establishing a backup connection to the update
     * server in case the initial JAGGRAB connection fails.
     */
    public static final int HTTP_PORT = 80;

    /**
     * Whether or not the update server should be used.
     */
    public static boolean JAGGRAB_ENABLED = true;

    /**
     * Whether or not the network packets should be encrypted.
     */
    public static final boolean RSA_ENABLED = true;

}
