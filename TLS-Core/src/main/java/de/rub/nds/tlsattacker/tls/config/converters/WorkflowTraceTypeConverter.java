/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.config.converters;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;
import de.rub.nds.tlsattacker.tls.workflow.WorkflowTraceType;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class WorkflowTraceTypeConverter implements IStringConverter<WorkflowTraceType> {

    @Override
    public WorkflowTraceType convert(String value) {
        try {
            return WorkflowTraceType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new ParameterException("Could not parse WorkflowTraceType.");
        }
    }

}
