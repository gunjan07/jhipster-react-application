import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IPartner } from 'app/shared/model/partner.model';
import { getEntities as getPartners } from 'app/entities/partner/partner.reducer';
import { getEntity, updateEntity, createEntity, reset } from './partner-order.reducer';
import { IPartnerOrder } from 'app/shared/model/partner-order.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IPartnerOrderUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IPartnerOrderUpdateState {
  isNew: boolean;
  partnerId: string;
}

export class PartnerOrderUpdate extends React.Component<IPartnerOrderUpdateProps, IPartnerOrderUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      partnerId: '0',
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

    this.props.getPartners();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { partnerOrderEntity } = this.props;
      const entity = {
        ...partnerOrderEntity,
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
    this.props.history.push('/partner-order');
  };

  render() {
    const { partnerOrderEntity, partners, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="jhipsterReactApp.partnerOrder.home.createOrEditLabel">
              <Translate contentKey="jhipsterReactApp.partnerOrder.home.createOrEditLabel">Create or edit a PartnerOrder</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : partnerOrderEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="partner-order-id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="partner-order-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="salesOrderIdLabel" for="partner-order-salesOrderId">
                    <Translate contentKey="jhipsterReactApp.partnerOrder.salesOrderId">Sales Order Id</Translate>
                  </Label>
                  <AvField id="partner-order-salesOrderId" type="text" name="salesOrderId" />
                </AvGroup>
                <AvGroup>
                  <Label id="orderDateLabel" for="partner-order-orderDate">
                    <Translate contentKey="jhipsterReactApp.partnerOrder.orderDate">Order Date</Translate>
                  </Label>
                  <AvField id="partner-order-orderDate" type="text" name="orderDate" />
                </AvGroup>
                <AvGroup>
                  <Label id="serviceNumberLabel" for="partner-order-serviceNumber">
                    <Translate contentKey="jhipsterReactApp.partnerOrder.serviceNumber">Service Number</Translate>
                  </Label>
                  <AvField id="partner-order-serviceNumber" type="text" name="serviceNumber" />
                </AvGroup>
                <AvGroup>
                  <Label for="partner-order-partner">
                    <Translate contentKey="jhipsterReactApp.partnerOrder.partner">Partner</Translate>
                  </Label>
                  <AvInput id="partner-order-partner" type="select" className="form-control" name="partnerId">
                    <option value="" key="0" />
                    {partners
                      ? partners.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/partner-order" replace color="info">
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
  partners: storeState.partner.entities,
  partnerOrderEntity: storeState.partnerOrder.entity,
  loading: storeState.partnerOrder.loading,
  updating: storeState.partnerOrder.updating,
  updateSuccess: storeState.partnerOrder.updateSuccess
});

const mapDispatchToProps = {
  getPartners,
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
)(PartnerOrderUpdate);
