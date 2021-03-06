/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.service.impl;

import com.alipay.sofa.common.dal.dai.NewManageDao;
import com.alipay.sofa.common.dal.dao.NewDO;
import com.alipay.sofa.facade.NewWriteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * @author qilong.zql
 * @since 2.5.0
 */
public class NewWriteServiceImpl implements NewWriteService {

    @Autowired
    private NewManageDao newManageDao;

    @Override
    public int addNew(String author, String title) throws SQLException {
        try {
            NewDO newDO = new NewDO();
            newDO.setAuthor(author);
            newDO.setTitle(title);
            return newManageDao.insert(newDO);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void deleteNew(String author) throws SQLException {
        try {
            newManageDao.delete(author);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }
}