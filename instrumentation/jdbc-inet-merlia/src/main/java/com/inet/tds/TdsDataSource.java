/*
 *
 *  * Copyright 2020 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.inet.tds;

import java.sql.Connection;

import com.newrelic.agent.bridge.datastore.JdbcHelper;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.agent.instrumentation.jdbc.inet.merlia.MerliaDatabaseVendor;

@Weave(type = MatchType.BaseClass)
public abstract class TdsDataSource {

    public Connection getConnection() {
        JdbcHelper.putVendor(getClass(), MerliaDatabaseVendor.INSTANCE);
        return Weaver.callOriginal();
    }

    public Connection getConnection(String user, String password) {
        JdbcHelper.putVendor(getClass(), MerliaDatabaseVendor.INSTANCE);
        return Weaver.callOriginal();
    }
}