import { IPartnerAllocatedQuota } from 'app/shared/model/partner-allocated-quota.model';

export interface IPartnerOrder {
  id?: number;
  salesOrderId?: string;
  orderDate?: string;
  serviceNumber?: string;
  orders?: IPartnerAllocatedQuota[];
  partnerId?: number;
}

export const defaultValue: Readonly<IPartnerOrder> = {};
