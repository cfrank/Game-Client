package tech.henning.client;

import java.math.BigInteger;

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
     * Port for establishing a connection to the game server.
     */
    public static final int GAME_PORT = 43594;

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
    public static final boolean JAGGRAB_ENABLED = true;

    /**
     * Whether or not the network packets should be encrypted.
     */
    public static final boolean RSA_ENABLED = true;

    /**
     * Public key to be used in RSA network encryption.
     */
    public static final BigInteger RSA_PUBLIC_KEY = new BigInteger("65537");

    /**
     * Modulus to be used in the RSA network encryption.
     */
    public static final BigInteger RSA_MODULUS = new BigInteger("141676157752195554735559211145264378937976297633767586286947546254112706939523147177486275692443604121432268321940975736544648897121324600822274740814139678532354218331462623318311718669229065754584663117654839398911927015058106642488139604266125209131471909966472090271413833528051210941238152814528481571969");

}
