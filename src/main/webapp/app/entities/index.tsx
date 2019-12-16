import React from 'react';
import { Switch } from 'react-router-dom';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Product from './product';
import Partner from './partner';
import PartnerOrder from './partner-order';
import PartnerAllocatedQuota from './partner-allocated-quota';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}product`} component={Product} />
      <ErrorBoundaryRoute path={`${match.url}partner`} component={Partner} />
      <ErrorBoundaryRoute path={`${match.url}partner-order`} component={PartnerOrder} />
      <ErrorBoundaryRoute path={`${match.url}partner-allocated-quota`} component={PartnerAllocatedQuota} />
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
