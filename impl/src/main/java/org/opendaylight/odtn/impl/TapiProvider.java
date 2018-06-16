/*
 * Copyright (c) 2018 NTT Communications Corporation, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.odtn.impl;

import com.google.common.util.concurrent.ListenableFuture;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.GetServiceInterfacePointDetailsInput;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.GetServiceInterfacePointDetailsOutput;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.GetServiceInterfacePointDetailsOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.GetServiceInterfacePointListInput;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.GetServiceInterfacePointListOutput;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.GetServiceInterfacePointListOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.TapiCommonService;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.UpdateServiceInterfacePointInput;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.UpdateServiceInterfacePointOutput;
import org.opendaylight.yang.gen.v1.urn.onf.otcc.yang.tapi.common.rev180307.UpdateServiceInterfacePointOutputBuilder;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TapiProvider implements BindingAwareProvider, AutoCloseable,
        TapiCommonService {

    private static final Logger LOG = LoggerFactory.getLogger(TapiProvider.class);

    private RpcRegistration<TapiCommonService> tapiCommonService;

    @Override
    public void close() throws Exception {
        LOG.info("TAPI Common session closed");
        if (tapiCommonService != null) {
            tapiCommonService.close();
        }
    }

    @Override
    public void onSessionInitiated(ProviderContext session) {
        LOG.info("TAPI Common session initiated");
        tapiCommonService = session.addRpcImplementation(TapiCommonService.class, this);
    }

    @Override
    public ListenableFuture<RpcResult<GetServiceInterfacePointDetailsOutput>>
    getServiceInterfacePointDetails(GetServiceInterfacePointDetailsInput input) {
        LOG.info("********** get-service-interface-point-details called!!");
        GetServiceInterfacePointDetailsOutputBuilder output =
                new GetServiceInterfacePointDetailsOutputBuilder();
        return RpcResultBuilder.success(output.build()).buildFuture();
    }

    @Override
    public ListenableFuture<RpcResult<UpdateServiceInterfacePointOutput>>
    updateServiceInterfacePoint(UpdateServiceInterfacePointInput input) {
        LOG.info("********** update-service-interface-point called!!");
        UpdateServiceInterfacePointOutputBuilder output =
                new UpdateServiceInterfacePointOutputBuilder();
        return RpcResultBuilder.success(output.build()).buildFuture();
    }

    @Override
    public ListenableFuture<RpcResult<GetServiceInterfacePointListOutput>>
    getServiceInterfacePointList(GetServiceInterfacePointListInput input) {
        LOG.info("********** get-service-interface-point-list called!!");
        GetServiceInterfacePointListOutputBuilder output =
                new GetServiceInterfacePointListOutputBuilder();
        return RpcResultBuilder.success(output.build()).buildFuture();
    }

}
