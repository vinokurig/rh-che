/*
 * Copyright (c) 2016-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package com.redhat.che.multitenant.tenantdata;

import org.apache.commons.lang.StringUtils;
import org.eclipse.che.api.core.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UserCheTenantDataValidator {
  private static final Logger LOG = LoggerFactory.getLogger(UserCheTenantDataValidator.class);

  private UserCheTenantDataValidator() {}

  public static void validate(final UserCheTenantData data) throws ValidationException {
    if (data == null) {
      LOG.error("'UserCheTenantData' can not be null");
      throw new ValidationException("'UserCheTenantData' can not be null");
    } else if (StringUtils.isBlank(data.getClusterUrl())) {
      LOG.error("'ClusterUrl' can not be blank: {}", data);
      throw new ValidationException("'ClusterUrl' can not be blank");
    } else if (StringUtils.isBlank(data.getRouteBaseSuffix())) {
      LOG.error("'RouteBaseSuffix' can not be blank: {}", data);
      throw new ValidationException("'RouteBaseSuffix' can not be blank");
    } else if (StringUtils.isBlank(data.getNamespace())) {
      LOG.error("'Namespace' can not be blank: {}", data);
      throw new ValidationException("'Namespace' can not be blank");
    }
  }
}
