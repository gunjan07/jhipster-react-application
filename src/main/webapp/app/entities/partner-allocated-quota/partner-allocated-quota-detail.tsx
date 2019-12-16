import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './partner-allocated-quota.reducer';
import { IPartnerAllocatedQuota } from 'app/shared/model/partner-allocated-quota.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IPartnerAllocatedQuotaDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class PartnerAllocatedQuotaDetail extends React.Component<IPartnerAllocatedQuotaDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { partnerAllocatedQuotaEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.detail.title">PartnerAllocatedQuota</Translate> [
            <b>{partnerAllocatedQuotaEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="quantity">
                <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.quantity">Quantity</Translate>
              </span>
            </dt>
            <dd>{partnerAllocatedQuotaEntity.quantity}</dd>
            <dt>
              <span id="startDate">
                <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.startDate">Start Date</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={partnerAllocatedQuotaEntity.startDate} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="expiryDate">
                <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.expiryDate">Expiry Date</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={partnerAllocatedQuotaEntity.expiryDate} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="status">
                <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.status">Status</Translate>
              </span>
            </dt>
            <dd>{partnerAllocatedQuotaEntity.status}</dd>
            <dt>
              <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.productDetails">Product Details</Translate>
            </dt>
            <dd>{partnerAllocatedQuotaEntity.productDetailsId ? partnerAllocatedQuotaEntity.productDetailsId : ''}</dd>
            <dt>
              <Translate contentKey="jhipsterReactApp.partnerAllocatedQuota.partnerOrder">Partner Order</Translate>
            </dt>
            <dd>{partnerAllocatedQuotaEntity.partnerOrderId ? partnerAllocatedQuotaEntity.partnerOrderId : ''}</dd>
          </dl>
          <Button tag={Link} to="/partner-allocated-quota" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/partner-allocated-quota/${partnerAllocatedQuotaEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ partnerAllocatedQuota }: IRootState) => ({
  partnerAllocatedQuotaEntity: partnerAllocatedQuota.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PartnerAllocatedQuotaDetail);
