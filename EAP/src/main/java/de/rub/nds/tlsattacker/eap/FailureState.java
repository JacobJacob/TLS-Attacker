/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.rub.nds.tlsattacker.eap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author root
 */
public class FailureState implements EapState {

    private static final Logger LOGGER = LogManager.getLogger(FailureState.class);

    EapolMachine eapolMachine;

    int id;

    EapFactory eaptlsfactory = new EapTlsFactory();

    NetworkHandler nic = NetworkHandler.getInstance();

    public FailureState(EapolMachine eapolMachine, int id) {

	this.eapolMachine = eapolMachine;
	this.id = id;

	nic.closeCon();
	LOGGER.info("Failure, Connection refused");
	System.exit(0);

    }

    @Override
    public void send() {

    }

    @Override
    public void sendTLS(byte[] tlspacket) {

    }

    @Override
    public byte[] receive() {
	return null;
    }

    public String getState() {
	return "FailureState";
    }

    @Override
    public int getID() {

	return 0;

    }

}