export interface IProduct {
  id?: number;
  productCode?: string;
  productName?: string;
  productRefId?: string;
}

export const defaultValue: Readonly<IProduct> = {};
