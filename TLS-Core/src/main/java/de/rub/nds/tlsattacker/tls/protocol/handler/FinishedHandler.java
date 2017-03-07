/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.handler;

import de.rub.nds.tlsattacker.tls.protocol.message.FinishedMessage;
import de.rub.nds.tlsattacker.tls.protocol.parser.FinishedMessageParser;
import de.rub.nds.tlsattacker.tls.protocol.preparator.FinishedMessagePreparator;
import de.rub.nds.tlsattacker.tls.protocol.preparator.Preparator;
import de.rub.nds.tlsattacker.tls.protocol.serializer.FinishedMessageSerializer;
import de.rub.nds.tlsattacker.tls.protocol.serializer.Serializer;
import de.rub.nds.tlsattacker.tls.workflow.TlsContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 * @author Philip Riese <philip.riese@rub.de>
 */
public class FinishedHandler extends HandshakeMessageHandler<FinishedMessage> {

    private static final Logger LOGGER = LogManager.getLogger(FinishedHandler.class);

    public FinishedHandler(TlsContext tlsContext) {
        super(tlsContext);
    }

    @Override
    protected FinishedMessageParser getParser(byte[] message, int pointer) {
        return new FinishedMessageParser(pointer, message);
    }

    @Override
    protected Preparator getPreparator(FinishedMessage message) {
        return new FinishedMessagePreparator(tlsContext, message);
    }

    @Override
    protected Serializer getSerializer(FinishedMessage message) {
        return new FinishedMessageSerializer(message);
    }

    @Override
    protected void adjustTLSContext(FinishedMessage message) {
        // Nothing to do
    }

}