import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './partner-order.reducer';
import { IPartnerOrder } from 'app/shared/model/partner-order.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IPartnerOrderProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export class PartnerOrder extends React.Component<IPartnerOrderProps> {
  componentDidMount() {
    this.props.getEntities();
  }

  render() {
    const { partnerOrderList, match } = this.props;
    return (
      <div>
        <h2 id="partner-order-heading">
          <Translate contentKey="jhipsterReactApp.partnerOrder.home.title">Partner Orders</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="jhipsterReactApp.partnerOrder.home.createLabel">Create a new Partner Order</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          {partnerOrderList && partnerOrderList.length > 0 ? (
            <Table responsive aria-describedby="partner-order-heading">
              <thead>
                <tr>
                  <th>
                    <Translate contentKey="global.field.id">ID</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerOrder.salesOrderId">Sales Order Id</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerOrder.orderDate">Order Date</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerOrder.serviceNumber">Service Number</Translate>
                  </th>
                  <th>
                    <Translate contentKey="jhipsterReactApp.partnerOrder.partner">Partner</Translate>
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {partnerOrderList.map((partnerOrder, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${partnerOrder.id}`} color="link" size="sm">
                        {partnerOrder.id}
                      </Button>
                    </td>
                    <td>{partnerOrder.salesOrderId}</td>
                    <td>{partnerOrder.orderDate}</td>
                    <td>{partnerOrder.serviceNumber}</td>
                    <td>{partnerOrder.partnerId ? <Link to={`partner/${partnerOrder.partnerId}`}>{partnerOrder.partnerId}</Link> : ''}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${partnerOrder.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.view">View</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${partnerOrder.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.edit">Edit</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${partnerOrder.id}/delete`} color="danger" size="sm">
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
              <Translate contentKey="jhipsterReactApp.partnerOrder.home.notFound">No Partner Orders found</Translate>
            </div>
          )}
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ partnerOrder }: IRootState) => ({
  partnerOrderList: partnerOrder.entities
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PartnerOrder);
