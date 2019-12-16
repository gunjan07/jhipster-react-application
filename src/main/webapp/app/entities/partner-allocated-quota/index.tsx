import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import PartnerAllocatedQuota from './partner-allocated-quota';
import PartnerAllocatedQuotaDetail from './partner-allocated-quota-detail';
import PartnerAllocatedQuotaUpdate from './partner-allocated-quota-update';
import PartnerAllocatedQuotaDeleteDialog from './partner-allocated-quota-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={PartnerAllocatedQuotaUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={PartnerAllocatedQuotaUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={PartnerAllocatedQuotaDetail} />
      <ErrorBoundaryRoute path={match.url} component={PartnerAllocatedQuota} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={PartnerAllocatedQuotaDeleteDialog} />
  </>
);

export default Routes;
