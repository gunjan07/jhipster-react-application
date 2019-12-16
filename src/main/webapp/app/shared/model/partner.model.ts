import { IPartnerOrder } from 'app/shared/model/partner-order.model';

export interface IPartner {
  id?: number;
  partnerName?: string;
  partnerCode?: string;
  partnerOrders?: IPartnerOrder[];
}

export const defaultValue: Readonly<IPartner> = {};
