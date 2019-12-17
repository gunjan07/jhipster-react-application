import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './partner-order.reducer';
import { IPartnerOrder } from 'app/shared/model/partner-order.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IPartnerOrderDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class PartnerOrderDetail extends React.Component<IPartnerOrderDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { partnerOrderEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="jhipsterReactApp.partnerOrder.detail.title">PartnerOrder</Translate> [<b>{partnerOrderEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="submitDate">
                <Translate contentKey="jhipsterReactApp.partnerOrder.submitDate">Submit Date</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={partnerOrderEntity.submitDate} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="lastUpdateTimestamp">
                <Translate contentKey="jhipsterReactApp.partnerOrder.lastUpdateTimestamp">Last Update Timestamp</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={partnerOrderEntity.lastUpdateTimestamp} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="lastUpdateId">
                <Translate contentKey="jhipsterReactApp.partnerOrder.lastUpdateId">Last Update Id</Translate>
              </span>
            </dt>
            <dd>{partnerOrderEntity.lastUpdateId}</dd>
            <dt>
              <span id="salesOrderId">
                <Translate contentKey="jhipsterReactApp.partnerOrder.salesOrderId">Sales Order Id</Translate>
              </span>
            </dt>
            <dd>{partnerOrderEntity.salesOrderId}</dd>
            <dt>
              <Translate contentKey="jhipsterReactApp.partnerOrder.partner">Partner</Translate>
            </dt>
            <dd>{partnerOrderEntity.partnerId ? partnerOrderEntity.partnerId : ''}</dd>
          </dl>
          <Button tag={Link} to="/partner-order" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/partner-order/${partnerOrderEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ partnerOrder }: IRootState) => ({
  partnerOrderEntity: partnerOrder.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(PartnerOrderDetail);
