import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IProduct } from 'app/shared/model/product.model';
import { getEntities as getProducts } from 'app/entities/product/product.reducer';
import { IPartnerOrder } from 'app/shared/model/partner-order.model';
import { getEntities as getPartnerOrders } from 'app/entities/partner-order/partner-order.reducer';
import { getEntity, updateEntity, createEntity, reset } from './partner-allocated-quota.reducer';
import { IPartnerAllocatedQuota } from 'app/shared/model/partner-allocated-quota.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IPartnerAllocatedQuotaUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IPartnerAllocatedQuotaUpdateState {
  isNew: boolean;
  productDetailsId: string;
  partnerOrderId: string;
}

export class PartnerAllocatedQuotaUpdate extends React.Component<IPartnerAllocatedQuotaUpdateProps, IPartnerAllocatedQuotaUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      productDetailsId: '0',
      partnerOrderId: '0',
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }

    this.props.getProducts();
    this.props.getPartnerOrders();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { partnerAllocatedQuotaEntity } = this.props;
      const entity = {
        ...partnerAllocatedQuotaEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/partner-allocated-quota');
  };

  render() {
    const { partnerAllocatedQuotaEntity, products, partnerOrders, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="jhipsterReactApp.partnerAllocatedQuota.home.createOrEditLabel">
              <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.home.createOrEditLabel">
                Create or edit a PartnerAllocatedQuota
              </Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : partnerAllocatedQuotaEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="partner-allocated-quota-id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="partner-allocated-quota-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="quantityLabel" for="partner-allocated-quota-quantity">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.quantity">Quantity</Translate>
                  </Label>
                  <AvField id="partner-allocated-quota-quantity" type="string" className="form-control" name="quantity" />
                </AvGroup>
                <AvGroup>
                  <Label id="startDateLabel" for="partner-allocated-quota-startDate">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.startDate">Start Date</Translate>
                  </Label>
                  <AvField id="partner-allocated-quota-startDate" type="date" className="form-control" name="startDate" />
                </AvGroup>
                <AvGroup>
                  <Label id="expiryDateLabel" for="partner-allocated-quota-expiryDate">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.expiryDate">Expiry Date</Translate>
                  </Label>
                  <AvField id="partner-allocated-quota-expiryDate" type="date" className="form-control" name="expiryDate" />
                </AvGroup>
                <AvGroup>
                  <Label id="lastUpdateTimestampLabel" for="partner-allocated-quota-lastUpdateTimestamp">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.lastUpdateTimestamp">Last Update Timestamp</Translate>
                  </Label>
                  <AvField
                    id="partner-allocated-quota-lastUpdateTimestamp"
                    type="date"
                    className="form-control"
                    name="lastUpdateTimestamp"
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="lastUpdateIdLabel" for="partner-allocated-quota-lastUpdateId">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.lastUpdateId">Last Update Id</Translate>
                  </Label>
                  <AvField id="partner-allocated-quota-lastUpdateId" type="text" name="lastUpdateId" />
                </AvGroup>
                <AvGroup>
                  <Label id="statusLabel" for="partner-allocated-quota-status">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.status">Status</Translate>
                  </Label>
                  <AvField id="partner-allocated-quota-status" type="text" name="status" />
                </AvGroup>
                <AvGroup>
                  <Label for="partner-allocated-quota-productDetails">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.productDetails">Product Details</Translate>
                  </Label>
                  <AvInput id="partner-allocated-quota-productDetails" type="select" className="form-control" name="productDetailsId">
                    <option value="" key="0" />
                    {products
                      ? products.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label for="partner-allocated-quota-partnerOrder">
                    <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.partnerOrder">Partner Order</Translate>
                  </Label>
                  <AvInput id="partner-allocated-quota-partnerOrder" type="select" className="form-control" name="partnerOrderId">
                    <option value="" key="0" />
                    {partnerOrders
                      ? partnerOrders.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/partner-allocated-quota" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />
                  &nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />
                  &nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  products: storeState.product.entities,
  partnerOrders: storeState.partnerOrder.entities,
  partnerAllocatedQuotaEntity: storeState.partnerAllocatedQuota.entity,
  loading: storeState.partnerAllocatedQuota.loading,
  updating: storeState.partnerAllocatedQuota.updating,
  updateSuccess: storeState.partnerAllocatedQuota.updateSuccess
});

const mapDispatchToProps = {
  getProducts,
  getPartnerOrders,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PartnerAllocatedQuotaUpdate);
