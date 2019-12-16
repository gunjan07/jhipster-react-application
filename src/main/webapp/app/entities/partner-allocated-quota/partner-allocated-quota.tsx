import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './partner-allocated-quota.reducer';
import { IPartnerAllocatedQuota } from 'app/shared/model/partner-allocated-quota.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IPartnerAllocatedQuotaProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export class PartnerAllocatedQuota extends React.Component<IPartnerAllocatedQuotaProps> {
  componentDidMount() {
    this.props.getEntities();
  }

  render() {
    const { partnerAllocatedQuotaList, match } = this.props;
    return (
      <div>
        <h2 id="partner-allocated-quota-heading">
          <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.home.title">Partner Allocated Quotas</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.home.createLabel">Create a new Partner Allocated Quota</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          {partnerAllocatedQuotaList && partnerAllocatedQuotaList.length > 0 ? (
            <Table responsive aria-describedby="partner-allocated-quota-heading">
              <thead>
                <tr>
                  <th>
                    <Translate contentKey="global.field.id">ID</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.quantity">Quantity</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.startDate">Start Date</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.expiryDate">Expiry Date</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.status">Status</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.productDetails">Product Details</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.partnerOrder">Partner Order</Translate>
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {partnerAllocatedQuotaList.map((partnerAllocatedQuota, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${partnerAllocatedQuota.id}`} color="link" size="sm">
                        {partnerAllocatedQuota.id}
                      </Button>
                    </td>
                    <td>{partnerAllocatedQuota.quantity}</td>
                    <td>
                      <TextFormat type="date" value={partnerAllocatedQuota.startDate} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={partnerAllocatedQuota.expiryDate} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{partnerAllocatedQuota.status}</td>
                    <td>
                      {partnerAllocatedQuota.productDetailsId ? (
                        <Link to={`product/${partnerAllocatedQuota.productDetailsId}`}>{partnerAllocatedQuota.productDetailsId}</Link>
                      ) : (
                        ''
                      )}
                    </td>
                    <td>
                      {partnerAllocatedQuota.partnerOrderId ? (
                        <Link to={`partner-order/${partnerAllocatedQuota.partnerOrderId}`}>{partnerAllocatedQuota.partnerOrderId}</Link>
                      ) : (
                        ''
                      )}
                    </td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${partnerAllocatedQuota.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.view">View</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${partnerAllocatedQuota.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.edit">Edit</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${partnerAllocatedQuota.id}/delete`} color="danger" size="sm">
                          <FontAwesomeIcon icon="trash" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.delete">Delete</Translate>
                          </span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            <div className="alert alert-warning">
              <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.home.notFound">No Partner Allocated Quotas found</Translate>
            </div>
          )}
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ partnerAllocatedQuota }: IRootState) => ({
  partnerAllocatedQuotaList: partnerAllocatedQuota.entities
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PartnerAllocatedQuota);
