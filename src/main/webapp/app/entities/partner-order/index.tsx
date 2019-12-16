import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import PartnerOrder from './partner-order';
import PartnerOrderDetail from './partner-order-detail';
import PartnerOrderUpdate from './partner-order-update';
import PartnerOrderDeleteDialog from './partner-order-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={PartnerOrderUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={PartnerOrderUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={PartnerOrderDetail} />
      <ErrorBoundaryRoute path={match.url} component={PartnerOrder} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={PartnerOrderDeleteDialog} />
  </>
);

export default Routes;
