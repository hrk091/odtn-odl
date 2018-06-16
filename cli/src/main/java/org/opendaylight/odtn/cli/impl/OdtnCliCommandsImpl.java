/*
 * Copyright © 2017 Copyright (c) NTT Communications Corporation and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.odtn.cli.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.odtn.cli.api.OdtnCliCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OdtnCliCommandsImpl implements OdtnCliCommands {

    private static final Logger LOG = LoggerFactory.getLogger(OdtnCliCommandsImpl.class);
    private final DataBroker dataBroker;

    public OdtnCliCommandsImpl(final DataBroker db) {
        this.dataBroker = db;
        LOG.info("OdtnCliCommandImpl initialized");
    }

    @Override
    public Object testCommand(Object testArgument) {
        return "This is a test implementation of test-command";
    }
}
