package org.eurekaclinical.registry.service.resource;

/*-
 * #%L
 * Eureka! Clinical Registry Service
 * %%
 * Copyright (C) 2017 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.inject.persist.Transactional;
import org.eurekaclinical.common.resource.AbstractRoleResource;
import org.eurekaclinical.registry.service.entity.RoleEntity;
import org.eurekaclinical.standardapis.dao.RoleDao;
import org.eurekaclinical.common.comm.Role;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;

/**
 * Created by akalsan on 10/5/16.
 */
@Path("/protected/roles")
@Transactional
public class RoleResource extends AbstractRoleResource<RoleEntity, Role> {

    @Inject
    public RoleResource(RoleDao<RoleEntity> inRoleDao) {
        super(inRoleDao);
    }

    @Override
    protected Role toComm(RoleEntity roleEntity, HttpServletRequest req) {
        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setName(roleEntity.getName());
        return role;
    }

}
