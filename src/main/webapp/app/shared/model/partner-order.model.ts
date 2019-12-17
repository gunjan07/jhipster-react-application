import { Moment } from 'moment';
import { IPartnerAllocatedQuota } from 'app/shared/model/partner-allocated-quota.model';

export interface IPartnerOrder {
  id?: number;
  submitDate?: Moment;
  lastUpdateTimestamp?: Moment;
  lastUpdateId?: string;
  salesOrderId?: string;
  orders?: IPartnerAllocatedQuota[];
  partnerId?: number;
}

export const defaultValue: Readonly<IPartnerOrder> = {};
