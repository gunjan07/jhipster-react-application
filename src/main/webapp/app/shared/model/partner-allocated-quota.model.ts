import { Moment } from 'moment';

export interface IPartnerAllocatedQuota {
  id?: number;
  quantity?: number;
  startDate?: Moment;
  expiryDate?: Moment;
  lastUpdateTimestamp?: Moment;
  lastUpdateId?: string;
  status?: string;
  productDetailsId?: number;
  partnerOrderId?: number;
}

export const defaultValue: Readonly<IPartnerAllocatedQuota> = {};
