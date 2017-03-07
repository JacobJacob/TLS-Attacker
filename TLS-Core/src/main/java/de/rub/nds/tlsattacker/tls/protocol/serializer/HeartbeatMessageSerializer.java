/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.serializer;

import de.rub.nds.tlsattacker.tls.constants.HeartbeatByteLength;
import de.rub.nds.tlsattacker.tls.protocol.message.HeartbeatMessage;
import de.rub.nds.tlsattacker.tls.protocol.parser.*;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class HeartbeatMessageSerializer extends ProtocolMessageSerializer<HeartbeatMessage> {

    private final HeartbeatMessage message;

    public HeartbeatMessageSerializer(HeartbeatMessage message) {
        super(message);
        this.message = message;
    }

    @Override
    public byte[] serializeProtocolMessageContent() {
        appendByte(message.getHeartbeatMessageType().getValue());
        appendInt(message.getPayloadLength().getValue(), HeartbeatByteLength.PAYLOAD_LENGTH);
        appendBytes(message.getPayload().getValue());
        appendBytes(message.getPadding().getValue());
        return getAlreadySerialized();
    }

}