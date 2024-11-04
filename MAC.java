package io.Lorenzo;

import java.util.Objects;

/**
 * A class to represent a MAC address.
 * A MAC address is a 48-bit number, usually represented as a 12-digit hexadecimal number.
 * The hexadecimal number is usually split into 6 groups of 2 digits, separated by colons.
 * For example, the MAC address 00:0a:95:9d:68:16 is a valid MAC address.
 * This class represents a MAC address as a String, and provides methods to convert it to an int, and to compare it to other MAC addresses.
 * @see <a href="https://en.wikipedia.org/wiki/MAC_address">MAC address</a>
 * @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
 */
public class MAC {
    /**
     * The MAC address, represented as a String.
     * The MAC address must be 17 characters long, and must be in the format XX:XX:XX:XX:XX:XX, where X is a hexadecimal digit.
     */
    private final String mac;

    /**
     * The length of a MAC address, in characters.
     * A MAC address must be 17 characters long, including the colons.
     */
    final int length = 17;

    /**
     * @param mac The MAC address, represented as a String.
     *            The MAC address must be 17 characters long, and must be in the format XX:XX:XX:XX:XX:XX, where X is a hexadecimal digit.
     *            For example, 00:0a:95:9d:68:16 is a valid MAC address.
     *            The MAC address cannot be null.
     *            @throws IllegalArgumentException if the MAC address is null, or is not 17 characters long, or is not in the format XX:XX:XX:XX:XX:XX, where X is a hexadecimal digit.
     *
     */
    public MAC(String mac) {
        if(mac == null)
            throw new IllegalArgumentException("MAC cannot be null");
        if(mac.length() != length)
            throw new IllegalArgumentException("MAC must be 17 characters long");
        if(!mac.matches("^[A-Fa-f0-9]{2}(:[A-Fa-f0-9]{2}){5}$"))
            throw new IllegalArgumentException("MAC must be in the format XX:XX:XX:XX:XX:XX");
        this.mac = mac;
    }

    /**
     * @return The MAC address, represented as a String, without colons.
     *        For example, 00:0a:95:9d:68:16 would be returned as 000a959d6816.
     *        @see #getMacAsLong()
     *
     */
    public String getMacNoColons() {
        return mac.replaceAll(":", "");
    }

    /**
     * @return The MAC address, represented as an int.
     *        For example, 00:0a:95:9d:68:16 would be returned as 1077955622.
     *        @see #getMacNoColons()
     */
    public long getMacAsLong() {
        return Long.parseLong(getMacNoColons(), 16);
    }

    /**
     * @param mac The MAC address to compare this MAC address to.
     *             @throws IllegalArgumentException if the MAC address is null.
     * @return true if this MAC address is greater than the MAC address passed as a parameter, false otherwise.
     */
    public boolean isSmallerThan(MAC mac){
        if(mac == null)
            throw new IllegalArgumentException("MAC cannot be null");
        return getMacAsLong() < mac.getMacAsLong();
    }

    /**
     * @param o The object to compare this MAC address to.
     * @return true if the object is a MAC address, and has the same MAC address as this MAC address, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MAC m)) return false;
        return Objects.equals(mac, m.mac);
    }

    /**
     * @return The hash code of this MAC address.
     *        The hash code is calculated using the MAC address.
     */
    @Override
    public int hashCode() {
        return Objects.hash(mac);
    }

    /**
     * @return The MAC address, represented as a String.
     */
    @Override
    public String toString() {
        return mac;
    }
}
