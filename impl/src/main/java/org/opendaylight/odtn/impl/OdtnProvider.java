/*
 * Copyright © 2017 Copyright (c) NTT Communications Corporation and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.odtn.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.TapiCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OdtnProvider {

    private static final Logger LOG = LoggerFactory.getLogger(OdtnProvider.class);

    private final DataBroker dataBroker;
    private final RpcProviderRegistry rpcProviderRegistry;

    private RpcRegistration<TapiCommonService> tapiCommonService;

    public OdtnProvider(final DataBroker dataBroker, final RpcProviderRegistry rpcProviderRegistry) {
        this.dataBroker = dataBroker;
        this.rpcProviderRegistry = rpcProviderRegistry;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("******** OdtnProvider Session Initiated ***********");
        tapiCommonService = rpcProviderRegistry.addRpcImplementation(TapiCommonService.class, new TapiProvider());
        LOG.info("OdtnProvider Session Initiated");
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() throws Exception {
        LOG.info("TAPI Common session closed");
        if (tapiCommonService != null) {
            tapiCommonService.close();
        }
    }
}