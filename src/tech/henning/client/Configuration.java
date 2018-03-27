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

    /**
     * Public key to be used in RSA network encryption.
     */
    public static final BigInteger RSA_PUBLIC_KEY = new BigInteger("65537");

    public static BigInteger JAGEX_MODULUS = new BigInteger("" +
            "122160430267449798360978854041191852368220518230394092579319523064196043297582796633947085783119585744206711526658432067003468760585446552721871622840788528486712970246999980397054139494332878352882978447726827719186528904097434708997584641726572284342202641622966960383866799686443535696434839673638141409593" +
            "");
}
