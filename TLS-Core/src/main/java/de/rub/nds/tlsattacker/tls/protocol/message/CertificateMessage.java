/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.message;

import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableFactory;
import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableProperty;
import de.rub.nds.tlsattacker.modifiablevariable.bytearray.ModifiableByteArray;
import de.rub.nds.tlsattacker.modifiablevariable.integer.ModifiableInteger;
import de.rub.nds.tlsattacker.tls.constants.HandshakeMessageType;
import de.rub.nds.tlsattacker.tls.protocol.serializer.Serializer;
import de.rub.nds.tlsattacker.tls.workflow.TlsConfig;
import de.rub.nds.tlsattacker.util.ArrayConverter;

/**
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class CertificateMessage extends HandshakeMessage {

    /**
     * certificates length
     */
    @ModifiableVariableProperty(type = ModifiableVariableProperty.Type.LENGTH)
    private ModifiableInteger certificatesLength;

    @ModifiableVariableProperty(format = ModifiableVariableProperty.Format.ASN1, type = ModifiableVariableProperty.Type.CERTIFICATE)
    private ModifiableByteArray x509CertificateBytes;

    public CertificateMessage() {
        super(HandshakeMessageType.CERTIFICATE);
    }

    public CertificateMessage(TlsConfig tlsConfig) {
        super(tlsConfig, HandshakeMessageType.CERTIFICATE);
    }

    public ModifiableInteger getCertificatesLength() {
        return certificatesLength;
    }

    public void setCertificatesLength(ModifiableInteger certificatesLength) {
        this.certificatesLength = certificatesLength;
    }

    public void setCertificatesLength(int length) {
        this.certificatesLength = ModifiableVariableFactory.safelySetValue(certificatesLength, length);
    }

    public ModifiableByteArray getX509CertificateBytes() {
        return x509CertificateBytes;
    }

    public void setX509CertificateBytes(ModifiableByteArray x509CertificateBytes) {
        this.x509CertificateBytes = x509CertificateBytes;
    }

    public void setX509CertificateBytes(byte[] array) {
        this.x509CertificateBytes = ModifiableVariableFactory.safelySetValue(x509CertificateBytes, array);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (certificatesLength != null) {
            sb.append("\n  Certificates Length: ");
            sb.append(certificatesLength.getValue());
        }
        if (x509CertificateBytes != null) {
            sb.append("\n  Certificate:\n");
            sb.append(ArrayConverter.bytesToHexString(x509CertificateBytes.getValue()));
        }
        return sb.toString();
    }
}