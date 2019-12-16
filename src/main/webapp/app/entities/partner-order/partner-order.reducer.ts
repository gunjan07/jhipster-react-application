import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IPartnerOrder, defaultValue } from 'app/shared/model/partner-order.model';

export const ACTION_TYPES = {
  FETCH_PARTNERORDER_LIST: 'partnerOrder/FETCH_PARTNERORDER_LIST',
  FETCH_PARTNERORDER: 'partnerOrder/FETCH_PARTNERORDER',
  CREATE_PARTNERORDER: 'partnerOrder/CREATE_PARTNERORDER',
  UPDATE_PARTNERORDER: 'partnerOrder/UPDATE_PARTNERORDER',
  DELETE_PARTNERORDER: 'partnerOrder/DELETE_PARTNERORDER',
  RESET: 'partnerOrder/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IPartnerOrder>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type PartnerOrderState = Readonly<typeof initialState>;

// Reducer

export default (state: PartnerOrderState = initialState, action): PartnerOrderState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_PARTNERORDER_LIST):
    case REQUEST(ACTION_TYPES.FETCH_PARTNERORDER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_PARTNERORDER):
    case REQUEST(ACTION_TYPES.UPDATE_PARTNERORDER):
    case REQUEST(ACTION_TYPES.DELETE_PARTNERORDER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_PARTNERORDER_LIST):
    case FAILURE(ACTION_TYPES.FETCH_PARTNERORDER):
    case FAILURE(ACTION_TYPES.CREATE_PARTNERORDER):
    case FAILURE(ACTION_TYPES.UPDATE_PARTNERORDER):
    case FAILURE(ACTION_TYPES.DELETE_PARTNERORDER):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_PARTNERORDER_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_PARTNERORDER):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_PARTNERORDER):
    case SUCCESS(ACTION_TYPES.UPDATE_PARTNERORDER):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_PARTNERORDER):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/partner-orders';

// Actions

export const getEntities: ICrudGetAllAction<IPartnerOrder> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_PARTNERORDER_LIST,
  payload: axios.get<IPartnerOrder>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<IPartnerOrder> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_PARTNERORDER,
    payload: axios.get<IPartnerOrder>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IPartnerOrder> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_PARTNERORDER,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IPartnerOrder> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_PARTNERORDER,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IPartnerOrder> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_PARTNERORDER,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
