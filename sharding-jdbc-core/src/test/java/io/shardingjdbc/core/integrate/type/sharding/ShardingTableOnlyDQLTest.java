/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingjdbc.core.integrate.type.sharding;

import io.shardingjdbc.core.common.base.AbstractSQLAssertTest;
import io.shardingjdbc.core.common.base.AbstractSQLTest;
import io.shardingjdbc.core.constant.DatabaseType;
import io.shardingjdbc.core.constant.SQLType;
import io.shardingjdbc.core.integrate.jaxb.SQLShardingRule;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ShardingTableOnlyDQLTest extends AbstractShardingTableOnlyTest {
    
    public ShardingTableOnlyDQLTest(final String testCaseName, final String sql, final DatabaseType type, final List<SQLShardingRule> sqlShardingRules) {
        super(testCaseName, sql, type, sqlShardingRules);
    }
    
    @BeforeClass
    public static void cleanAndInitTable() throws Exception {
        AbstractSQLAssertTest.importAllDataSet(AbstractShardingTableOnlyTest.getInitFiles());
    }
    
    @Parameterized.Parameters(name = "{0}In{2}")
    public static Collection<Object[]> dataParameters() {
        return AbstractSQLTest.dataParameters(SQLType.DQL);
    }
}
