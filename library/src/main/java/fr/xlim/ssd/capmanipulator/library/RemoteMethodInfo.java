/**
 * RemoteMethodInfo.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library;

/**
 * RemoteMethodInfo
 */
public class RemoteMethodInfo implements Cloneable {

    // two byte hash value for the method (simple name of the method
    // concatenate with it's method descriptor
    private short remoteMethodHash;
    // represents the signature of the remote method (offset to the
    // signature_pool[])
    private short signatureOffset;
    // virtual method token of the remote method in this class
    private short virtualMethodToken;

    /**
     * Get Remote Method Hash
     *
     * @return Remote Method Hash value
     */
    public short getRemoteMethodHash() {
        return remoteMethodHash;
    }

    /**
     * Set Remote Method Hash
     *
     * @param remoteMethodHash new Remote Method Hash value
     */
    public void setRemoteMethodHash(short remoteMethodHash) {
        this.remoteMethodHash = remoteMethodHash;
    }

    /**
     * Get Signature Offset
     *
     * @return Signature Offset value
     */
    public short getSignatureOffset() {
        return signatureOffset;
    }

    /**
     * Set Signature Offset
     *
     * @param signatureOffset new Signature Offset value
     */
    public void setSignatureOffset(short signatureOffset) {
        this.signatureOffset = signatureOffset;
    }

    /**
     * Get Virtual Method Token
     *
     * @return Virtual Method Token value
     */
    public short getVirtualMethodToken() {
        return virtualMethodToken;
    }

    /**
     * Set Virtual Method Token
     *
     * @param virtualMethodToken new Virtual Method Token value
     */
    public void setVirtualMethodToken(short virtualMethodToken) {
        this.virtualMethodToken = virtualMethodToken;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {

        String rl = "\n\t";
        StringBuffer res = new StringBuffer();

        res.append("remote_method_info : {").append(rl);
        res.append("remote_method_hash : ").append(
                Integer.toHexString(remoteMethodHash)).append(rl);
        res.append("signature_offset : ").append(
                Integer.toHexString(signatureOffset)).append(rl);
        res.append("virtual_method_token : ").append(
                Integer.toHexString(virtualMethodToken)).append(rl);

        return res.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteMethodInfo that = (RemoteMethodInfo) o;

        if (remoteMethodHash != that.remoteMethodHash) return false;
        if (signatureOffset != that.signatureOffset) return false;
        return virtualMethodToken == that.virtualMethodToken;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RemoteMethodInfo out = new RemoteMethodInfo();

        out.remoteMethodHash = this.remoteMethodHash;
        out.signatureOffset = this.signatureOffset;
        out.virtualMethodToken = this.virtualMethodToken;

        return out;
    }
}
