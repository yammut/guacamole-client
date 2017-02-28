/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.guacamole.net.event;

import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.auth.Credentials;
import org.apache.guacamole.net.auth.UserContext;

/**
 * An event which is triggered whenever a tunnel is being connected. The tunnel
 * being connected can be accessed through getTunnel(), and the UserContext
 * associated with the request which is connecting the tunnel can be retrieved
 * with getUserContext().
 */
public class TunnelConnectEvent implements UserEvent, CredentialEvent, TunnelEvent {

    /**
     * The UserContext associated with the request that is connecting the
     * tunnel, if any.
     */
    private UserContext context;

    /**
     * The credentials associated with the request that is connecting the
     * tunnel, if any.
     */
    private Credentials credentials;

    /**
     * The tunnel being connected.
     */
    private GuacamoleTunnel tunnel;

    /**
     * Creates a new TunnelConnectEvent which represents the connecting of the
     * given tunnel via a request associated with the given credentials.
     *
     * @param context The UserContext associated with the request connecting
     *                the tunnel.
     * @param credentials The credentials associated with the request connecting
     *                    the tunnel.
     * @param tunnel The tunnel being connected.
     */
    public TunnelConnectEvent(UserContext context, Credentials credentials,
            GuacamoleTunnel tunnel) {
        this.context = context;
        this.credentials = credentials;
        this.tunnel = tunnel;
    }

    @Override
    public UserContext getUserContext() {
        return context;
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public GuacamoleTunnel getTunnel() {
        return tunnel;
    }

}
